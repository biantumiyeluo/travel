package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import javax.print.attribute.standard.Sides;
import java.util.List;

/**
 * @PackageName: cn.itcast.travel.service.impl
 * @ClassName: RouteServiceImpl
 * @Author: renpengzhi
 * @Date: 2019/11/2 0002 下午 5:25
 * @Description: //TODO
 */
public class RouteServiceImpl implements RouteService {
    private RouteDaoImpl routeDao = new RouteDaoImpl();

    private RouteImgDaoImpl routeImgDao = new RouteImgDaoImpl();

    private SellerDaoImpl sellerDao = new SellerDaoImpl();

    private FavoriteDaoImpl favoriteDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pb = new PageBean<>();
        //设置数据
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid, rname);
        pb.setTotalCount(totalCount);

        //设置数据集合
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pb.setList(list);

        //设置总页数
        int totalpage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalpage);

        return pb;
    }

    @Override
    public Route findOne(String rid) {
        //1.根据id获取route对象
        Route route = routeDao.findOne(Integer.parseInt(rid));
        //2.根据rid获取图片的集合
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        //2.1设置到list集合
        route.setRouteImgList(routeImgList);

        //3.查询商家对象
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);

        //4.收藏次数
        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);

        return route;
    }
}
