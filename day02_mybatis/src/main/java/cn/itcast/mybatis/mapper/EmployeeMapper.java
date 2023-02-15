package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    /**
     * 通过id获取员工信息
     *
     * @param empId
     * @return
     */
    public Employee selectEmpById(int empId);

    /**
     * 添加员工信息
     *
     * @param employee
     */
    // 获取数据库受影响行数（直接将接口中方法的返回值设置为int或boolean即可）
    // int：代表受影响行数 boolean true：表示对数据库有影响 false：表示对数据库无影响
//    void insertEmployee(Employee employee);
    int insertEmployee(Employee employee);

    /**
     * 删除员工信息
     *
     * @param empId
     */
    void deleteEmployeeById(int empId);

    /**
     * 修改员工信息
     *
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 查询所有的员工信息
     *
     * @return
     */
    List<Employee> selectAllEmps();

    //  day03
    // Mybatis中参数传递问题

    /**
     * 通过员工的姓名和薪资查询员工信息【多个普通参数】
     *
     * @return
     */
    List<Employee> selectEmpByOpr(String lastName, double salary);

    /**
     * 通过员工的姓名和薪资查询员工信息【Pojo参数】
     *
     * @return
     */
    List<Employee> selectEmpByPojo(Employee employee);

    /**
     * 通过员工的姓名和薪资查询员工信息【命名参数】
     *
     * @return
     */
    List<Employee> selectEmpByNamed(@Param("lName") String lastName,
                                    @Param("salary") double salary);


    /**
     * 通过员工的姓名和薪资查询员工信息【Map参数】
     *
     * @return
     */
    List<Employee> selectEmpByMap(Map<String, Object> map);

    /**
     * 测试$使用场景
     */
    public List<Employee> selectEmpByDynamitTable(@Param("tblName") String tblName);

    /**
     * 查询单行数据返回Map集合
     *
     * @return
     */
    Map<String, Object> selectEmpReturnMap(int empId);

    /**
     * 查询多行数据返回Map
     * Map<Integer,Object>
     * Map<Integer,Employee>
     * 对象Id作为：key
     * 对象作为：value
     *
     * @return
     */
    @MapKey("id")
    Map<Integer, Employee> selectEmpsReturnMap();
}
