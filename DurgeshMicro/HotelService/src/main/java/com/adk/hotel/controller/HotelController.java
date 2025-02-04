package com.adk.hotel.controller;

import com.adk.hotel.entities.Hotel;
import com.adk.hotel.services.HotelService;
import com.adk.hotel.services.impl.HotelServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JSqlParserUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ankushk
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels()
    {
        return ResponseEntity.ok().body(hotelService.getAllHotels());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelByid(@PathVariable String hotelId) {
        System.out.println("getHotelByid controller called with id " + hotelId);
        return ResponseEntity.ok().body(hotelService.getHotelById(hotelId));
    }

}
