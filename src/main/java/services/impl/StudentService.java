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
        return studentDao.findStudentById(id);
    }

    @Override
    public List<Student> findStudentByGrade(String grade) {
        return studentDao.findStudentByGrade(grade);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return studentDao.findStudentByName(name);
    }

    @Override
    public boolean delStudentById(String id) {
        if(id == null)
            return false;
        if(studentDao.findStudentById(id) == null)
            return false;

        studentDao.delStudentById(id);
        return true;
    }

    @Override
    public boolean updateStudentById(String id, String name, String sex, String grade, String parentsTel) {
        if(id == null)
            return false;
        if(name == null)
            return false;
        if(sex == null)
            return false;
        if(grade == null)
            return false;
        if(parentsTel == null)
            return false;
        Student result = studentDao.findStudentById(id);
        if(result == null)
            return false;

        result.setName(name);
        result.setSex(sex);
        result.setGrade(grade);
        result.setParentsTel(parentsTel);

        studentDao.updateStudentById(result);

        return true;
    }

    @Override
    public boolean addStudent(String name, String sex, String grade, String parentsTel) {

        if(name == null)
            return false;
        if(sex == null)
            return false;
        if(grade == null)
            return false;
        if(parentsTel == null)
            return false;
        Student student = new Student();

        student.setName(name);
        student.setSex(sex);
        student.setGrade(grade);
        student.setParentsTel(parentsTel);

        studentDao.addStudent(student);

        return true;
    }
}
