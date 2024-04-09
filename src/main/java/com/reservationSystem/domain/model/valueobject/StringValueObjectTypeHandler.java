package com.reservationSystem.domain.model.valueobject;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringValueObjectTypeHandler<T extends StringValueObject> extends BaseTypeHandler<T> {

    private final Class<T> type;

    public StringValueObjectTypeHandler(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.value());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return value == null ? null : valueOf(value);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return value == null ? null : valueOf(value);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return value == null ? null : valueOf(value);
    }

    private T valueOf(String value) {
        try {
            return type.getDeclaredConstructor(String.class).newInstance(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate " + type.getSimpleName() + " with value: " + value, e);
        }
    }
}