package com.reservationSystem.domain.model.valueobject;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class RecordTypeHandler<T extends Record> extends BaseTypeHandler<T> {

    private final Method valueMethod;
    private final Method ofMethod;
    @SuppressWarnings("unused")
    private final Class<T> recordClass;

    public RecordTypeHandler(Class<T> recordClass) {
        try {
            this.recordClass = recordClass;
            this.valueMethod = recordClass.getMethod("value");
            this.ofMethod = recordClass.getMethod("of", Integer.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)
            throws SQLException {
        try {
            Integer value = (Integer) valueMethod.invoke(parameter);
            ps.setInt(i, value);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getNullableResult(rs.getInt(columnName), rs.wasNull());
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getNullableResult(rs.getInt(columnIndex), rs.wasNull());
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getNullableResult(cs.getInt(columnIndex), cs.wasNull());
    }

    @SuppressWarnings("unchecked")
    private T getNullableResult(int value, boolean wasNull) {
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
