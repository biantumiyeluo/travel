package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao {

    Favorite findByRidAndUid(int rid, int uid);
//rid查询收藏次数
   public int findCountByRid(int rid);

    void add(int rid, int uid);
}
