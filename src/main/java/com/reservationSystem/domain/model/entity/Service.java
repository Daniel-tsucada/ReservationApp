package com.reservationSystem.domain.model.entity;

import com.reservationSystem.domain.model.SingleKeyBaseEntity;
import com.reservationSystem.domain.model.valueobject.ServiceId;
import com.reservationSystem.domain.model.valueobject.Duration;
import com.reservationSystem.domain.model.valueobject.Price;
import lombok.Getter;

@Getter
public class Service extends SingleKeyBaseEntity<ServiceId> {
    private Integer storeId;
    private String serviceName;
    private Duration duration;
    private Price price;

    private Service() {
        super();
    }

    public Integer getServiceId() {
        return id.value();
    }

    public void changeServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void changeDuration(Duration duration) {
        this.duration = duration;
    }

    public void changePrice(Price price) {
        this.price = price;
    }
}