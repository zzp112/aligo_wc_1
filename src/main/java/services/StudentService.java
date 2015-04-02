package services;

import dao.StudentDao;
import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015/4/1 0001.
 */
@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    public List<Student> findAllStudents() {
        return studentDao.findAllUsers();
    }
}
