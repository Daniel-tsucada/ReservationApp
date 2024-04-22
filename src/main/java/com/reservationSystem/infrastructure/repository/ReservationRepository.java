package com.reservationSystem.infrastructure.repository;

import com.reservationSystem.domain.model.entity.Reservation;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reservationSystem.domain.model.valueobject.ReservationId;

@Mapper
public interface ReservationRepository {
    void createReservation(Reservation reservation); // メソッド名を変更

    void update(Reservation reservation);

    void delete(ReservationId reservationId);

    List<Reservation> findAll();
}
