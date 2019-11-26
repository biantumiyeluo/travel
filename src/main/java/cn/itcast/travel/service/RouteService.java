package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {
    //分页查询
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    //根据id查询
    public Route findOne(String rid);
}
