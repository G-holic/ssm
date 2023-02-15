import cn.itcast.mybatis.mapper.DeptMapper;
import cn.itcast.mybatis.mapper.EmployeeMapper;
import cn.itcast.mybatis.pojo.Dept;
import cn.itcast.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestResultMap {

    @Test
    public void testResultMap() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        // 测试自定义映射【resultMap】
//        List<Employee> employees = employeeMapper.selectEmpAndDeptByEmpId(1);
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }

        // 测试自定义映射-association
//        Employee employee = employeeMapper.selectEmpAndDeptByEmpIdAssociation(2);
//        System.out.println("employee = " + employee);

        // 测试自定义映射-association的分部查询
        Employee employee1 = employeeMapper.selectEmpAndDeptByEmpIdAssociationStep(1);
//        System.out.println("employee1 = " + employee1);
        System.out.println("employee1 = " + employee1.getLastName());
        System.out.println("==========================================");
        System.out.println("employee1 = " + employee1.getDept());

    }

    @Test
    public void testOneToMoreCollection() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        // 测试collection一对多关联
//        Dept dept = deptMapper.selectDeptAndEmpByDeptId(1);
//        System.out.println("dept = " + dept);

        // 测试collection一对多分部查询
        Dept dept1 = deptMapper.selectDeptAndEmpByDeptIdStep(1);
        System.out.println("dept1 = " + dept1.getDeptName());
        System.out.println("===============================");
        System.out.println("dept1 = " + dept1);

    }
}
