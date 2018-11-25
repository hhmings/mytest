package cn.hhm.workmybatis.typehandler;

import cn.hhm.workmybatis.enums.BaseEnum;
import cn.hhm.workmybatis.utils.BaseEnumUtil;
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
public class MyEnumTypeHandler<E extends BaseEnum> extends BaseTypeHandler<BaseEnum> {

    private Class<E> type;

    public MyEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, BaseEnum baseEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,baseEnum.getIndex());
    }

    @Override
    public BaseEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return indexOf(type,resultSet.getInt(s));
    }

    @Override
    public BaseEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return indexOf(type,resultSet.getInt(i));
    }

    @Override
    public BaseEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return indexOf(type,callableStatement.getInt(i));
    }

    public <E extends BaseEnum> E indexOf(Class<E> enumClass, int index){
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e:enumConstants) {
            if (e.getIndex()==index){
                return e;
            }
        }
        return null;
    }
}
