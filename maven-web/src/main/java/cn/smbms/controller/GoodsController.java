package cn.smbms.controller;

import cn.smbms.pojo.Goods;
import cn.smbms.service.GoodsService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/sys/goods")
public class GoodsController {

    @Resource(name = "goodsService")
    private GoodsService goodsService;

    @RequestMapping(value = "goodsList")
    @ResponseBody
    public String getGoods(Model model, HttpServletRequest request) {
        Map<String, Object> param = new HashMap<>();
        Integer goods_district = Integer.parseInt(request.getParameter("goods_district"));
        param.put("goods_district", goods_district);
        System.out.println(goods_district);
        String json = JSON.toJSONString(goodsService.getGoods(param));
        return json;
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public String getGoods1(Model model, HttpServletRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("goods_district", request.getParameter("goods_district"));
        String json = JSON.toJSONString(goodsService.getGoods(param));
        return json;
    }

    @RequestMapping(value = "upd/{id}")
    public String upd(HttpServletRequest request, @PathVariable Integer id) {
        request.setAttribute("goods", goodsService.getById(id));
        return "upd";
    }

    @RequestMapping(value = "upd.do",method = RequestMethod.POST)
    public String upd1(Goods goods, HttpServletRequest request) {
        goods.setId(Integer.parseInt(request.getParameter("id")));
        goods.setBill_status(Integer.parseInt(request.getParameter("bill_status")));
        goods.setGoods_name(request.getParameter("goods_name"));
        goods.setGoods_price(Integer.parseInt(request.getParameter("goods_price")));
        goods.setGoods_count(Integer.parseInt(request.getParameter("goods_count")));
        if (goodsService.update(goods)) {
            System.out.println("成功");
            return "goods";
        } else {
            System.out.println("失败");
            return "upd";
        }
    }
}
