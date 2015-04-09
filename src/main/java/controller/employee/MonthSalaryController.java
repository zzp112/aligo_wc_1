package controller.employee;

import com.alibaba.fastjson.JSON;
import entities.employee.DockPay;
import entities.employee.PayRecord;
import entities.employee.Premium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.employee.IDockPayService;
import services.employee.IPayRecordService;
import services.employee.IPremiumService;

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
public class MonthSalaryController {

    @Autowired
    private IPayRecordService payRecordService;
    @Autowired
    private IPremiumService premiumService;
    @Autowired
    private IDockPayService dockPayService;

    private  static  int Id;
    private  static  int year;
    private  static  int month;


    //访问MonthSalary页面
    @RequestMapping("/employee/MonthSalary")
    public void MonthSalary(){}

    @ResponseBody
    @RequestMapping("/employee/loadAllMonthEmployeeSalary")
    public String loadAllMonthEmployeeSalary(@RequestParam(value="year") int year,@RequestParam(value="month") int month){

        return JSON.toJSONString(payRecordService.findemployeesalaryByDate(year,month));

    }

    //访问AddMonthSalary页面
    @RequestMapping("/employee/AddMonthSalary")
    public void AddMonthSalary(){}


    //访问AddMonthSalary页面
    @RequestMapping(value = "/employee/AddMonthSalarys",method= RequestMethod.POST)
    public void AddMonthSalarys(Premium premium,DockPay dockPay,PayRecord payRecord,String yea,HttpServletResponse response){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date year=new Date();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            year = simpleDateFormat.parse(yea);
            premium.setYears(year);
            dockPay.setYears(year);
            payRecord.setYears(year);
            premiumService.addPremium(premium);
            dockPayService.addDockPay(dockPay);
            payRecordService.addPayRecord(payRecord);
            out.write("ok");
        } catch (Exception e) {
            out.write("error:}"+e.getMessage());
        } finally {
            out.flush();
            out.close();
        }


    }

    //访问MonthSalaryDetailed界面
    @RequestMapping("/employee/MonthSalaryDetailed")
    public void MonthSalaryDetailed() {}

    //访问MonthSalaryDetailed界面传值
    @RequestMapping(value = "/employee/gotoMonthSalaryDetailed",method = RequestMethod.POST)
    public void gotoMonthSalaryDetailed(@RequestParam(value="employeeId") String employeeId,@RequestParam(value="yea")  String yea, @RequestParam(value="mon") String mon,HttpServletResponse response) {
        Id=Integer.parseInt(employeeId);
        year=Integer.parseInt(yea);
        month=Integer.parseInt(mon);
        System.out.print(Id+"=========================");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //把信息放到MonthSalaryDetailed界面里
    @ResponseBody
    @RequestMapping(value = "/employee/MonthSalaryDetailedInformation",method = RequestMethod.POST)
    public String MonthSalaryDetailedInformation(HttpServletResponse response) {

        List list=new ArrayList();
        System.out.println(Id + year + month + "=============================");
        list.add(premiumService.findPremiumDaoById(Id,year,month));
        list.add(dockPayService.findDockPayById(Id,year,month));
        list.add(payRecordService.findPayRecodById(Id,year,month));
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);


    }

}
