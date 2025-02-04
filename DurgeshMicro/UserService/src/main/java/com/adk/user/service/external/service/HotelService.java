package com.adk.user.service.external.service;

import com.adk.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ankushk
 */
@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

    @GetMapping({"/hotels/{hotelId}"})
    Hotel getHotel (@PathVariable String hotelId);
}
