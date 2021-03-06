package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @PackageName: cn.itcast.travel.dao.impl
 * @ClassName: CategoryDaoImpl
 * @Author: renpengzhi
 * @Date: 2019/11/2 0002 下午 3:29
 * @Description: //TODO
 */
public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category order by cid";
        return template.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }
}
