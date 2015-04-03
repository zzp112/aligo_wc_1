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
 * Created by Administrator on 2015/4/3.
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

//
//    /**
//     * 删除学生
//     * @param id 学生id
//     * @return 学生
//     */
//    @ResponseBody
//    @RequestMapping("/Student/delStudentById")
//    public String delStudentById(@RequestParam(value="id") String id){
////        测试路径：/Student/delStudentById?id=x
//        return JSON.toJSONString(StudentService.delStudentById(id));
//    }
//
//    /**
//     * 更新学生收入
//     * @param id 学生id
//     * @param totalAmount 学生收入
//     * @return 是否成功
//     */
//    @ResponseBody
//    @RequestMapping("/Student/updateStudentTotalById")
//    public String updateStudentTotalById(@RequestParam(value="id") String id, @RequestParam(value="totalAmount") String totalAmount){
////        测试路径：/Student/updateStudentTotalById?id=x&totalAmount=1024
//        return JSON.toJSONString(StudentService.updateStudentTotalById(id, totalAmount));
//    }
//
//    /**
//     * 更新学生所有信息
//     * @param id 学生id
//     * @param address 学生地址
//     * @param managerId 负责人Id
//     * @param accountRatio 拆账比例，格式：(0.x) 或 (0.xx)
//     * @param totalAmount 总收入
//     * @return 是否成功
//     */
//    @ResponseBody
//    @RequestMapping("/Student/updateStudentById")
//    public String updateStudentById(@RequestParam(value="id") String id,@RequestParam(value="address") String address,
//                                    @RequestParam(value="managerId") String managerId,@RequestParam(value="accountRatio") String accountRatio,
//                                    @RequestParam(value="totalAmount") String totalAmount){
////        测试路径：/Student/updateStudentById?id=x&address=软件大楼&managerId=1&accountRatio=0.6&totalAmount=1000
//        String addressInChinise = null;
//        try {
//            addressInChinise = new String(address.getBytes("ISO-8859-1"), "UTF-8");
//        } catch (UnsupportedEncodingException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//        return JSON.toJSONString(StudentService.updateStudentById(id, addressInChinise, managerId, accountRatio, totalAmount));
//    }
//
//    /**
//     * 添加学生
//     * @param address 学生地址
//     * @param managerId 负责人Id
//     * @param accountRatio 拆账比例，格式：(0.x) 或 (0.xx)
//     * @return 是否成功
//     */
//    @ResponseBody
//    @RequestMapping("/Student/addStudent")
//    public String addStudent(@RequestParam(value="address") String address,@RequestParam(value="managerId") String managerId,
//                             @RequestParam(value="accountRatio") String accountRatio){
////        测试路径：/Student/addStudent?address=南方&managerId=1&accountRatio=0.6
//
//        String addressInChinise = null;
//        try {
//            addressInChinise = new String(address.getBytes("ISO-8859-1"), "UTF-8");
//        } catch (UnsupportedEncodingException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//        return JSON.toJSONString(StudentService.addStudent(addressInChinise, managerId, accountRatio));
//    }
}
