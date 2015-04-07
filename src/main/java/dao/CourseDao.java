package dao;

import entities.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/4/3.
 */
@Repository
public interface CourseDao {
    @Select("select * from course")
    public List<Course> findAllCourse();

    @Select("select * from course where id = #{id}")
    public Course findCourseById(Integer id);

    @Select("select * from course where name like CONCAT('%',#{name},'%')  ")
    public List<Course> findStudentByName(String name);

    @Delete("delete from course where id = #{id}")
    public void delCourseById(Integer id);

    @Update("update course set name = #{name},cost = #{cost} where id = #{id}")
    public void updateCourseById(Course course);

    @Insert("insert into course(name,cost) value(#{name},#{cost})")
    public void addCourse(Course course);
}
