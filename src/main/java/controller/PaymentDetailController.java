package controller;

import AuthorityException.DataException;
import com.alibaba.fastjson.JSON;
import entities.PaymentDetail;
import entities.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.IPaymentDetailService;
import services.IStationService;
import services.impl.PaymentDetailService;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import entities.PaymentDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.IPaymentDetailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 张超红 on 2015-04-01.
 */
@Controller
public class PaymentDetailController {

    private static final String JSON_STR = "jsonpCallback";
    @Autowired
    private IPaymentDetailService paymentDetailService;

    /**
     * 创建小站收支明细对象
     */
    @Autowired
    PaymentDetail paymentDetail;
    /**
     * 创建小站对象
     */
    Station station;
    /**
     * 创建小站服务对象
     */
    @Autowired
    IStationService iStationService;

    /**
     * 返回出所有小站收支数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAllPaymentDetails")
    public String selectAllPayment() {
        return JSON.toJSONString(paymentDetailService.findAllPaymentDetails());
    }

    /**
     * 控制跳转到小站收入，支出显示界面
     *
     * @return
     */
    @RequestMapping(value = "/toListPaymentDetails")
    public String toListPaymentDetails(ModelMap modelMap) {
        List<Station> listStationId = iStationService.findAllStation();
        modelMap.put("stationList", listStationId);
        return "PaymentDetail/ListPaymentDetails";
    }

    /**
     * 控制跳转到小站收支明细输入界面
     *
     * @return
     */
    @RequestMapping(value = "/toInputPaymentDetails")
    public String toInputPaymentDetails() {
        return "PaymentDetail/toInputPaymentDetail";
    }


    /**
     * 跳转到更新页面
     *
     * @return
     */
    @RequestMapping(value = "toUpdateCurrentRowPaymentDetail")
    public String toUpdateCurrentRowPaymentDetail(@RequestParam("detail_id") Integer detail_id, ModelMap modelMap) {
        paymentDetail = paymentDetailService.findPaymentDetailById(detail_id);
        modelMap.put("paymentDetail", paymentDetail);
        return "PaymentDetail/UpdatePaymentDetails";
    }

    //控制欢迎页面
    @RequestMapping(value = "/welcome")
    public String toWelcome() {
        return "welcome";
    }

