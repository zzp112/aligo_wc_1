package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.IStudentService;
import services.impl.StudentService;

import java.io.UnsupportedEncodingException;

/**
 * Created by HJ on 2015/4/3.
 */
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    /**
     * 学生列表页面
     */
    @RequestMapping("/student/listStudent")
    public void StudentList(){}

    /**
     * 查找所有学生
     * @return 学生信息列表json
     */
    @ResponseBody
    @RequestMapping("/student/loadAllStudent")
    public String loadAllStudent(){ return JSON.toJSONString(studentService.findAllStudent()); }

    /**
     * 通过id查找学生
     * @param id 学生id
     * @return 学生信息json
     */
    @ResponseBody
    @RequestMapping("/student/findStudentById")
    public String findStudentById(@RequestParam(value="id") String id){
//        测试路径：/student/findStudentById?id=x
        return JSON.toJSONString(studentService.findStudentById(id));
    }

    /**
     * 通过年级查找学生
     * @param grade 学生年级
     * @return 学生信息json
     */
    @ResponseBody
    @RequestMapping("/student/findStudentByGrade")
    public String findStudentByGrade(@RequestParam(value="grade") String grade){
//        测试路径：/student/findStudentByGrade?grade=一年级
        String gradeUTF = null;
        try{
            gradeUTF = new String(grade.getBytes("ISO-8859-1"), "UTF-8");
        }catch (UnsupportedEncodingException exception){
            System.out.println(exception.getMessage());
        }

        return JSON.toJSONString(studentService.findStudentByGrade(gradeUTF));
    }

    /**
     * 通过姓名查找学生
     * @param name 学生年级
     * @return 学生信息json
     */
    @ResponseBody
    @RequestMapping("/student/findStudentByName")
    public String findStudentByName(@RequestParam(value="name") String name){
//        测试路径：/student/findStudentByName?name=蛋
        String nameUTF = null;
        try{
            nameUTF = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        }catch (UnsupportedEncodingException exception){
            System.out.println(exception.getMessage());
        }

        return JSON.toJSONString(studentService.findStudentByName(nameUTF));
    }


    /**
     * 删除学生
     * @param id 学生id
     * @return 学生
     */
    @ResponseBody
    @RequestMapping("/student/delStudentById")
    public String delStudentById(@RequestParam(value="id") String id){
//        测试路径：/student/delStudentById?id=x
        return JSON.toJSONString(studentService.delStudentById(id));
    }

    /**
     * 更新学生所有信息
     * @param id 学生Id
     * @param name 姓名
     * @param sex 性别
     * @param grade 年级
     * @param parentsTel 父母电话
     * @return  是否成功
     */
    @ResponseBody
    @RequestMapping("/student/updateStudentById")
    public String updateStudentById(@RequestParam(value="id") String id,@RequestParam(value="name") String name,
                                    @RequestParam(value="sex") String sex,@RequestParam(value="grade") String grade,
                                    @RequestParam(value="parentsTel") String parentsTel){
//        测试路径：/student/updateStudentById?id=x&name=蛋蛋王&sex=男&grade=一年级&parentsTel=18065149544
        String nameUTF = null;
        String sexUTF = null;
        String gradeUTF = null;
        try {
            nameUTF = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            sexUTF = new String(sex.getBytes("ISO-8859-1"), "UTF-8");
            gradeUTF = new String(grade.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        }

        return JSON.toJSONString(studentService.updateStudentById(id,nameUTF, sexUTF, gradeUTF, parentsTel));
    }

    /**
     * 添加学生
     * @param name 姓名
     * @param sex 性别
     * @param grade 年级
     * @param parentsTel 父母电话
     * @return 是否成功
     */
    @ResponseBody
    @RequestMapping("/student/addStudent")
    public String addStudent(@RequestParam(value="name") String name,
                             @RequestParam(value="sex") String sex,@RequestParam(value="grade") String grade,
                             @RequestParam(value="parentsTel") String parentsTel){
//        测试路径：/student/addStudent?name=蛋蛋王&sex=男&grade=一年级&parentsTel=18065149544

        String nameUTF = null;
        String sexUTF = null;
        String gradeUTF = null;
        try {
            nameUTF = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            sexUTF = new String(sex.getBytes("ISO-8859-1"), "UTF-8");
            gradeUTF = new String(grade.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        }

        return JSON.toJSONString(studentService.addStudent(nameUTF, sexUTF, gradeUTF,parentsTel));
    }
}
