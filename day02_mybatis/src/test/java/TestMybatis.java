import cn.itcast.mybatis.mapper.EmployeeMapper;
import cn.itcast.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void testMybatis(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            // 获取EmployeeMapper的代理对象【com.sun.proxy.$Proxy6】（$开头）
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println("mapper = " + mapper.getClass().getName());

            Employee employee = mapper.selectEmpById(2);
            System.out.println("employee = " + employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMybatisInsert(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            // 获取EmployeeMapper的代理对象【com.sun.proxy.$Proxy6】（$开头）
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            // 测试添加员工信息
            Employee zhaoliu = new Employee(null, "zhaoliu", "zhaoliu@163.com", 50.0);
            int i = employeeMapper.insertEmployee(zhaoliu);
            System.out.println("i = " + i);

            // 获取新增员工的id
            System.out.println("zhaoliu.getId() = " + zhaoliu.getId());

            // 测试删除员工信息
//            employeeMapper.deleteEmployeeById(5);

            // 测试修改员工信息
//            Employee employee = new Employee(2, "lisi123", "@163lisi123.com", 102.0);
//            employeeMapper.updateEmployee(employee);

            // 测试查询所有员工信息
//            List<Employee> employees = employeeMapper.selectAllEmps();
//            for (Employee employee : employees) {
//                System.out.println("employee = " + employee);
//            }

            // 提交事务
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
