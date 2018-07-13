package cn.hhm.workmybatis.domain;

/**
 * @author Ming
 * @create 2018-06-26 17:19
 */
public class Test2 {
    private int id;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
