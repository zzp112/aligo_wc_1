package services;

import entities.Student;

import java.util.List;

/**
 * Created by Administrator on 2015/4/3.
 */
public interface IStudentService {
    /**
     * 查找所有学生
     * @return 学生列表
     */
    public List<Student> findAllStudent();

    /**
     * 通过id查找学生
     * @param id 学生id
     * @return 学生
     */
    public Student findStudentById(String id) ;

    /**
     * 通过年级查找学生
     * @param grade grade
     * @return 学生列表
     */
    public List<Student> findStudentByGrade(String grade) ;

    /**
     * 通过姓名查找学生
     * @param name name
     * @return 学生列表
     */
    public List<Student> findStudentByName(String name) ;

    /**
     * 删除学生
     * @param id 学生id
     * @return 学生
     */
    public boolean delStudentById(String id) ;

    /**
     * 更新学生信息
     * @param id 学生Id
     * @param name 姓名
     * @param sex 性别
     * @param grade 年级
     * @param parentsTel 电话
     * @return 是否成功
     */
    public boolean updateStudentById(String id, String name, String sex, String grade, String parentsTel);

    /**
     * 添加学生
     * @param name 姓名
     * @param sex 性别
     * @param grade 年级
     * @param parentsTel 电话
     * @return
     */
    public boolean addStudent(String name, String sex, String grade, String parentsTel);
}
