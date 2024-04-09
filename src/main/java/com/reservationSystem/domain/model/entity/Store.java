package com.reservationSystem.domain.model.entity;

import com.reservationSystem.domain.model.SingleKeyBaseEntity;
import com.reservationSystem.domain.model.valueobject.StoreId;
import lombok.Getter;

@Getter
public class Store extends SingleKeyBaseEntity<StoreId> {
    private String storeName;
    private String address;

    private Store() {
        super();
    }

    public Integer getStoreId() {
        return id.value();
    }

    public void changeStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void changeAddress(String address) {
        this.address = address;
    }
}