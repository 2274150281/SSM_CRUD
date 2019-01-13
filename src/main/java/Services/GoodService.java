package Services;

import DAO.GoodMapper;
import beans.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    @Autowired
    GoodMapper goodMapper;

    public List<Good> getGoods(){
        return goodMapper.getGoods();
    }

    public Good getGood(int id){
        return goodMapper.getGood(id);
    }

}
