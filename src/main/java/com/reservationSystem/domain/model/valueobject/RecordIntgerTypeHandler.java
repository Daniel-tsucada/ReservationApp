package com.reservationSystem.domain.model.valueobject;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class RecordIntgerTypeHandler<T extends ValueObject<Integer>> extends BaseTypeHandler<T> {

    private final Method valueMethod;

    public RecordIntgerTypeHandler(Class<T> recordClass) {
        try {
            this.valueMethod = recordClass.getMethod("value");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)
            throws SQLException {
        try {
            Object value = valueMethod.invoke(parameter);
            if (value instanceof Integer) {
                ps.setInt(i, (Integer) value);
            } else if (value instanceof String) {
                ps.setString(i, (String) value);
            } else {
                throw new SQLException("Unsupported value type: " + value.getClass());
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        throw new UnsupportedOperationException("Conversion from database type to ValueObject is not supported");
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        throw new UnsupportedOperationException("Conversion from database type to ValueObject is not supported");
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        throw new UnsupportedOperationException("Conversion from database type to ValueObject is not supported");
    }
}