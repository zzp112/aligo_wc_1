package dao;

import entities.Course;
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

}
