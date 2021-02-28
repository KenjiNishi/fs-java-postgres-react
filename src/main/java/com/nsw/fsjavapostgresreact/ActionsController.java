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

    public int LRIndex = 0;
    public int ERIndex = 0;
    public int personCount = 0;
    public boolean eventRoomSet = false;
    public int maxRoomCap = 99999999;

    @GetMapping(path = "/organizeAtendees")
    public void organizeAtendees(){
        List<Person> atendees = personService.getPersons();
        List<Room> eventRooms = roomService.getRooms();
        List<Lounge> loungeRooms = loungeService.getLounges();

        for(Room eventRoom : eventRooms) {
            if (eventRoom.getCapacity() < this.maxRoomCap){
                this.maxRoomCap = eventRoom.getCapacity();
            }
        };
        //this.maxRoomCap +=1;
        if(this.maxRoomCap*eventRooms.size() < atendees.size()){
            throw new IllegalStateException(
                "Too many people to adhere to distribution requirements. Reduce atendees list!"
            );
        }

        atendees.forEach(person ->{
            // Lounge Rooms
            if (this.personCount<this.maxRoomCap)
            {
            person.setLoungeRoom(loungeRooms.get(this.LRIndex));
            personService.updatePerson(person.getId(), person);
            this.LRIndex += 1;
            if(this.LRIndex >= loungeRooms.size()){this.LRIndex=0;}
            
            // Event Rooms
            Room room = eventRooms.get(this.ERIndex);
            person.setEventRoom1(room);

            this.ERIndex += 1;
            if(this.ERIndex >= eventRooms.size()){this.ERIndex=0;}

            if (this.personCount%2==0){
                // Remain on same room
                person.setLastName("remain");
                person.setEventRoom2(room);
            }
            else{
                person.setLastName("chang");
                person.setEventRoom2(eventRooms.get(this.ERIndex));
            }
            personService.updatePerson(person.getId(), person);}
            this.personCount += 1;
            // for(int r = 0; r < eventRooms.size(); r++) {
            //     Room eventRoom = eventRooms.get(r);
            //     if (this.eventRoomSet){break;}
            //     else if(eventRoom.getCurrentOccupation1() < this.maxRoomCap){
            //         this.eventRoomSet = true;
            //         this.ERIndex = this.ERIndex + 1;
            //     };
            //  };
         });
         
        
    }
}