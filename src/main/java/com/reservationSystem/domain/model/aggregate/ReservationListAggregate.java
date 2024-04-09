package com.reservationSystem.domain.model.aggregate;

import com.reservationSystem.domain.model.valueobject.ReservationId;
import com.reservationSystem.domain.model.valueobject.CustomerId;
import com.reservationSystem.domain.model.valueobject.StoreId;
import com.reservationSystem.domain.model.valueobject.ServiceId;
import com.reservationSystem.domain.model.valueobject.Duration;
import com.reservationSystem.domain.model.valueobject.Price;
import lombok.Getter;

@Getter
public class ReservationListAggregate {
    private final ReservationId id;
    private final CustomerId customerId;
    private final StoreId storeId;
    private final ServiceId serviceId;
    private final String customerName;
    private final String customerEmail;
    private final String customerPhone;
    private final String storeName;
    private final String storeAddress;
    private final String serviceName;
    private final Duration serviceDuration;
    private final Price servicePrice;

    public ReservationListAggregate(ReservationId id, CustomerId customerId, StoreId storeId, ServiceId serviceId,
            String customerName, String customerEmail, String customerPhone,
            String storeName, String storeAddress, String serviceName,
            Duration serviceDuration, Price servicePrice) {
        this.id = id;
        this.customerId = customerId;
        this.storeId = storeId;
        this.serviceId = serviceId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.serviceName = serviceName;
        this.serviceDuration = serviceDuration;
        this.servicePrice = servicePrice;
    }
}