package Services;

import DAO.UserMapper;
import beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
public class LoginService {

    @Autowired
    UserMapper userMapper;
    User user = null;

    public int valid(String name,String password){
        user = userMapper.getUserByName(name);
        if (user == null)
            return -1;
        if(!user.getPassword().equals(password))
            return 0;
        return 1;
    }

    public User getUser(){
        return this.user;
    }

}
