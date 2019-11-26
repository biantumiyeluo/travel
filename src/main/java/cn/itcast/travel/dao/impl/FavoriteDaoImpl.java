package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.awt.*;
import java.util.Date;

/**
 * @PackageName: cn.itcast.travel.dao.impl
 * @ClassName: FavoriteDaoImpl
 * @Author: renpengzhi
 * @Date: 2019/11/4 0004 下午 2:00
 * @Description: //TODO
 */
public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Favorite findByRidAndUid(int rid, int uid) {
        Favorite favorite = null;
        try {
            String sql = "select * from tab_favorite where rid = ? and uid = ?";
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<>(Favorite.class), rid, uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return favorite;
    }

    @Override
    public int findCountByRid(int rid) {
        String sql = "select count(*) from tab_favorite where rid = ?";

        return template.queryForObject(sql, Integer.class, rid);
    }

    @Override
    public void add(int rid, int uid) {
        String sql = "insert into tab_favorite values (?,?,?)";
        template.update(sql,rid,new Date(),uid);
    }
}
