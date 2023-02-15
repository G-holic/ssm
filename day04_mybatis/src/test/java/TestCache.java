import cn.itcast.mybatis.mapper.EmployeeMapper;
import cn.itcast.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestCache {


    @Test
    public void testCache() throws Exception{
        // 创建SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 从sqlSessionFactory中构建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setId(1);
//        employee.setLastName("程老师");
        List<Employee> employees = mapper.selectEmployeeByOpr(employee);
        System.out.println("employees = " + employees);
        //关闭资源
        sqlSession.close();

        // 执行一次增删改操作。。。
//        mapper.updateEmpByOpr(employee);

        // 测试手动清空了缓存
//        sqlSession.clearCache();

        // 测试提交事务
//        sqlSession.commit();


        System.out.println("==============================");

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
        List<Employee> employees1 = mapper1.selectEmployeeByOpr(employee);
        System.out.println("employees1 = " + employees1);


//        List<Employee> employees1 = mapper.selectEmployeeByOpr(employee);
//        System.out.println("employees1 = " + employees1);
    }
    @Test
    public void testCacheTwo() throws Exception{
        // 创建SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 从sqlSessionFactory中构建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setId(1);
        List<Employee> employees = mapper.selectEmployeeByOpr(employee);
        System.out.println("employees = " + employees);
        //关闭资源
        sqlSession.close();

        System.out.println("==============================");

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
        List<Employee> employees1 = mapper1.selectEmployeeByOpr(employee);
        System.out.println("employees1 = " + employees1);
        // sqlSession.clearCache();只能清除一级缓存

    }
}
