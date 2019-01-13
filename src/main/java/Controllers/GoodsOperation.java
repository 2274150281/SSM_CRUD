package Controllers;

import Services.GoodOperationService;
import Services.GoodService;
import beans.Good;
import beans.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("goods")
public class GoodsOperation {

    @Autowired
    GoodService goodService;
    @Autowired
    GoodOperationService goodOperationService;

    @RequestMapping("/but,action")
    public ModelAndView buy(@Param("id")int id, @SessionAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        Float money = user.getMoney();
        Float price = goodService.getGood(id).getPrice();

        if(money < price){
            modelAndView.setViewName("poor.jsp");
        }else{
            goodOperationService.buy();
            List<Good> goods = goodService.getGoods();
            modelAndView.addObject("goods",goods);
            modelAndView.setViewName("goods.jsp");
        }

        return modelAndView;
    }

}
