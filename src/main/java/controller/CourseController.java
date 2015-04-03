package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.ICourseService;

/**
 * Created by Administrator on 2015/4/3.
 */
@Controller
public class CourseController {
    @Autowired
    private ICourseService CourseService;
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
        return JSON.toJSONString(CourseService.findAllCourse());
    }

//    /**
//     * 通过id查找课程
//     * @param id 课程id
//     * @return 课程信息json
//     */
//    @ResponseBody
//    @RequestMapping("/Course/findCourseById")
//    public String findCourseById(@RequestParam(value="id") String id){
////        测试路径：/Course/findCourseById?id=x
//        return JSON.toJSONString(CourseService.findCourseById(id));
//    }
//
//    /**
//     * 删除课程
//     * @param id 课程id
//     * @return 课程
//     */
//    @ResponseBody
//    @RequestMapping("/Course/delCourseById")
//    public String delCourseById(@RequestParam(value="id") String id){
////        测试路径：/Course/delCourseById?id=x
//        return JSON.toJSONString(CourseService.delCourseById(id));
//    }
//
//    /**
//     * 更新课程收入
//     * @param id 课程id
//     * @param totalAmount 课程收入
//     * @return 是否成功
//     */
//    @ResponseBody
//    @RequestMapping("/Course/updateCourseTotalById")
//    public String updateCourseTotalById(@RequestParam(value="id") String id, @RequestParam(value="totalAmount") String totalAmount){
////        测试路径：/Course/updateCourseTotalById?id=x&totalAmount=1024
//        return JSON.toJSONString(CourseService.updateCourseTotalById(id, totalAmount));
//    }
//
//    /**
//     * 更新课程所有信息
//     * @param id 课程id
//     * @param address 课程地址
//     * @param managerId 负责人Id
//     * @param accountRatio 拆账比例，格式：(0.x) 或 (0.xx)
//     * @param totalAmount 总收入
//     * @return 是否成功
//     */
//    @ResponseBody
//    @RequestMapping("/Course/updateCourseById")
//    public String updateCourseById(@RequestParam(value="id") String id,@RequestParam(value="address") String address,
//                                    @RequestParam(value="managerId") String managerId,@RequestParam(value="accountRatio") String accountRatio,
//                                    @RequestParam(value="totalAmount") String totalAmount){
////        测试路径：/Course/updateCourseById?id=x&address=软件大楼&managerId=1&accountRatio=0.6&totalAmount=1000
//        String addressInChinise = null;
//        try {
//            addressInChinise = new String(address.getBytes("ISO-8859-1"), "UTF-8");
//        } catch (UnsupportedEncodingException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//        return JSON.toJSONString(CourseService.updateCourseById(id, addressInChinise, managerId, accountRatio, totalAmount));
//    }
//
//    /**
//     * 添加课程
//     * @param address 课程地址
//     * @param managerId 负责人Id
//     * @param accountRatio 拆账比例，格式：(0.x) 或 (0.xx)
//     * @return 是否成功
//     */
//    @ResponseBody
//    @RequestMapping("/Course/addCourse")
//    public String addCourse(@RequestParam(value="address") String address,@RequestParam(value="managerId") String managerId,
//                             @RequestParam(value="accountRatio") String accountRatio){
////        测试路径：/Course/addCourse?address=南方&managerId=1&accountRatio=0.6
//
//        String addressInChinise = null;
//        try {
//            addressInChinise = new String(address.getBytes("ISO-8859-1"), "UTF-8");
//        } catch (UnsupportedEncodingException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//        return JSON.toJSONString(CourseService.addCourse(addressInChinise, managerId, accountRatio));
//    }
}
