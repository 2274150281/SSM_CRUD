package Controllers;

import Services.AdminLoginService;
import Services.GoodService;
import beans.Good;
import org.apache.ibatis.annotations.Param;
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

    @Autowired
    AdminLoginService adminLoginService;
    @Autowired
    GoodService goodService;

    @RequestMapping("/adminLogin.action")
    public ModelAndView doLogin(@Param("username")String username, @Param("password") String password, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        String userType = "administrator";
        modelAndView.addObject(userType);

        int validation = adminLoginService.validation(username,password);
        if (validation == 1){
            modelAndView.setViewName("goods.jsp");
            List<Good> goods = goodService.getGoods();
            modelAndView.addObject("goods",goods);
        }else if(validation == 0){
            modelAndView.setViewName("wrongPassword.jsp");
        }else{
            modelAndView.setViewName("unexistUser.jsp");
        }

        return modelAndView;
    }

}