    /**
     * 创建一条收支记录
     *
     * @return
     */
    @RequestMapping(value = "/CreatePaymentDetail")
    public String CreatePaymentDetail(HttpServletRequest request,
//            @Param("station_id") String station_id, @Param("create_date") Date create_date, @Param("advice") String advice,
//            @Param("balance_type") String balance_type, @Param("balance") String balance,
//            @Param("balance_amount") Integer balance_amount
                                      ModelMap modelMap
    ) {

        PaymentDetail paymentDetail = new PaymentDetail();

        String station_id = request.getParameter("station_id");
        String create_date = request.getParameter("create_date");
        String advice = request.getParameter("advice");
        String balance_type = request.getParameter("balance_type");
        String balance = request.getParameter("balance");
        double balance_amount = Double.parseDouble(request.getParameter("balance_amount"));
        String updateImfor = new String();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            paymentDetail.setStation_id(new String(station_id.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetail.setBalance_comment(new String(advice.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetail.setBalance_type(new String(balance_type.getBytes("ISO-8859-1"), "UTF-8"));
//            paymentDetail.setCreate_date(format.format(create_date));
            paymentDetail.setCreate_date(create_date);
            paymentDetail.setBalance(balance);
            paymentDetail.setBalance_amount(balance_amount);
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            paymentDetailService.CreatePaymentDetail(paymentDetail);
            System.out.println("创建一条新的小站支出记录成功..." + paymentDetail);
            modelMap.put("IsRight","yes");
        } catch (DataException Exception) {
            System.out.println("创建失败..." + Exception.getMessage());
            modelMap.put("IsRight","no");
        }
        //重定向到列表界面
        return "PaymentDetail/ListPaymentDetails";
    }

    /**
     * 删除一条明细记录
     *
     * @return
     */
    @RequestMapping(value = "deleteCurrentRowPaymentDetail")
    public String deletePaymentDetail(@RequestParam("detail_id") Integer detail_id) {
        paymentDetailService.DeletePaymentDetail(detail_id);
        return "redirect:/toListPaymentDetails";
    }


    /**
     * 更新数据
     *
     * @return
     */
    @RequestMapping(value = "/updateCurrentRowPaymentDetail")
    public String updateCurrentRowPaymentDetail(HttpServletRequest request,
//            @Param("station_id") String station_id, @Param("create_date") Date create_date, @Param("balance") String balance,
//            @Param("balance_amount") double balance_amount,@Param("balance_type") String balance_type, @Param("advice") String advice,
                                                ModelMap modelMap) {
        String station_id = request.getParameter("station_id");
        String create_date = request.getParameter("create_date");
        String advice = request.getParameter("advice");
        String balance_type = request.getParameter("balance_type");
        String balance = request.getParameter("balance");
        double balance_amount = Double.parseDouble(request.getParameter("balance_amount"));
        String updateImfor = new String();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("正在更新中...");
        try {
            paymentDetail.setStation_id(new String(station_id.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetail.setBalance_comment(new String(advice.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetail.setBalance_type(new String(balance_type.getBytes("ISO-8859-1"), "UTF-8"));
//            paymentDetails.setCreate_date(format.format(create_date));
            paymentDetail.setCreate_date(create_date);
            paymentDetail.setBalance(balance);
            paymentDetail.setBalance_amount(balance_amount);
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            paymentDetailService.UpdatePaymentDetail(paymentDetail);
            updateImfor = "修改一条新的小站支出记录成功...";
            modelMap.put("successImfor", updateImfor);
        } catch (DataException Exception) {
            System.out.println("修改失败..." + Exception.getMessage() + Exception.getCause());
            modelMap.put("failImfor", updateImfor);
        }
        System.out.println(updateImfor);
        //刷新到修改页面
        return "PaymentDetail/UpdatePaymentDetails";
    }

    /**
     * 跳转到更新页面
     *
     * @return
     */
    @RequestMapping(value = "/topdateCurrentRowPaymentDetail")
    public String updateCurrentRowPaymentDetail(@RequestParam("detail_id") Integer detail_id, Model model) {
        paymentDetail = paymentDetailService.findPaymentDetailById(detail_id);
//        model.addAttribute("",paymentDetail.getDetail_id());
        model.addAttribute("station_id", paymentDetail.getStation_id());
        model.addAttribute("balance", paymentDetail.getBalance());
        model.addAttribute("balance_type", paymentDetail.getBalance_type());
        model.addAttribute("balance_amount", paymentDetail.getBalance_amount());
        model.addAttribute("create_date", paymentDetail.getCreate_date());
        model.addAttribute("advice", paymentDetail.getBalance_comment());
        return "PaymentDetail/ListPaymentDetails";
    }

    /**
     * 按类别查询收支明细记录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchPaymentDetail")
    public String searchPaymentDetail(String balance, HttpServletResponse response) {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(JSON_STR + "(" + JSON.toJSONString(paymentDetailService.search(balance)) + ")");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            out.close();
        }
        return null;
    }

    /**
     * 按日期查询收支明细记录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchPaymentDetailByTime")
    public String searchPaymentDetailByTime(@RequestParam("start_time") String begin_time, @RequestParam("end_time") String end_time, HttpServletResponse response) {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(JSON_STR + "(" + JSON.toJSONString(paymentDetailService.searchByTime(begin_time, end_time)) + ")");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
        return null;
    }

    /**
     * 按收支类别日期查询收支明细记录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchByAll", method = RequestMethod.POST, params = "json")
    public String searchByAll(@RequestBody Map<String, Object> info) {
        System.out.println("success");
        List<PaymentDetail> list = new ArrayList<PaymentDetail>();
        String s1 = "", s2 = "", s3 = "";
        System.out.println(info.toString());

        s1 = (String) info.get("balance");
        s2 = (String) info.get("begin_time");
        s3 = (String) info.get("end_time");
        // list = paymentDetailService.searchByAll(s1,s2,s3);
        return JSON.toJSONString(paymentDetailService.searchByAll(s1, s2, s3));
    }
}
