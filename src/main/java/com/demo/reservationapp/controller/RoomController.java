package com.demo.reservationapp.controller;

import com.demo.reservationapp.exception.RoomNotFoundException;
import com.demo.reservationapp.model.Room;
import com.demo.reservationapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }

    @GetMapping("/rooms/{id}")
    public Room getRoomById(@PathVariable(value = "id") Long roomId) throws RoomNotFoundException {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));
    }

    @PutMapping("/rooms/{id}")
    public Room updateRoom(@PathVariable(value = "id") Long roomId,
                           @Valid @RequestBody Room roomDetails) throws RoomNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));

        room.setRoomName(roomDetails.getRoomName());
        room.setBedNumber(roomDetails.getBedNumber());
        room.setSingleBedNumber(roomDetails.getSingleBedNumber());
        room.setDoubleBedNumber(roomDetails.getDoubleBedNumber());
        room.setRoomPrice(roomDetails.getRoomPrice());
        room.setRoomAvialable(roomDetails.isRoomAvialable());
        room.setLocationCity(roomDetails.getLocationCity());
        room.setLocationStreet(roomDetails.getLocationStreet());

        Room updatedRoom = roomRepository.save(room);

        return updatedRoom;
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable(value = "id") Long roomId) throws RoomNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));

        roomRepository.delete(room);

        return ResponseEntity.ok().build();
    }
}
