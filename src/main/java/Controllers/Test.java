package Controllers;

import DAO.UserMapper;
import beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/test.action")
    public ModelAndView fun(){
        User user = mapper.getUserByName("jerry");
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView("success.jsp");
        modelAndView.addObject("result",user);
        return modelAndView;
    }

}
