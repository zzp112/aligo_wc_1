package services.impl;

import entities.Student;
import org.mybatis.spring.SqlSessionTemplate;
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
    private SqlSessionTemplate sqlSession;

    @Override
    public List<Student> findAllStudent() {return sqlSession.selectList("student.findAllStudent");}

    @Override
    public Student findStudentById(String id) {
        return sqlSession.selectOne("student.findStudentById", id);
    }

    @Override
    public List<Student> findStudentByGrade(String grade) {
        return sqlSession.selectList("student.findStudentByGrade",grade);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return sqlSession.selectList("student.findStudentByName", name);
    }

    @Override
    public List<Student> findStudentByNameAndGrade(Student student){
        return sqlSession.selectList("student.findStudentByNameAndGrade", student);
    }
    @Override
    public boolean delStudentById(String id) {
        if(id == null)
            return false;
        if(this.findStudentById(id) == null)
            return false;

        sqlSession.delete("student.delStudentById", id);
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
        Student result = this.findStudentById(id);
        if(result == null)
            return false;

        result.setName(name);
        result.setSex(sex);
        result.setGrade(grade);
        result.setParentsTel(parentsTel);

        sqlSession.update("student.updateStudentById", result);

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

        sqlSession.insert("student.addStudent", student);

        return true;
    }
}
