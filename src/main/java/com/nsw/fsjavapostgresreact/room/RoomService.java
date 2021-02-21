package com.nsw.fsjavapostgresreact.room.services;

import com.nsw.fsjavapostgresreact.room.Room;
import com.nsw.fsjavapostgresreact.room.repository.RoomRepository;

import java.util.Objects;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

	@Autowired
	public RoomService(RoomRepository roomRepository){
		this.roomRepository = roomRepository;
	}

	public List<Room> getRooms(){
		return roomRepository.findAll();
	}

	public Room getRoom(Long roomId){
		Room room = roomRepository.findById(roomId)
			.orElseThrow(() -> new IllegalStateException("Room id does not exist: " + roomId));
		return room;
	}

	public void addNewRoom(Room room){
		Optional<Room> checkClone = roomRepository.findByName(room.getName());
		if (checkClone.isPresent()) { throw new IllegalStateException("Room with same name already exists!");}
		roomRepository.save(room);
	}

	public void  deleteRoom(Long roomId){
		boolean exists = roomRepository.existsById(roomId);
		if(!exists){ throw new IllegalStateException("Room id does not exist: " + roomId);}
		roomRepository.deleteById(roomId);
	}

	@Transactional
	public void updateRoom(Long roomId, Room updated){
		Room room = roomRepository.findById(roomId)
			.orElseThrow(() -> new IllegalStateException("Room id does not exist: " + roomId));

			if (updated.getName()!=null && updated.getName().length()>0 &&
					!Objects.equals(room.getName(), updated.getName()))
				{
				room.setName(updated.getName());
				}
			if (!Objects.equals(room.getCapacity(), updated.getCapacity()))
				{
				room.setCapacity(updated.getCapacity());
				}
	}
}
