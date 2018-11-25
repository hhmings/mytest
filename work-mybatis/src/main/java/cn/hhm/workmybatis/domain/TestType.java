package cn.hhm.workmybatis.domain;

import cn.hhm.workmybatis.enums.TestTypeEnum;

/**
 * 测试 cnum
 * @author Ming
 * @create 2018-11-25 15:36
 */
public class TestType {
    private Integer id;
    private TestTypeEnum testTypeEnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TestTypeEnum getTestTypeEnum() {
        return testTypeEnum;
    }

    public void setTestTypeEnum(TestTypeEnum testTypeEnum) {
        this.testTypeEnum = testTypeEnum;
    }

    @Override
    public String toString() {
        return "TestType{" +
                "id=" + id +
                ", testTypeEnum=" + testTypeEnum +
                '}';
    }
}
