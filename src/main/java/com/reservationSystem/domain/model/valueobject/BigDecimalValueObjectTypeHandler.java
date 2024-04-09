package com.reservationSystem.domain.model.valueobject;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;

public class BigDecimalValueObjectTypeHandler<T extends BigDecimalValueObject> extends BaseTypeHandler<T> {

    private final Class<T> type;

    public BigDecimalValueObjectTypeHandler(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setBigDecimal(i, parameter.value());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        BigDecimal value = rs.getBigDecimal(columnName);
        return value == null ? null : valueOf(value);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        BigDecimal value = rs.getBigDecimal(columnIndex);
        return value == null ? null : valueOf(value);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        BigDecimal value = cs.getBigDecimal(columnIndex);
        return value == null ? null : valueOf(value);
    }

    private T valueOf(BigDecimal value) {
        try {
            return type.getDeclaredConstructor(BigDecimal.class).newInstance(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate " + type.getSimpleName() + " with value: " + value, e);
        }
    }
}