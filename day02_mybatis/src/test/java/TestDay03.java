import cn.itcast.mybatis.mapper.EmployeeMapper;
import cn.itcast.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDay03 {
    @Test
    public  void testParam(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            // 获取EmployeeMapper的代理对象【com.sun.proxy.$Proxy6】（$开头）
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            // 测试多个普通参数
//            List<Employee> lisi123 = employeeMapper.selectEmpByOpr("lisi123", 102.0);
//            System.out.println("lisi123 = " + lisi123);

            // 测试Pojo参数
//            Employee employee = new Employee();
//            employee.setLastName("lisi123");
//            employee.setSalary(102.0);
//            List<Employee> employees = employeeMapper.selectEmpByPojo(employee);
//            System.out.println("employees = " + employees);

            // 测试命名参数
//            List<Employee> lisi123 = employeeMapper.selectEmpByNamed("lisi123", 102.0);
//            System.out.println("lisi123 = " + lisi123);

            // 测试Map参数
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("lastName","lisi123");
//            map.put("salary",102.0);
//            List<Employee> employees = employeeMapper.selectEmpByMap(map);
//            for (Employee employee : employees) {
//                System.out.println("employee = " + employee);
//            }

            // 测试$参数
//            List<Employee> employee = employeeMapper.selectEmpByDynamitTable("tbl_employee");
//            for (Employee employee1 : employee) {
//                System.out.println("employee1 = " + employee1);
//            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMybatisReturn() throws Exception{
        // 创建SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        // 测试查询单行数据返回Map集合
//            Map<String, Object> stringObjectMap = employeeMapper.selectEmpReturnMap(1);
//            System.out.println("stringObjectMap = " + stringObjectMap);
        // 查询多行数据返回Map
        Map<Integer, Employee> integerEmployeeMap = employeeMapper.selectEmpsReturnMap();
        System.out.println("integerEmployeeMap = " + integerEmployeeMap);
    }
}
