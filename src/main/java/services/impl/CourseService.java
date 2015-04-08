package services.impl;

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
import java.util.List;

/**
 * Created by HJ on 2015/4/3.
 */
@Service
@Transactional
public class CourseService implements ICourseService {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<Course> findAllCourse() {return sqlSession.selectList("course.findAllCourse"); }

    @Override
    public Course findCourseById(String id) { return sqlSession.selectOne("course.findCourseById", id); }

    @Override
    public List<Course> findCourseByName(String name) {
        return sqlSession.selectList("course.findCourseByName",name);
    }

    @Override
    public boolean delCourseById(String id) {
        if(id == null)
            return false;
        if(this.findCourseById(id) == null)
            return false;
        sqlSession.delete("course.delCourseById", id);
        return true;
    }

    @Override
    public boolean updateCourseById(String id, String name, Integer cost) {
        if(id == null)
            return false;
        if(name.equals(""))
            return false;
        if(cost == null) {
            return false;
        }

        Course result = this.findCourseById(id);
        if(result == null)
            return false;
        result.setName(name);
        result.setCost(cost);
        sqlSession.update("course.updateCourseById",result);

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

        sqlSession.insert("course.addCourse", course);

        return true;
    }
}
