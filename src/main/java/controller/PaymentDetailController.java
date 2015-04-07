package controller;

import AuthorityException.DataException;
import com.alibaba.fastjson.JSON;
import entities.PaymentDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.IPaymentDetailService;
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
    PaymentDetail paymentDetail;
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
    public String toListPaymentDetails() {
        return "PaymentDetail/ListPaymentDetails";
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
    public String CreatePaymentDetail(
            @Param("station_id") String station_id, @Param("create_date") Date create_date, @Param("advice") String advice,
            @Param("balance_type") String balance_type, @Param("balance") String balance,
            @Param("balance_amount") Integer balance_amount
    ) {
        PaymentDetail paymentDetail = new PaymentDetail();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            paymentDetail.setStation_id(new String(station_id.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetail.setBalance_comment(new String(advice.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetail.setBalance_type(new String(balance_type.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetail.setCreate_date(format.format(create_date));
            paymentDetail.setBalance(balance);
            paymentDetail.setBalance_amount(balance_amount);
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        }

        try{
            paymentDetailService.CreatePaymentDetail(paymentDetail);
            System.out.println("创建一条新的小站支出记录成功..." + paymentDetail);
        } catch (DataException Exception){
            System.out.println("创建失败..."+Exception.getMessage());
        }
        //重定向到列表界面
        return "redirect:/toListPaymentDetails";
    }

    /**
     * 删除一条明细记录
     * @return
     */
    @RequestMapping(value = "deleteCurrentRowPaymentDetail")
    public String deletePaymentDetail(@RequestParam("detail_id")Integer detail_id ){
        paymentDetailService.DeletePaymentDetail(detail_id);
        return "redirect:/toListPaymentDetails";
    }

    /**
     * 跳转到更新页面
     * @return
     */
    @RequestMapping(value = "updateCurrentRowPaymentDetail")
    public String updateCurrentRowPaymentDetail(@RequestParam("detail_id") Integer detail_id,Model model){
        paymentDetail=paymentDetailService.findPaymentDetailById(detail_id);
//        model.addAttribute("",paymentDetail.getDetail_id());
        model.addAttribute("station_id",paymentDetail.getStation_id());
        model.addAttribute("balance",paymentDetail.getBalance());
        model.addAttribute("balance_type",paymentDetail.getBalance_type());
        model.addAttribute("balance_amount",paymentDetail.getBalance_amount());
        model.addAttribute("create_date",paymentDetail.getCreate_date());
        model.addAttribute("advice",paymentDetail.getBalance_comment());
        return "PaymentDetail/ListPaymentDetails";
    }

    /**
     * 按类别查询收支明细记录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchPaymentDetail")
    public String searchPaymentDetail(String balance,HttpServletResponse response){

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out  = response.getWriter();
            out.write(JSON_STR+"("+JSON.toJSONString(paymentDetailService.search(balance)) + ")");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            out.close();
        }
        return null;
    }

    /**
     * 按日期查询收支明细记录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchPaymentDetailByTime")
    public String searchPaymentDetailByTime(@RequestParam("start_time") String begin_time,@RequestParam("end_time") String end_time ,HttpServletResponse response){

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out  = response.getWriter();
            out.write(JSON_STR+"("+JSON.toJSONString(paymentDetailService.searchByTime(begin_time, end_time)) + ")");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
        return null;
    }

    /**
     * 按收支类别日期查询收支明细记录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchByAll",method = RequestMethod.POST, params = "json")
    public String searchByAll(@RequestBody Map<String, Object> info){
        System.out.println("success");
        List<PaymentDetail> list = new ArrayList<PaymentDetail>();
        String s1="", s2="", s3="";
        System.out.println(info.toString());

        s1=(String)info.get("balance");
        s2=(String)info.get("begin_time");
        s3=(String)info.get("end_time");
        // list = paymentDetailService.searchByAll(s1,s2,s3);
        return JSON.toJSONString(paymentDetailService.searchByAll(s1, s2, s3));
    }
}
