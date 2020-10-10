package cn.smbms.service;

import cn.smbms.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    List<Goods> getGoods(Map<String, Object> param);

    Goods getById(Integer id);

    boolean update(Goods goods);

}
