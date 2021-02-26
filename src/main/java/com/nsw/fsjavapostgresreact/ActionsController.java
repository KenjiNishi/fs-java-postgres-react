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

    public int ERIndex = 0;
    public int LRIndex = 0;
    public boolean eventRoomSet = false;
    public boolean loungeSet = false;
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
        this.maxRoomCap +=1;

        atendees.forEach(person ->{
            Person updated = person.setLoungeRoom(loungeRooms.get(this.LRIndex));
            personService.updatePerson(person.getId(), updated);
            this.LRIndex += 1;
            if(this.LRIndex == loungeRooms.size()){this.LRIndex=0;}
            

            // for(int r = 0; r < eventRooms.size(); r++) {
            //     Room eventRoom = eventRooms.get(r);
            //     if (this.eventRoomSet){break;}
            //     else if(eventRoom.getCurrentOccupation1() < this.ERIndex){
            //         this.eventRoomSet = true;
            //         this.ERIndex = this.ERIndex + 1;
            //     };
            //  };
         });
        
    }
}