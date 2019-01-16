package DAO;

import beans.Good;

import java.util.List;

public interface GoodMapper {

    Good getGood(int id);
    List<Good> getGoods();

    void setPrice(int id,float price);
    float getPrice(int id);

    void setNumber(int id,int number);
    int getNumber(int id);

}
