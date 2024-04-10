package com.reservationSystem.domain.model.valueobject;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class RecordStringTypeHandler<T extends Record> extends BaseTypeHandler<T> {

    private final Method valueMethod;
    private final Method ofMethod;

    public RecordStringTypeHandler(Class<T> recordClass) {
        try {
            this.valueMethod = recordClass.getMethod("value");
            this.ofMethod = recordClass.getMethod("of", String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)
            throws SQLException {
        try {
            String value = (String) valueMethod.invoke(parameter);
            ps.setString(i, value);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getNullableResult(rs.getString(columnName), rs.wasNull());
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getNullableResult(rs.getString(columnIndex), rs.wasNull());
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getNullableResult(cs.getString(columnIndex), cs.wasNull());
    }

    @SuppressWarnings("unchecked")
    private T getNullableResult(String value, boolean wasNull) {
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