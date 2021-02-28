package com.nsw.fsjavapostgresreact.controllers;

import com.nsw.fsjavapostgresreact.models.Person;
import com.nsw.fsjavapostgresreact.services.PersonService;
import com.nsw.fsjavapostgresreact.models.Lounge;
import com.nsw.fsjavapostgresreact.services.LoungeService;
import com.nsw.fsjavapostgresreact.models.Room;
import com.nsw.fsjavapostgresreact.services.RoomService;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "api/actions")
public class ActionsController {
    private final PersonService personService;
    private final RoomService roomService;
    private final LoungeService loungeService;

    @Autowired
    public ActionsController(PersonService personService, RoomService roomService, LoungeService loungeService) {
        this.personService = personService;
        this.roomService = roomService;
        this.loungeService = loungeService;
    }

    // Auxiliary variables
    public int LRIndex = 0;
    public int ERIndex = 0;
    public int personCount = 0;
    public int maxRoomCap = 0;

    @GetMapping(path = "/organizeAtendees")
    public void organizeAtendees(){
        List<Person> atendees = personService.getPersons();
        List<Room> eventRooms = roomService.getRooms();
        List<Lounge> loungeRooms = loungeService.getLounges();

        // Calculate maximum room capacity based on lowest capacity room.
        for(Room eventRoom : eventRooms) {
            if (this.maxRoomCap==0){this.maxRoomCap = eventRoom.getCapacity();}
            if (eventRoom.getCapacity() < this.maxRoomCap){
                this.maxRoomCap = eventRoom.getCapacity();
            }
        };
        //this.maxRoomCap +=1;
        // if(this.maxRoomCap*eventRooms.size() < atendees.size()){
        //     throw new IllegalStateException(
        //         "Too many people to adhere to distribution requirements. Reduce atendees list!"
        //     );
        // }

        atendees.forEach(person ->{
            if (this.personCount<this.maxRoomCap)
            {
                // Lounge Rooms
                person.setLoungeRoom(loungeRooms.get(this.LRIndex));
                personService.updatePerson(person.getId(), person);
                this.LRIndex += 1;
                if(this.LRIndex >= loungeRooms.size()){this.LRIndex=0;}
                
                // Event Rooms
                Room room = eventRooms.get(this.ERIndex);
                person.setEventRoom1(room);

                this.ERIndex += 1;
                if(this.ERIndex >= eventRooms.size()){this.ERIndex=0;}

                // Half the people will change rooms after the coffe break
                if (this.personCount%2==0){
                    person.setEventRoom2(room);
                }
                else{
                    person.setEventRoom2(eventRooms.get(this.ERIndex));
                }

                // Save
                personService.updatePerson(person.getId(), person);
            }
            this.personCount += 1;
        });
         
        
    }
}