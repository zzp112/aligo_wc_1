package controller.employee;

import com.alibaba.fastjson.JSON;
import entities.employee.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import services.employee.IEmployeeInfoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/4/7.
 */
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeInfoService employeeInfoService;

    private  static  int Id;

    //访问EmployeeInfo界面
    @RequestMapping("/employee/EmployeeInfo")
    public void EmployeeInfo() {

    }

    //查询所以的员工信息
    @ResponseBody
    @RequestMapping("/employee/loadAllEmployee")
    public String loadAllStudent() {

        return JSON.toJSONString(employeeInfoService.findAllEmployeeInfo());
    }

    //根据关键字查询
    @ResponseBody
    @RequestMapping("/employee/finEmployeeBySelect")
    public String finEmployeeBySelect(String select) {
        List<EmployeeInfo> lists=employeeInfoService.findAllEmployeeInfo();
        List<EmployeeInfo> list=new ArrayList<EmployeeInfo>();
        for(EmployeeInfo employeeInfo:lists)
        {
            if(employeeInfo.getEmployeeId().toString().contains(select)||employeeInfo.getName().contains(select)||employeeInfo.getPhone().contains(select)||employeeInfo.getJobs().contains(select)||employeeInfo.getState().contains(select))
            {
                list.add(employeeInfo);
            }
        }
        return JSON.toJSONString(list);
    }

    //根据ID去寻找员工信息
    @ResponseBody
    @RequestMapping("/employee/finEmployeeId")
    public String finEmployeeId() {
        return JSON.toJSONString(employeeInfoService.finEmployeeId());
    }

    //访问AddEmployee界面
    @RequestMapping("/employee/AddEmployee")
    public void AddEmployee() {
    }

    //访问EmployeeDetailed界面
    @RequestMapping("/employee/EmployeeDetailed")
    public void EmployeeDetailed() {

      //  return JSON.toJSONString(employeeInfoService.findEmployeeInfoById(Id));
    }

    //把信息放到EmployeeDetailed界面里
    @ResponseBody
    @RequestMapping(value = "/employee/EmployeeDetailedInformation",method = RequestMethod.POST)
    public String EmployeeDetailedInformation () {

       return JSON.toJSONString(employeeInfoService.findEmployeeInfoById(Id));
    }

    //访问EmployeeDetailed界面传值
    @RequestMapping(value = "/employee/gotoEmployeeDetailed",method = RequestMethod.POST)
    public void gotoEmployeeDetailed(String employeeId,HttpServletResponse response) {
        Id=Integer.parseInt(employeeId);
        System.out.print(Id+"=========================");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/employee/UpdateEmployeeInfo",method = RequestMethod.POST)
    public void UpdateEmployeeInfo(EmployeeInfo employeeInfo,String birth,HttpServletResponse response) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date births=new Date();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            births = simpleDateFormat.parse(birth);
            employeeInfo.setBirthday(births);
            employeeInfoService.updateEmployeeInfo(employeeInfo);
            out.write("ok");
        } catch (Exception e) {
            out.write("error:}" + e.getMessage());
        } finally {
            out.flush();
            out.close();
        }



    }
    //添加一个员工信息
    @RequestMapping(value = "/employee/AddEmployeeInfo",method = RequestMethod.POST)
    public void AddEmployeeInfo(EmployeeInfo employeeInfo,String birth,HttpServletResponse response) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date births=new Date();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            births = simpleDateFormat.parse(birth);
            employeeInfo.setBirthday(births);
          //  EmployeeInfo employeeInfo = new EmployeeInfo(name, sex, birth, Integer.parseInt(age), hometownAddress, phone, presentAddress, qq, Integer.parseInt(educationYear), educationSchool, educationCollege, major, marriage, idNumber, jobs, email, emergencyContact, relationship, ecAddress, emergencyContactPhone);
            employeeInfoService.addEmployeeInfo(employeeInfo);
            out.write("ok");
        } catch (Exception e) {
            out.write("error:}"+e.getMessage());
        } finally {
            out.flush();
            out.close();
        }

    }


}

