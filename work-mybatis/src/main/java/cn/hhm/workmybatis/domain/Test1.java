package cn.hhm.workmybatis.domain;

/**
 * @author Ming
 * @create 2018-06-26 17:18
 */
public class Test1 {
    private int id;
    private String myname;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return myname;
    }

    public void setName(String name) {
        this.myname = name;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "id=" + id +
                ", name='" + myname + '\'' +
                '}';
    }
}
