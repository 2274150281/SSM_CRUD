package Controllers;

import DAO.UserMapper;
import Services.UserService;
import beans.User;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserOperation {

    private static final Logger logger = (Logger) LogManager.getLogger(UserOperation.class);

    @Autowired
    UserService userService;

    @RequestMapping("/charge.action")
    public ModelAndView charge(HttpSession httpSession, @RequestParam("money")float money){
        logger.info("Processing URL /charge.action  ...");
        User user = (User) httpSession.getAttribute("user");
        logger.info("Get user from session");
        userService.setMoney(user.getId(),money+user.getMoney());
        logger.info("Set money of user");
        ModelAndView modelAndView = new ModelAndView("chargeSuccess.jsp");
        return modelAndView;
    }

    @RequestMapping("/logout.action")
    public ModelAndView logout(HttpSession httpSession){
        logger.info("Invalidating session");
        httpSession.invalidate();
        return new ModelAndView("index.jsp");
    }

}
