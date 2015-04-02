package dao;

import entities.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015-03-29.
 */
@Repository
public interface StudentDao {
    @Select("select studentname as student_name ,studentSex as student_sex ,courseName as course_name,teacherName as teacher_name from student")
    public List<Student> findAllUsers();
}
