package cn.smbms.dao;

import cn.smbms.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {

    List<Goods> getGoods(Map<String, Object> param);

    Goods getById(Integer id);

    Integer update(Goods goods);
}
