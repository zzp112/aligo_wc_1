package services;

import entities.Student;

import java.util.List;

/**
 * Created by Administrator on 2015/4/3.
 */
public interface IStudentService {
    public List<Student> findAllStudents();
}
