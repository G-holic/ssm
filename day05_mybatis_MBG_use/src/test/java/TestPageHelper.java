import cn.itcast.mybatis.mapper.EmployeeMapper;
import cn.itcast.mybatis.pojo.Employee;
import cn.itcast.mybatis.pojo.EmployeeExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestPageHelper {

    /**
     * 测试开启分页
     * @throws Exception
     */
    @Test
    public  void testPageHelper() throws Exception{
        //                 创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 从SqlSessionFactory中构建SqlSession
        SqlSession sqlSession = build.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 创建员工对应的条件对象
        EmployeeExample ee = new EmployeeExample();

        // 开启分页
        Page<Object> page = PageHelper.startPage(2, 3);
        // PageHelper.startPage(m,n)两个参数，第一个参数是页数。第二个参数是条数，每页查询的条数。


        List<Employee> employees = mapper.selectByExample(ee);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }

        System.out.println(page.getPageNum()+"/"+page.getPages());
        System.out.println("总数据数量：" + page.getTotal());
        System.out.println("每页显示数据数量：" + page.getPageSize());
        System.out.println("当前页显示数据集合：" + page.getResult());
        for (Object o : page.getResult()) {
            System.out.println("o = " + o);
        }
    }

    /**
     * 测试PageInfo
     * @throws Exception
     */
    @Test
    public  void testPageInfo() throws Exception{
        //                 创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 从SqlSessionFactory中构建SqlSession
        SqlSession sqlSession = build.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 创建员工对应的条件对象
        EmployeeExample ee = new EmployeeExample();

        // 查询之前开启分页
        PageHelper.startPage(2, 3);
        // PageHelper.startPage(m,n)两个参数，第一个参数是页数。第二个参数是条数，每页查询的条数。

        // 查询数据
        List<Employee> employees = mapper.selectByExample(ee);

        // 查询之后，封装PageInfo
        PageInfo<Employee> pageInfo = new PageInfo<>(employees,3);

        System.out.println(pageInfo.getPageNum()+"/"+pageInfo.getPages());
        System.out.println("总数据数量："+pageInfo.getTotal());
        System.out.println("每页显示数据数量："+pageInfo.getPageSize());
        System.out.println("当前也显示数据的集合：");
        for (Employee employee : pageInfo.getList()){
            System.out.println("employee = " + employee);
        }

        System.out.println("是否有上一页："+pageInfo.isHasPreviousPage());
        System.out.println("上一页是："+pageInfo.getPrePage());
        System.out.println("是否有下一页："+pageInfo.isHasNextPage());
        System.out.println("上一页是："+pageInfo.getNextPage());
        System.out.println("是否是第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页："+pageInfo.isIsLastPage());
        System.out.println("导航页的第一个页码是："+pageInfo.getNavigateFirstPage());
        System.out.println("导航页的最后一个页码是："+pageInfo.getNavigateLastPage());
        System.out.println("导航页的总页码是："+pageInfo.getNavigatePages());

        /*
        *   分页页码逻辑
        *       当前页码1：1 2 3 4 5
        *       当前页码2：1 2 3 4 5
        *       当前页码3：1 2 3 4 5
        *       当前页码4：2 3 4 5 6
        *       当前页码5：3 4 5 6 7
        *       当前页码6：2 3 4 5 6
        *       当前页码16：12 13 14 15 16  // 此时当前页码最大是16
        * */

        for (int navigatepageNum : pageInfo.getNavigatepageNums()) {
            System.out.println("navigatepageNum = " + navigatepageNum);
        }


    }
}
