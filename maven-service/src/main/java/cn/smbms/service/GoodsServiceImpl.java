package cn.smbms.service;

import cn.smbms.dao.GoodsMapper;
import cn.smbms.pojo.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource(name = "goodsMapper")
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoods(Map<String, Object> param) {
        return goodsMapper.getGoods(param);
    }

    @Override
    public Goods getById(Integer id) {
        return goodsMapper.getById(id);
    }

    @Override
    public boolean update(Goods goods) {
        if(goodsMapper.update(goods)>0){
            return true;
        }
        return false;
    }
}
