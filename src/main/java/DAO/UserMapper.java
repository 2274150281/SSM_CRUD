package DAO;

import beans.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where name = #{username}")
    User getUserByName(String id);//这里的变量命名只是皮一下，不要学

    @Select("select money from user where id = #{id}")
    Float getMoney(int id);

}
