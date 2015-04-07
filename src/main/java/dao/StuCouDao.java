package dao;

import entities.StuCou;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2015/4/4.
 */
public interface StuCouDao {

    public static String SELECTSQL="Select studentCourse.id,stationId,address as stationAddress,studentId,student.name as studentName,courseId,course.name as courseName,courseCount,cost as costByOne,courseDate from studentCourse,station,student,course where stationId=station.id and courseId=course.id and student.id=studentId";


    @Insert("insert into studentCourse(stationId,customerId,courseId,courseName,courseCount,costByOne,costTotal,courseDate) value(#{stationId},#{studentId},#{courseId},#{courseName},#{courseCount},#{costByOne},#{costTotal},#{courseDate})")
    public void addStuCou(StuCou stuCou);

    @Delete("delete from studentCourse where id = #{id}")
    public void deleteStuCou(Integer id);

    @Update("update studentCourse set stationId=#{stationId},studentId=#{studentId},courseId=#{courseId},courseCount=#{courseCount} where id=#{id}")
    public void updateStuCou(StuCou stuCou);

    @Select(SELECTSQL+" and courseDate between #{courseDate} and #{courseDate2}")
    public List<StuCou> loadStuCouByDate(@Param("courseDate")String courseDate,@Param("courseDate2")String courseDate2);

    @Select(SELECTSQL+" and studentId = #{studentId}")
    public List<StuCou> loadStuCouByStuId(Integer studentId);

    @Select(SELECTSQL+" and courseId = #{courseId}")
    public List<StuCou> loadStuCouByCouId(Integer courseId);

    @Select(SELECTSQL)
    public List<StuCou> loadStuCou();

    @Select(SELECTSQL+" and studentCourse.id = #{stuCouId}")
    public StuCou loadStuCouByStuCouId(Integer stuCouId);





}
