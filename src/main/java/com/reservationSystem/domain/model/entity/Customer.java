package com.reservationSystem.domain.model.entity;

import com.reservationSystem.domain.model.SingleKeyBaseEntity;
import com.reservationSystem.domain.model.valueobject.CustomerId;
import com.reservationSystem.domain.model.valueobject.Email;
import com.reservationSystem.domain.model.valueobject.Phone;
import lombok.Getter;

@Getter
public class Customer extends SingleKeyBaseEntity<CustomerId> {
    private String name;
    private Email email;
    private Phone phone;

    private Customer() {
        // SingleKeyBaseEntityのコンストラクタを呼び出す
        super();
    }

    // 顧客IDを取得するメソッド
    public Integer getCustomerId() {
        return id.value();
    }

    // 顧客名を変更するメソッド
    public void changeName(String name) {
        this.name = name;
    }

    // メールアドレスを変更するメソッド
    public void changeEmail(Email email) {
        this.email = email;
    }

    // 電話番号を変更するメソッド
    public void changePhone(Phone phone) {
        this.phone = phone;
    }
}