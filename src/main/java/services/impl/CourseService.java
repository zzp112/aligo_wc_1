package services.impl;

import dao.CourseDao;
import entities.Course;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.ICourseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by HJ on 2015/4/3.
 */
@Service
@Transactional
public class CourseService implements ICourseService {
    @Autowired
    private CourseDao coursenDao;

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<Course> findAllCourse() {
        return sqlSession.selectList("course.findAllCourse");
    }

    @Override
    public Course findCourseById(Integer id) { return coursenDao.findCourseById(id); }

    @Override
    public List<Course> findCourseByName(String name) {
        return coursenDao.findStudentByName(name);
    }

    @Override
    public boolean delCourseById(Integer id) {
        if(id == null)
            return false;
        if(coursenDao.findCourseById(id) == null)
            return false;
        coursenDao.delCourseById(id);
        return true;
    }

    @Override
    public boolean updateCourseById(Integer id, String name, Integer cost) {
        if(id == null)
            return false;
        if(name.equals(""))
            return false;
        if(cost == null) {
            System.out.println("cost == null");
            return false;
        }

        Course result = coursenDao.findCourseById(id);
        if(result == null)
            return false;
        result.setName(name);
        result.setCost(cost);
        coursenDao.updateCourseById(result);

        return true;
    }

    @Override
    public boolean addCourse(String name, Integer cost) {
        if(name.equals(""))
            return false;
        if(cost == null)
            return false;
        Course course = new Course();
        course.setName(name);
        course.setCost(cost);

        coursenDao.addCourse(course);

        return true;
    }
}
