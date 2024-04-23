package com.reservationSystem.domain.model.valueobject;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class RecordBigDecimalTypeHandler<T extends ValueObject<BigDecimal>> extends BaseTypeHandler<T> {

    private final Method valueMethod;
    private final Method ofMethod;

    public RecordBigDecimalTypeHandler(Class<T> recordClass) {
        try {
            this.valueMethod = recordClass.getMethod("value");
            this.ofMethod = recordClass.getMethod("of", BigDecimal.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)
            throws SQLException {
        try {
            BigDecimal value = (BigDecimal) valueMethod.invoke(parameter);
            ps.setBigDecimal(i, value);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getNullableResult(rs.getBigDecimal(columnName), rs.wasNull());
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getNullableResult(rs.getBigDecimal(columnIndex), rs.wasNull());
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getNullableResult(cs.getBigDecimal(columnIndex), cs.wasNull());
    }

    @SuppressWarnings("unchecked")
    private T getNullableResult(BigDecimal value, boolean wasNull) {
        if (wasNull) {
            return null;
        } else {
            try {
                return (T) ofMethod.invoke(null, value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}