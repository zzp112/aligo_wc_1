package services;

import entities.Course;

import java.util.List;

/**
 * Created by Administrator on 2015/4/3.
 */
public interface ICourseService {
    /**
     * 查找所有课程
     * @return 课程列表
     */
    public List<Course> findAllCourse();

    /**
     * 通过id查找课程
     * @param id 课程id
     * @return 课程
     */
    public Course findCourseById(String id) ;

    /**
     * 通过name查找课程
     * @param name 课程name
     * @return 课程
     */
    public List<Course> findCourseByName(String name) ;

    /**
     * 删除课程
     * @param id 课程id
     * @return 课程
     */
    public boolean delCourseById(String id) ;

    /**
     * 更新课程信息
     * @param id
     * @param name
     * @param cost
     * @return 是否成功
     */
    public boolean updateCourseById(String id, String name, String cost);

    /**
     * 添加课程
     * @param name
     * @param cost
     * @return 是否成功
     */
    public boolean addCourse(String name, String cost);
}
