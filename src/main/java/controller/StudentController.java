package controller;

import com.alibaba.fastjson.JSON;
import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.StudentService;

import java.util.List;

/**
 * Created by Administrator on 2015-03-29.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    //加载学生数据
    @ResponseBody
    @RequestMapping(value = "/findAllStudent")
    public String findAllStudent(){
        List<Student> list=studentService.findAllStudents();
        return JSON.toJSONString(list);
    }

    //到显示学生列表页面
    @RequestMapping(value = "/toListStudent")
    public String welcome(){
        return "student/listStudent";
    }
}
