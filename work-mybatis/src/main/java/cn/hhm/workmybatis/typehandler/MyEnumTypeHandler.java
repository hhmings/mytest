package cn.hhm.workmybatis.typehandler;

import cn.hhm.workmybatis.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ming
 * @create 2018-11-25 18:58
 */
public class MyEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<BaseEnum> {

    private Class<E> clazz;

    public MyEnumTypeHandler(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, BaseEnum baseEnum, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public BaseEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public BaseEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public BaseEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
