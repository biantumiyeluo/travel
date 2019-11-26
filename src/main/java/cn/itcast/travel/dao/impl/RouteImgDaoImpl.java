package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @PackageName: cn.itcast.travel.dao.impl
 * @ClassName: RouteImgDaoImpl
 * @Author: renpengzhi
 * @Date: 2019/11/3 0003 下午 8:34
 * @Description: //TODO
 */
public class RouteImgDaoImpl implements RouteImgDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ?";
        return template.query(sql, new BeanPropertyRowMapper<>(RouteImg.class), rid);
    }
}
