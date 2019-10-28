package com.aguerrerodev.hotelreservations.controller.repository;

import java.util.Date;
import java.util.List;

import com.aguerrerodev.hotelreservations.models.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * ReservationRepository
 */
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query(
        "Select r from Reservation r where r.created_date =:created_date and r.finish_date =:finish_date"
    )
    public List<Reservation> find(@Param("created_date") Date created_date,@Param("finish_date") Date finish_date);
    
}