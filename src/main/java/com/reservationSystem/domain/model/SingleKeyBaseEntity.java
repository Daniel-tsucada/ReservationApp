package com.reservationSystem.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
public abstract class SingleKeyBaseEntity<ID> {
    // JsonIgnoreアノテーションを付与することで、JSON変換時にIDフィールドを無視する
    @JsonIgnore
    protected ID id;

    protected SingleKeyBaseEntity() {
    }

    public void setId(ID id) {
        if (this.id == null) {
            this.id = id;
        } else {
            throw new IllegalStateException("IDは一度だけ設定できます");
        }
    }

}
