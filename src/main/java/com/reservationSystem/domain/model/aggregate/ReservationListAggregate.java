package com.reservationSystem.domain.model.aggregate;

import com.reservationSystem.domain.model.valueobject.ReservationId;
import com.reservationSystem.domain.model.valueobject.CustomerId;
import com.reservationSystem.domain.model.valueobject.StoreId;
import com.reservationSystem.domain.model.valueobject.ServiceId;
import com.reservationSystem.domain.model.valueobject.Duration;
import com.reservationSystem.domain.model.valueobject.Email;
import com.reservationSystem.domain.model.valueobject.Phone;
import com.reservationSystem.domain.model.valueobject.Price;
import lombok.Getter;

@Getter
public class ReservationListAggregate {
    private final ReservationId id;
    private final CustomerId customerId;
    private final StoreId storeId;
    private final ServiceId serviceId;
    private final String customerName;
    private final Email email;
    private final Phone phone;
    private final String storeName;
    private final String storeAddress;
    private final String serviceName;
    private final Duration serviceDuration;
    private final Price servicePrice;

    public ReservationListAggregate(ReservationId id, CustomerId customerId, StoreId storeId, ServiceId serviceId,
            String customerName, Email email, Phone phone,
            String storeName, String storeAddress, String serviceName,
            Duration serviceDuration, Price servicePrice) {
        this.id = id;
        this.customerId = customerId;
        this.storeId = storeId;
        this.serviceId = serviceId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.serviceName = serviceName;
        this.serviceDuration = serviceDuration;
        this.servicePrice = servicePrice;
    }
}