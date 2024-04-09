package com.reservationSystem.domain.model;

import lombok.Getter;

@Getter
public abstract class CompositeKeyBaseEntity<KEY> {
    protected KEY key;

    protected CompositeKeyBaseEntity() {
    }

    public void setKey(KEY key) {
        if (this.key == null) {
            this.key = key;
        } else {
            throw new IllegalStateException("IDは一度だけ設定できます");
        }
    }

}
