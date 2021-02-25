package com.nsw.fsjavapostgresreact.controllers;

import com.nsw.fsjavapostgresreact.person.Person;
import com.nsw.fsjavapostgresreact.person.services.PersonService;
import com.nsw.fsjavapostgresreact.lounge.Lounge;
import com.nsw.fsjavapostgresreact.lounge.services.LoungeService;
import com.nsw.fsjavapostgresreact.room.Room;
import com.nsw.fsjavapostgresreact.room.services.RoomService;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "api/actions")
public class ActionsController {
    private final PersonService personService;

    @Autowired
    public ActionsController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/organizeAtendees")
    public void organizeAtendees(){
        boolean we = true;
    }
}