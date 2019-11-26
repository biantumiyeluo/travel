package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

/**
 * @PackageName: cn.itcast.travel.service.impl
 * @ClassName: FavoriteService
 * @Author: renpengzhi
 * @Date: 2019/11/4 0004 下午 1:55
 * @Description: //TODO
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDaoImpl favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);
        return favorite != null;
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid), uid);
    }
}
