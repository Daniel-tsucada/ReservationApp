package com.reservationSystem.domain.model.valueobject;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(ReservationId.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class ReservationIdTypeHandler extends BaseTypeHandler<ReservationId> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ReservationId parameter, JdbcType jdbcType)
            throws SQLException {
        if (parameter == null) {
            ps.setNull(i, jdbcType.TYPE_CODE);
        } else {
            ps.setInt(i, parameter.value());
        }
    }

    @Override
    public ReservationId getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return rs.wasNull() ? null : ReservationId.of(value);
    }

    @Override
    public ReservationId getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return rs.wasNull() ? null : ReservationId.of(value);
    }

    @Override
    public ReservationId getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return cs.wasNull() ? null : ReservationId.of(value);
    }
}