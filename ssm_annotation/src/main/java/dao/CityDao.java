package dao;

import domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CityDao {
    @Insert("insert into t_city values(null,#{cityName},#{createTime})")
    void save(City city);

    @Update("update t_city set city_name = #{cityName},create_time = #{createTime} where id= #{id}")
    void update(City city);

    @Delete("delete from t_city where id = #{id}")
    void delete(Integer id);

    @Results(id = "cityResult", value = {
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "createTime", column = "create_time"),
    })
    @Select("select * from t_city where id = #{id}")
    City getById(Integer id);

    @ResultMap("cityResult")
    @Select("select * from t_city where 1=1")
    List<City> getAll();
}
