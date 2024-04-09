package com.reservationSystem.domain.model.valueobject;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerValueObjectTypeHandler<T extends IntegerValueObject> extends BaseTypeHandler<T> {

    private final Class<T> type;
    private final Method factoryMethod;

    public IntegerValueObjectTypeHandler(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        try {
            // ファクトリメソッド 'of' を取得
            this.factoryMethod = type.getMethod("of", Integer.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Type argument must have a static method 'of' that accepts an Integer",
                    e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.value());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Integer value = rs.getInt(columnName);
        return value == null ? null : valueOf(value);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer value = rs.getInt(columnIndex);
        return value == null ? null : valueOf(value);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer value = cs.getInt(columnIndex);
        return value == null ? null : valueOf(value);
    }

    @SuppressWarnings("unchecked")
    private T valueOf(Integer value) {
        try {
            // ファクトリメソッドを使用してインスタンスを作成
            return (T) factoryMethod.invoke(null, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate " + type.getSimpleName() + " with value: " + value, e);
        }
    }
}
