package Services;

import DAO.UserMapper;
import beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserByName(String name){
        return userMapper.getUserByName(name);
    }

    public void setMoney(int id,float money){
        userMapper.setMoney(id,money);
    }

    public float getMoney(int id){
        return userMapper.getMoney(id);
    }

}
