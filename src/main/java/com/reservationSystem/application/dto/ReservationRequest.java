package com.reservationSystem.application.dto;

import com.reservationSystem.domain.model.entity.Customer;
import com.reservationSystem.domain.model.entity.Service;
import com.reservationSystem.domain.model.valueobject.Status;
import lombok.Value;
import java.time.LocalDate;

@Value
public class ReservationRequest {
    Customer customer;
    Service service;
    LocalDate reservationDate;
    Status status;
}