package cn.itcast.spring.pojo;

public class Student {

    private Integer stuId;
    private String stuName;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        System.out.println(" ==> setStuId() !!! " );
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Student() {
    }

    public Student(Integer stuId, String stuName) {
        System.out.println("==>Student有参构造器");
        this.stuId = stuId;
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
