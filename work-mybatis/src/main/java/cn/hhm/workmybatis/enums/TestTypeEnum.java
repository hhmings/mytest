package cn.hhm.workmybatis.enums;

/**
 * @author Ming
 * @create 2018-11-25 15:37
 */
public enum TestTypeEnum implements BaseEnum {
    beijing(1,"北京"),
    shanghai(2,"上海"),
    hefei(3,"合肥");

    private Integer index;
    private String value;
    TestTypeEnum(Integer index,String value){
        this.index=index;
        this.value=value;
    }

    public static TestTypeEnum getTestType(int index){
        for (TestTypeEnum type:TestTypeEnum.values()) {
            if (type.getIndex()==index){
                return type;
            }
        }
        throw new RuntimeException("index is error");
    }

    @Override
    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }
}
