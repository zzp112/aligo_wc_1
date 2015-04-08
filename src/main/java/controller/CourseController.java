package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.ICourseService;

import java.io.UnsupportedEncodingException;

/**
 * Created by HJ on 2015/4/3.
 */
@Controller
public class CourseController {
    @Autowired
    private ICourseService courseService;
    /**
     * 课程列表页面
     */
    @RequestMapping("/course/listCourse")
    public void CourseList(){}

    /**
     * 查找所有课程
     * @return 课程信息列表json
     */
    @ResponseBody
    @RequestMapping("/course/loadAllCourse")
    public String loadAllCourse(){
        return JSON.toJSONString(courseService.findAllCourse());
    }

    /**
     * 通过id查找课程
     * @param id 课程id
     * @return 课程信息json
     */
    @ResponseBody
    @RequestMapping("/course/findCourseById")
    public String findCourseById(@RequestParam(value="id") String id){
//        测试路径：/course/findCourseById?id=x
        return JSON.toJSONString(courseService.findCourseById(id));
    }

    /**
     * 通过name查找课程
     * @param name 课程name
     * @return 课程信息json
     */
    @ResponseBody
    @RequestMapping("/course/findCourseByName")
    public String findCourseByName(@RequestParam(value="name") String name){
//        测试路径：/course/findCourseByName?name=x
        String nameUTF = null;
        try{
            nameUTF = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        }catch (UnsupportedEncodingException exception){
            System.out.println(exception.getMessage());
        }
        return JSON.toJSONString(courseService.findCourseByName(nameUTF));
    }

    /**
     * 删除课程
     * @param id 课程id
     * @return 课程
     */
    @ResponseBody
    @RequestMapping("/course/delCourseById")
    public String delCourseById(@RequestParam(value="id") String id){
//        测试路径：/course/delCourseById?id=x
        return JSON.toJSONString(courseService.delCourseById(id));
    }


    /**
     * 更新课程所有信息
     * @param id 课程id
     * @param name 课程名
     * @param cost 课程费用
     * @return 是否成功 任意参数为空返回false，id不存在返回false
     */
    @ResponseBody
    @RequestMapping("/course/updateCourseById")
    public String updateCourseById(@RequestParam(value="id") String id, @RequestParam(value="name")String name,@RequestParam(value="cost")Integer cost){
//        测试路径：/course/updateCourseById/?id=x&name=欧姆定理&cost=998
        String nameUTF = null;
        try {
            nameUTF = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        }

        return JSON.toJSONString(courseService.updateCourseById(id, nameUTF, cost));
    }


    /**
     * 添加课程
     * @param name 课程名
     * @param cost 课程费用
     * @return 是否成功 任意参数为空返回false
     */
    @ResponseBody
    @RequestMapping("/course/addCourse")
    public String addCourse(@RequestParam(value="name") String name,@RequestParam(value="cost") Integer cost){
//        测试路径：/course/addCourse?name=欧姆定理&cost=998

        String nameUTF = null;
        try {
            nameUTF = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        }

        return JSON.toJSONString(courseService.addCourse(nameUTF,cost));
    }
}
