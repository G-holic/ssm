package cn.itcast.dao;

import cn.itcast.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Dept> selectAllDepts() {
        String sql = "select dept_id,dept_name from tbl_dept";
        // 创建RowMapper<T>
        RowMapper<Dept> rowMapper = new BeanPropertyRowMapper<>(Dept.class);
        List<Dept> deptList = jdbcTemplate.query(sql, rowMapper);
        return deptList;
    }
}
