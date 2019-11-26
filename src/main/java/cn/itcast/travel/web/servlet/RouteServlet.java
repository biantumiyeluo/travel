package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import javafx.scene.control.Alert;
import sun.security.krb5.internal.TGSReq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteServiceImpl favoriteService = new FavoriteServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        int cid = 0;
        if (cidStr != null && cidStr.length() > 0) {
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }
//调用放法
        PageBean<Route> pb = routeService.pageQuery(cid, currentPage, pageSize);
        //序列化为json
        writeValue(pb, response);*/
        //1.接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        //获取rname
        String rname = request.getParameter("rname");
        rname = new String(rname.getBytes("ISO-8859-1"), "UTF-8");

        int cid = 0;//类别id
        //2.处理参数
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        int pageSize = 0;//每页显示条数，如果不传递，默认每页显示5条记录
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        //3. 调用service查询PageBean对象
        PageBean<Route> pb = routeService.pageQuery(cid, currentPage, pageSize, rname);

        //4. 将pageBean对象序列化为json，返回
        writeValue(pb, response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收id
        String rid = request.getParameter("rid");
        //2.调用方法
        Route route = routeService.findOne(rid);
        //3.序列化json对象
        writeValue(route, response);
    }

    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取线路rid
        String rid = request.getParameter("rid");
        //2.获取登录用户
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if (user == null) {
            uid = 0;
        } else {
            uid = user.getUid();
        }

        //3.查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);

        //4.序列化json
        writeValue(flag, response);
    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取路线rid
        String rid = request.getParameter("rid");

        //2.获取当前用户
        User user = (User) request.getSession().getAttribute("user");

        //3.用户uid
        int uid;
        if (user == null) {
            //用户未登录
            return;
        } else {
            uid = user.getUid();
        }

        //4.调用service的添加方法
        favoriteService.add(rid, uid);
    }
}

