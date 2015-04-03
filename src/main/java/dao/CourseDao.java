package dao;

import entities.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
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
    public Course findCourseById(String id);

    @Select("select * from course where name like CONCAT('%',#{name},'%')  ")
    public List<Course> findStudentByName(String name);

    @Delete("delete from course where id = #{id}")
    public void delCourseById(String id);
}
