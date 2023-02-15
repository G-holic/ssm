package cn.itcast.mybatis.pojo;

import java.util.List;

public class Dept {
    private Integer deptId;
    private String deptName;

    // 一对多【dept-emp】
    private List<Employee> empList;

    public Dept() {
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public Dept(Integer deptId, String deptName, List<Employee> empList) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.empList = empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public Dept(Integer depId, String deptName) {
        this.deptId = depId;
        this.deptName = deptName;
    }

    public Integer getDepId() {
        return deptId;
    }

    public void setDepId(Integer depId) {
        this.deptId = depId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                '}';
    }
}
