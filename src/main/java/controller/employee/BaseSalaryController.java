package controller.employee;

import com.alibaba.fastjson.JSON;
import entities.employee.EmployeeBaseInfo;
import entities.employee.EmployeeSalaryStructure;
import entities.employee.SalaryStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.employee.IEmployeeBaseInfoService;
import services.employee.IEmployeeInfoService;
import services.employee.ISalaryStructureService;

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
public class BaseSalaryController {

    @Autowired
    private IEmployeeBaseInfoService iEmployeeBaseInfoService;

    @Autowired
    private ISalaryStructureService iSalaryStructureService;
    //访问BaseSalary页面
    @Autowired
    private IEmployeeInfoService employeeInfoService;
    private  static  int Id;
    //访问BaseSalary页面
    @RequestMapping("/employee/BaseSalary")
    public void BaseSalary(){}

    /**
     * 查询所以的基础员工信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/employee/loadAllBaseSalary")
    public String loadAllStudent(){

        return JSON.toJSONString(iEmployeeBaseInfoService.findemployeesalary());
    }

    /**
     * 根据条件查询
     * @return
     */
    @ResponseBody
    @RequestMapping("/employee/loadAllBaseSalaryByselecy")
    public String loadAllBaseSalaryByselecy(String select){
        List<EmployeeSalaryStructure> lists=iEmployeeBaseInfoService.findemployeesalary();
        List<EmployeeSalaryStructure> list=new ArrayList<EmployeeSalaryStructure>();
        for(EmployeeSalaryStructure ecture:lists)
        {
            if(ecture.getEmployeeId().toString().contains(select)||ecture.getName().contains(select)||ecture.getDepartMent().contains(select))
            {
                list.add(ecture);
            }
        }
        return JSON.toJSONString(list);
    }

    @ResponseBody
    @RequestMapping("/employee/findBaseSalaryById")
    public String findBaseSalaryById(@RequestParam(value="employeeId") int employeeId){

        return JSON.toJSONString(iEmployeeBaseInfoService.findemployeesalaryById(employeeId));
    }


    //访问AddBaseSalary页面
    @RequestMapping("/employee/AddBaseSalary")
    public void AddBaseSalary(){}

    //添加一个基本员工信息
    @RequestMapping(value = "/employee/AddBaseSalarys",method = RequestMethod.POST)
    public void AddBaseSalarys(EmployeeBaseInfo employeeBaseInfo,SalaryStructure salaryStructure,String hireTimes,HttpServletResponse response){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date births=new Date();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            births = simpleDateFormat.parse(hireTimes);
            employeeBaseInfo.setHireTime(births);
            iEmployeeBaseInfoService.addEmployeeBaseInfo(employeeBaseInfo);
            iSalaryStructureService.addSalaryStructure(salaryStructure);
            out.write("ok");
        } catch (Exception e) {
            out.write("error:}"+e.getMessage());
        } finally {
            out.flush();
            out.close();
        }


    }
    //访问EmployeeDetailed界面
    @RequestMapping("/employee/BaseSalaryDetailed")
    public void BaseSalaryDetailed() {

        //  return JSON.toJSONString(employeeInfoService.findEmployeeInfoById(Id));
    }

    //访问BaseSalaryDetailed界面传值
    @RequestMapping(value = "/employee/gotoBaseSalaryDetailed",method = RequestMethod.POST)
    public void gotoBaseSalaryDetailed(String employeeId,HttpServletResponse response) {
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

    //把信息放到BaseSalaryDetailed界面里
    @ResponseBody
    @RequestMapping(value = "/employee/BaseSalaryDetailedInformation",method = RequestMethod.POST)
    public String BaseSalaryDetailedInformation () {
        List list=new ArrayList();
        list.add(employeeInfoService.findEmployeeInfoById(Id));
        list.add(iEmployeeBaseInfoService.findEmployeeBaseInfoById(Id));
        list.add(iSalaryStructureService.findSalaryStructureById(Id));
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/employee/UpdateBaseSalary",method = RequestMethod.POST)
    public void UpdateBaseSalary (EmployeeBaseInfo employeeBaseInfo,SalaryStructure salaryStructure,String date,HttpServletResponse response) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hireTime=new Date();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            hireTime = simpleDateFormat.parse(date);
           employeeBaseInfo.setHireTime(hireTime);
           iEmployeeBaseInfoService.updateEmployeeBaseInfo(employeeBaseInfo);
            iSalaryStructureService.updateSalaryStructure(salaryStructure);
            out.write("ok");
        } catch (Exception e) {
            out.write("error:}"+e.getMessage());
        } finally {
            out.flush();
            out.close();
        }


    }

}
