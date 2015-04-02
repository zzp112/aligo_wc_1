package dao;

import entities.Station;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/4/1 0001.
 */
@Repository
public interface StationDao{
    @Select("select * from station")
    public List<Station> findAllStation();
}
