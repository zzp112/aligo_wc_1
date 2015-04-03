package services.impl;

import dao.StudentDao;
import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.IStudentService;

import java.util.List;

/**
 * Created by HJ on 2015/4/3.
 */
@Service
@Transactional
public class StudentService implements IStudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAllStudent() { return studentDao.findAllStudent();}

    @Override
    public Student findStudentById(String id) {
        return null;
    }

    @Override
    public List<Student> findStudentByGrade(String grade) {
        return null;
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return null;
    }

    @Override
    public boolean delStudentById(String id) {
        return false;
    }

    @Override
    public boolean updateStudentById(String id, String name, String sex, String grade, String parentsTel) {
        return false;
    }

    @Override
    public boolean addStudent(String name, String sex, String grade, String parentsTel) {
        return false;
    }
}
