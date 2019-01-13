package Controllers;

import Services.GoodService;
import Services.LoginService;
import beans.Good;
import beans.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("userType,user")
public class Login {

    @Autowired
    private LoginService loginService;
    @Autowired
    private GoodService goodService;

    @RequestMapping("/login.action")
    ModelAndView check(@Param("username")String username, @Param("password") String password, HttpSession httpSession){
        //这里不能使用@SessionAttribute注解，因为第一次用户还没登录的时候Session是空的，这样就会报错
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) httpSession.getAttribute("user");
        String userType = "normal";
        modelAndView.addObject("userType",userType);   //与上面@SessionAttributes注解对应的是model中的属性名，也就是第一个参数。

        if(httpSession.getAttribute("administrator") != null)
            httpSession.setAttribute("administrator",null);

        if(user == null) {
            int validation = loginService.valid(username, password);
            if (validation == 1){
                modelAndView.setViewName("goods.jsp");
                List<Good> goods = goodService.getGoods();
                user = loginService.getUser();
                modelAndView.addObject("user",user);
                modelAndView.addObject("goods",goods);
            }else if(validation == 0){
                modelAndView.setViewName("wrongPassword.jsp");
            }else{
                modelAndView.setViewName("unexistUser.jsp");
            }

        }else{
            modelAndView.setViewName("logined.jsp");
        }
        return modelAndView;
    }

}
