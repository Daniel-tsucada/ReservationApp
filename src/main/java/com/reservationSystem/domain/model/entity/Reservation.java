package com.reservationSystem.domain.model.entity;

import com.reservationSystem.domain.model.SingleKeyBaseEntity;
import com.reservationSystem.domain.model.valueobject.ReservationId;
import com.reservationSystem.domain.model.valueobject.Status;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Reservation extends SingleKeyBaseEntity<ReservationId> {
    private Integer customerId;
    private Integer serviceId;
    private LocalDateTime reservationDate;
    private Status status;

    private Reservation() {
        super();
    }

    // public Integer getReservationId() {
    // return id.value();
    // }

    public void confirmReservation() {
        this.status = Status.CONFIRMED;
    }

    public void cancelReservation() {
        this.status = Status.CANCELLED;
    }
}