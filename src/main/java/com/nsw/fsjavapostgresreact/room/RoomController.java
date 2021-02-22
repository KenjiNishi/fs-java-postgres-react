package com.nsw.fsjavapostgresreact.room.controllers;

import com.nsw.fsjavapostgresreact.room.Room;
import com.nsw.fsjavapostgresreact.room.services.RoomService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/id/{roomId}")
    public Room getRoom(@PathVariable("roomId") Long roomId){
        return roomService.getRoom(roomId);
    }

    @GetMapping("/all")
	public List<Room> getRooms(){
		return roomService.getRooms();
	}

    @PostMapping("/save")
    public void registerRoom(@RequestBody Room room){
        roomService.addNewRoom(room);

    }

    @PutMapping(path = "/update/{roomId}")
    public void registerRoom(
            @PathVariable("roomId") Long roomId,
            @RequestBody Room roomData){
                roomService.updateRoom(roomId, roomData);
            }

    @DeleteMapping(path="/delete/{roomId}")
    public void deleteRoom(@PathVariable("roomId") Long roomId){
        roomService.deleteRoom(roomId);
    }

    
}
