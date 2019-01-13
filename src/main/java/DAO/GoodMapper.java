package DAO;

import beans.Good;

import java.util.List;

public interface GoodMapper {

    Good getGood(int id);
    List<Good> getGoods();

}
