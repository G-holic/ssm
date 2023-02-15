import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext_jdbcTemplate.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJdbcTemplateService {
    @Autowired
    private DeptService deptService;
    @Test
    public void testJdbcTemplateService(){
        for (Dept allDept : deptService.getAllDepts()) {
            System.out.println("allDept = " + allDept);
        }
    }
}
