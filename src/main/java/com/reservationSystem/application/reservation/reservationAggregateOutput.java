package com.reservationSystem.application.reservation;

import com.reservationSystem.domain.model.valueobject.*;

import lombok.Builder;

@Builder
public record reservationAggregateOutput(
        ReservationId id, // 予約ID
        CustomerId customerId, // 顧客ID
        StoreId storeId, // 店舗ID
        ServiceId serviceId, // サービスID
        String customerName, // 顧客名
        Email email, // 顧客のメールアドレス
        Phone phone, // 顧客の電話番号
        String storeName, // 店舗名
        String storeAddress, // 店舗の住所
        String serviceName, // サービス名
        Duration serviceDuration, // サービスの期間
        Price servicePrice // サービスの価格
) {
}