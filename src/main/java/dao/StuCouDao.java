package dao;

import entities.StuCou;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2015/4/4.
 */
public interface StuCouDao {

    @Insert("insert into studentCourse(stationId,customerId,courseId,courseName,courseCount,costByOne,costTotal,courseDate) value(#{stationId},#{customerId},#{courseId},#{courseName},#{courseCount},#{costByOne},#{costTotal},#{courseDate})")
    public void addStuCou(StuCou stuCou);

    @Delete("")
    public void deleteStuCou(Integer id);

    @Update("")
    public void updateStuCou(StuCou stuCou);

    @Select("Select studentCourse.id,stationId,customerId,courseId,courseName,courseCount,costByOne,courseDate,address from studentCourse,station where stationId=station.id")
    public List<StuCou> loadStuCou();






}
