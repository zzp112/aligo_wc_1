package services.impl;

import dao.CourseDao;
import entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.ICourseService;

import java.util.List;

/**
 * Created by HJ on 2015/4/3.
 */
@Service
@Transactional
public class CourseService implements ICourseService {
    @Autowired
    private CourseDao coursenDao;

    @Override
    public List<Course> findAllCourse() {  return coursenDao.findAllCourse(); }

    @Override
    public Course findCourseById(String id) { return coursenDao.findCourseById(id); }

    @Override
    public List<Course> findCourseByName(String name) {
        return coursenDao.findStudentByName(name);
    }

    @Override
    public boolean delCourseById(String id) {
        if(id == null)
            return false;
        if(coursenDao.findCourseById(id) == null)
            return false;
        coursenDao.delCourseById(id);
        return true;
    }

    @Override
    public boolean updateCourseById(String id, String name, String cost) {
        return false;
    }

    @Override
    public boolean addCourse(String name, String cost) {
        return false;
    }
}
