package com.reservationSystem.domain.repository;

import com.reservationSystem.domain.model.entity.Reservation;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reservationSystem.domain.model.valueobject.ReservationId;

@Mapper
public interface ReservationRepository {
    void create(Reservation reservation);

    void update(Reservation reservation);

    void delete(ReservationId reservationId);

    List<Reservation> findAll();
}