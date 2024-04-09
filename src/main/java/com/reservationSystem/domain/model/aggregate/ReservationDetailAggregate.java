package com.reservationSystem.domain.model.aggregate;

import com.reservationSystem.domain.model.entity.Customer;
import com.reservationSystem.domain.model.entity.Store;
import com.reservationSystem.domain.model.entity.Service;
import com.reservationSystem.domain.model.valueobject.ReservationId;
import com.reservationSystem.domain.model.valueobject.Status;
import com.reservationSystem.domain.model.SingleKeyBaseEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationDetailAggregate extends SingleKeyBaseEntity<ReservationId> {
    private Customer customer;
    private Store store;
    private Service service;
    private LocalDateTime reservationDate;
    private Status status;

    private ReservationDetailAggregate() {
        super();
    }

    // DBから取得したデータをドメインオブジェクトに変換する
    public static ReservationDetailAggregate reconstruct(
            ReservationId reservationId,
            Customer customer,
            Store store,
            Service service,
            LocalDateTime reservationDate,
            Status status) {
        ReservationDetailAggregate reservationDetail = new ReservationDetailAggregate();
        reservationDetail.id = reservationId;
        reservationDetail.customer = customer;
        reservationDetail.store = store;
        reservationDetail.service = service;
        reservationDetail.reservationDate = reservationDate;
        reservationDetail.status = status;
        return reservationDetail;
    }
}

// String customerName = reservationDetail.getCustomer().getName();