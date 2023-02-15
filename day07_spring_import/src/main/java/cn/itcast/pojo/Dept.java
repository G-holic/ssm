package cn.itcast.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
public class Dept implements Serializable {

    private static final long serialVersionUID = -3110526667290696390L;
    @Value("101")
    private Integer deptId;
    @Value("研发部")
    private String deptName;

    // 一对多【dept-emp】
    private List<Employee> empList;

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    private Map<Integer,Employee> empMap;

    public Dept(Integer deptId, String deptName, List<Employee> empList, Map<Integer, Employee> empMap) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.empList = empList;
        this.empMap = empMap;
    }

    public Map<Integer, Employee> getEmpMap() {
        return empMap;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                ", empMap=" + empMap +
                '}';
    }

    public void setEmpMap(Map<Integer, Employee> empMap) {
        this.empMap = empMap;
    }

    public Dept() {
        System.out.println("Dept构造器！！！");
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


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


}
