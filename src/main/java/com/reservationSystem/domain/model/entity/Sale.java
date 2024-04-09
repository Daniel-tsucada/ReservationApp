package com.reservationSystem.domain.model.entity;

import com.reservationSystem.domain.model.SingleKeyBaseEntity;
import com.reservationSystem.domain.model.valueobject.SaleId;
import com.reservationSystem.domain.model.valueobject.Price;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Sale extends SingleKeyBaseEntity<SaleId> {
    private Integer storeId;
    private LocalDate saleDate;
    private Price totalAmount;

    private Sale() {
        super();
    }

    public void changeStore(Integer storeId) {
        this.storeId = storeId;
    }

    public void changeSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public void changeTotalAmount(Price totalAmount) {
        this.totalAmount = totalAmount;
    }
}