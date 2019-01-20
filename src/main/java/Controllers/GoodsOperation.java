package Controllers;

import Services.GoodOperationService;
import Services.GoodService;
import beans.PoorException;
import beans.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsOperation {

    private static final Logger logger = (Logger) LogManager.getLogger(GoodsOperation.class);

    @Autowired
    GoodService goodService;
    @Autowired
    GoodOperationService goodOperationService;

    @RequestMapping("/buy.action")
    public ModelAndView buy(@RequestParam("id")Integer goodId, @SessionAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        int userId = user.getId();
        float price = goodService.getPrice(goodId);
        logger.info("Get user id and money from session");

        try{
            goodOperationService.buy(userId,goodId,price);
            modelAndView.setViewName("purchaseSuccess.jsp");
            logger.info("Processing buy operation in database");
        }catch (PoorException e){
            modelAndView.setViewName("poor.jsp");
        }

        return modelAndView;
    }

}
