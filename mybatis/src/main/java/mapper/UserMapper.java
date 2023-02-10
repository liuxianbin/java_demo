package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Lang;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

public interface UserMapper {
    int insertUser(User u);

    User getUserByName(String name);

    User getUser(@Param("name") String name, @Param("age") int age);

    ArrayList<User> getUsers();

    int getCount();
    List<Lang> getLangs();
}
