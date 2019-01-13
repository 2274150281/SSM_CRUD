package Services;

import DAO.AdministratorMapper;
import beans.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {

    @Autowired
    AdministratorMapper administratorMapper;

    public int validation(String name,String password){
        int result;
        Administrator administrator = administratorMapper.getAdministrator(name);
        if(administrator == null){
            result = -1;
        }else if(administrator.getPassword() != password){
            result = 1;
        }else{
            result = 0;
        }
        return result;
    }

}
