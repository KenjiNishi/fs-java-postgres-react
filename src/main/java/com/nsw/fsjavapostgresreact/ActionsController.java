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

    @GetMapping(path = "/organizeAtendees")
    public void organizeAtendees(){
        List<Person> atendees = personService.getPersons();
        List<Room> eventRooms = roomService.getRooms();
        List<Lounge> loungeRooms = loungeService.getLounges();

        int maxRoomCap = eventRooms.get(0).getCapacity();
        for(Room eventRoom : eventRooms) {
            if (eventRoom.getCapacity() < maxRoomCap){
                maxRoomCap = eventRoom.getCapacity();
            }
        };

        boolean loungeSet = false;
        boolean eventRoomSet = false;
        int currentEROccupation = 0;
        int currentLROccupation = 0;

        atendees.forEach(person ->{
            loungeRooms.forEach(lounge ->{
                int ee= 1;
             });
         });
        
    }
}