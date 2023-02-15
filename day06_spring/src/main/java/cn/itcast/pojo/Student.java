package cn.itcast.pojo;

public class Student {
    private Integer id;
    private  String stuName;

    /**
     * 初始化方法
     */
    public void initStudent(){
        System.out.println("3.初始化方法！！！");
    }

    /**
     * 销毁方法
     */
    public void destroyStudent(){
        System.out.println("5.销毁方法！！！");
    }

    public Student() {
        System.out.println("1.构造器！！！");
    }

    public Student(Integer id, String stuName) {
        this.id = id;
        this.stuName = stuName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("2.设置id属性值");
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
