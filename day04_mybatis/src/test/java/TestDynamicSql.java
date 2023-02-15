import cn.itcast.mybatis.mapper.EmployeeMapper;
import cn.itcast.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestDynamicSql {

    @Test
    public void testDynamicSql() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 动态sql【无参数报错，没有第一个参数也报错】(解决办法，使用where标签)
        Employee employee = new Employee();
//        employee.setId(1);
        employee.setLastName("李四");
        employee.setEmail("lisi@163.com");
//        employee.setSalary(100.0);


        // 测试if-where
//        List<Employee> employees = mapper.selectEmployeeByOpr(employee);

        // 测试trim
//        List<Employee> employees = mapper.selectEmployeeByOprTrim(employee);


        // 测试多个条件查询员工信息
//        List<Employee> employees = mapper.selectEmpByOneOpr(employee);

        // 测试foreach
//        List<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(2);
//        ids.add(4);
//        List<Employee> employees = mapper.selectEmpByIds(ids);
//
//        for (Employee employee1 : employees) {
//            System.out.println("employee1 = " + employee1);
//        }

        // 测试修改
//        employee.setLastName("李四");
//        employee.setSalary(200.0);
//        mapper.updateEmpByOpr(employee);

        // 测试批量添加员工信息
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(null,"lisi","lis@qq.com",100.5));
//        employees.add(new Employee(null,"wangwu","wangwu@qq.com",100.5));
//        employees.add(new Employee(null,"zhaoliu","zhaoliu@qq.com",100.5));
//        mapper.batchInsertEmp(employees);

        // 提交事务
        sqlSession.commit();


    }
}
