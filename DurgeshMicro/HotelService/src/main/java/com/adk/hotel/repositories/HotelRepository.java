package com.adk.hotel.repositories;

import com.adk.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ankushk
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel,String > {
}
