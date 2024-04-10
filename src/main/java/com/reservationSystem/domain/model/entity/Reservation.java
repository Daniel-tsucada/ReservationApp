package com.reservationSystem.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.reservationSystem.domain.model.SingleKeyBaseEntity;
import com.reservationSystem.domain.model.valueobject.CustomerId;
import com.reservationSystem.domain.model.valueobject.ReservationId;
import com.reservationSystem.domain.model.valueobject.ServiceId;
import com.reservationSystem.domain.model.valueobject.Status;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonPropertyOrder({ "reservationId", "customerId", "serviceId", "reservationDate", "status" })
public class Reservation extends SingleKeyBaseEntity<ReservationId> {
    private CustomerId customerId;
    private ServiceId serviceId;
    private LocalDateTime reservationDate;
    private Status status;

    private Reservation() {
        super();
    }

    public Integer getReservationId() {
        return id.value();
    }

    // Integer型を返すように修正
    public int getCustomerId() {
        return customerId.value();
    }

    // Integer型を返すように修正
    public int getServiceId() {
        return serviceId.value();
    }

    public void confirmReservation() {
        this.status = Status.CONFIRMED;
    }

    public void cancelReservation() {
        this.status = Status.CANCELLED;
    }
}
