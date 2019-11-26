package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * @PackageName: cn.itcast.travel.dao
 * @ClassName: RouteImgDao
 * @Author: renpengzhi
 * @Date: 2019/11/3 0003 下午 8:33
 * @Description: //TODO
 */
public interface RouteImgDao {
    //根据route id 查询图片集合
    public List<RouteImg> findByRid(int rid);
}
