package entities;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2015-03-29.
 */
@Repository
public class Student {
    private String student_name;
    private String student_sex;
    private String course_name;
    private String teacher_name;
    private String telephone;

    public Student(String student_name, String student_sex, String course_name, String teacher_name, String telephone) {
        this.student_name=student_name;
        this.student_sex=student_sex;
        this.course_name=course_name;
        this.teacher_name=teacher_name;
        this.telephone=telephone;
    }

    public Student(){

    }
    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "这位同学的名字是:"+this.student_name;
    }
}
