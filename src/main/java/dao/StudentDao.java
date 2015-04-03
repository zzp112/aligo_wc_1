package dao;

import entities.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/4/3 0003.
 */
@Repository
public interface StudentDao {
    @Select("select * from student")
    public List<Student> findAllStudent();

    @Select("select * from student where id = #{id}")
    public Student findStudentById(String id);

    @Select("select * from student where grade = #{grade}")
    public List<Student> findStudentByGrade(String grade);

    @Select("select * from student where name like CONCAT('%',#{name},'%')  ")
    public List<Student> findStudentByName(String name);
}
