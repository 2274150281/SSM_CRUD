package Controllers;

import Services.AdminLoginService;
import Services.GoodService;
import beans.Administrator;
import beans.Good;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("userType")
public class AdminLogin {

    private static final Logger logger = (Logger) LogManager.getLogger(Administrator.class);

    @Autowired
    AdminLoginService adminLoginService;
    @Autowired
    GoodService goodService;

    @RequestMapping("/adminLogin.action")
    public ModelAndView doLogin(@Param("username")String username, @Param("password") String password, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        String userType = "administrator";
        modelAndView.addObject(userType);
        logger.info("Set userType attribute in session");

        int validation = adminLoginService.validation(username,password);
        logger.info("Validating administrator account in database");
        if (validation == 1){
            modelAndView.setViewName("goods.jsp");
            List<Good> goods = goodService.getGoods();
            modelAndView.addObject("goods",goods);
        }else if(validation == 0){
            modelAndView.setViewName("wrongPassword.jsp");
        }else{
            modelAndView.setViewName("unexistUser.jsp");
        }
        logger.info("Set crresponding jsp page for validation results");

        return modelAndView;
    }

}
