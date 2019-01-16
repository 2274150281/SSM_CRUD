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

    public float getPrice(int id){
        return goodMapper.getPrice(id);
    }

    public void setPrice(int id,float price){
        goodMapper.setPrice(id,price);
    }

    public void setNumber(int id, int number){
        goodMapper.setNumber(id,number);
    }

    public int getNumber(int id){
        return goodMapper.getNumber(id);
    }

}
