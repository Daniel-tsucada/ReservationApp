package com.reservationSystem.domain.model.valueobject;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LongValueObjectTypeHandler<T extends LongValueObject> extends BaseTypeHandler<T> {

    private final Class<T> type;

    public LongValueObjectTypeHandler(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter.value());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Long value = rs.getLong(columnName);
        return value == null ? null : valueOf(value);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Long value = rs.getLong(columnIndex);
        return value == null ? null : valueOf(value);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Long value = cs.getLong(columnIndex);
        return value == null ? null : valueOf(value);
    }

    private T valueOf(Long value) {
        try {
            return type.getDeclaredConstructor(Long.class).newInstance(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate " + type.getSimpleName() + " with value: " + value, e);
        }
    }
}