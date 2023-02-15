import cn.itcast.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

public class TestJdbcTemplate {

    /**
     * 测试环境搭建
     */
    @Test
    public void testJdbcTemplate() {
        // 创建容器对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_jdbcTemplate.xml");

        // 获取JdbcTemplate对象
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println("jdbcTemplate = " + jdbcTemplate);


    }

    /**
     * 测试常用API
     */
    @Test
    public void testJdbcTemplateAPI() {
        // 创建容器对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_jdbcTemplate.xml");

        // 获取JdbcTemplate对象
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        // 增
//        String sql = "insert into tbl_dept(dept_name) values(?)";
//        jdbcTemplate.update(sql,"人事部门");

        // 删
//        String sql = "delete from tbl_dept where dept_id = ?";
//        jdbcTemplate.update(sql,4);

        // 改
//        String sql = "update tbl_dept set dept_name = ? where dept_id = ?";
//        jdbcTemplate.update(sql,"人事2部",3);

        // 批量增
        /*String sql = "insert into tbl_employee(last_name,email,salary,dept_id) values(?,?,?,?)";
        List<Object[]> empList = new ArrayList<>();
        empList.add(new Object[]{"zs","zs@163.com",100.0,1});
        empList.add(new Object[]{"lisi","lisi@163.com",100.0,2});
        empList.add(new Object[]{"wangwu","wangwu@163.com",100.0,2});
        empList.add(new Object[]{"zhaoliu","zhaoliu@163.com",100.0,3});
        empList.add(new Object[]{"xiaosan","xiaosan@163.com",100.0,1});

        jdbcTemplate.batchUpdate(sql,empList);*/

        // 测试查询
        // 查询单个数值【查询员工人数】
//        String sql = "select count(1) from tbl_employee";
//        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
//        System.out.println("员工数量：" + count);


        // 查询单个对象【通过员工id获取员工信息】
//        String sql  = "select id,last_name,email,salary,dept_id from tbl_employee where id = ?";
        // 创建RowMapper<T>
//        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
//        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
//        System.out.println("employee = " + employee);

        // 查询多个对象
        String sql = "select id,last_name,email,salary from tbl_employee";
        // 创建RowMapper<T>
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employeeList = jdbcTemplate.query(sql, rowMapper);
        System.out.println("employeeList = " + employeeList);


    }
}
