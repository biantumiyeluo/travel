package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

public interface SellerDao {
    //商家信息
    public Seller findById(int sid);
}
