import cn.itcast.mybatis.mapper.EmployeeMapper;
import cn.itcast.mybatis.pojo.Employee;
import cn.itcast.mybatis.pojo.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestMBG {

    /**
     * 测试代码生成器
     * @throws Exception
     */
    @Test
    public  void testMBG() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        // javaIo
        File configFile = new File("src/main/resources/mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    /**
     * 测试简单的CRUD
     */
//    @Test
//    public void testCRUD() throws Exception{
//        // 创建sqlSessionFactory
//        String resource = "mybatis-config.xml";
//        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//
//        // 从SqlSessionFactory中构建SqlSession
//        SqlSession sqlSession = build.openSession();
//
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        List<Employee> employees = mapper.selectAll();
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }
//    }

    /**
     * 测试QBC风格的CRUD
     */
    @Test
    public  void testQBCCRUD() throws Exception{
//                 创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 从SqlSessionFactory中构建SqlSession
        SqlSession sqlSession = build.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 通过id获取员工信息
//        Employee employee = mapper.selectByPrimaryKey(1);
//        System.out.println("employee = " + employee);

        // 创建员工对应的条件对象
        EmployeeExample ee = new EmployeeExample();

        // 创建条件对象
        EmployeeExample.Criteria criteria = ee.createCriteria();
        // 添加条件
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(4);
        criteria.andIdIn(ids);
        // 添加条件
        criteria.andLastNameLike("li%");



        List<Employee> employees = mapper.selectByExample(ee);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }


    }
}
