package cn.hhm.workmybatis.utils;

import cn.hhm.workmybatis.enums.BaseEnum;

/**
 * @author Ming
 * @create 2018-11-25 19:10
 */
public class BaseEnumUtil {
    public static <E extends BaseEnum> E indexOf(Class<E> enumClass, int index){
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e:enumConstants) {
            if (e.getIndex()==index){
                return e;
            }
        }
        return null;
    }
}
