package dao;

import entities.Station;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by HJ on 2015/4/1 0001.
 */
@Repository
public interface StationDao{
    @Select("select * from station")
    public List<Station> findAllStation();

    @Select("select * from station where id = #{id}")
    public Station findStationById(String id);

    @Delete("delete from station where id = #{id}")
    public void delStationById(String id);

    @Update("update station set address = #{address},managerId = #{managerId},accountRatio = #{accountRatio},totalAmount = #{totalAmount},totalAmount = #{totalAmount},actualAmount = #{actualAmount},actualAmountString = #{actualAmountString} where id = #{id}")
    public void updateStation(Station station);

    @Insert("insert into station(address,managerId,accountRatio,totalAmount,actualAmount,actualAmountString) value(#{address},#{managerId},#{accountRatio},#{totalAmount},#{actualAmount},#{actualAmountString})")
    public void addStation(Station station);
}
