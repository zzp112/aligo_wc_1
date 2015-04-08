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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.IPaymentDetailService;
import services.IStationService;
import services.impl.PaymentDetailService;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 张超红 on 2015-04-01.
 */
@Controller
public class PaymentDetailController {
    @Autowired
    private IPaymentDetailService paymentDetailService;

    /**
     * 创建小站收支明细对象
     */
    @Autowired
    PaymentDetail paymentDetails;

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
        List<Station> listStationId=iStationService.findAllStation();
        modelMap.put("stationList",listStationId);
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

    //控制欢迎页面
    @RequestMapping(value = "/welcome")
    public String toWelcome() {
        return "welcome";
    }

    /**
     * 跳转到更新页面
     *
     * @return
     */
    @RequestMapping(value = "toUpdateCurrentRowPaymentDetail")
    public String toUpdateCurrentRowPaymentDetail(@RequestParam("detail_id") Integer detail_id, ModelMap modelMap) {
        paymentDetails  = paymentDetailService.findPaymentDetailById(detail_id);
        modelMap.put("paymentDetail", paymentDetails);
        return "PaymentDetail/UpdatePaymentDetails";
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
        System.out.println("正在插入数据...");
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

        try {
            paymentDetailService.CreatePaymentDetail(paymentDetail);
            System.out.println("创建一条新的小站支出记录成功..." + paymentDetail);
        } catch (DataException Exception) {
            System.out.println("创建失败..." + Exception.getMessage());
        }
        //重定向到列表界面
        return "redirect:/toListPaymentDetails";
    }

    /**
     * 删除一条明细记录
     *
     * @return
     */
    @RequestMapping(value = "/deleteCurrentRowPaymentDetail")
    public String deletePaymentDetail(@RequestParam("detail_id") Integer detail_id) {
        paymentDetailService.DeletePaymentDetail(detail_id);
        return "redirect:/toListPaymentDetails";
    }

    /**
     * 更新数据
     * @param station_id
     * @param create_date
     * @param advice
     * @param balance_type
     * @param balance
     * @param balance_amount
     * @return
     */
    @RequestMapping(value = "/updateCurrentRowPaymentDetail")
    public String updateCurrentRowPaymentDetail(
            @Param("station_id") String station_id, @Param("create_date") Date create_date, @Param("balance") String balance,
            @Param("balance_amount") double balance_amount,@Param("balance_type") String balance_type, @Param("advice") String advice
    ,ModelMap modelMap) {

        String updateImfor=new String();
        System.out.println("正在更新中...");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("正在更新中...");
        try {
            paymentDetails.setStation_id(new String(station_id.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetails.setBalance_comment(new String(advice.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetails.setBalance_type(new String(balance_type.getBytes("ISO-8859-1"), "UTF-8"));
            paymentDetails.setCreate_date(format.format(create_date));
            paymentDetails.setBalance(balance);
            paymentDetails.setBalance_amount(balance_amount);
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            paymentDetailService.UpdatePaymentDetail(paymentDetails);
            updateImfor="修改一条新的小站支出记录成功...";
            modelMap.put("successImfor", updateImfor);
        } catch (DataException Exception) {
            System.out.println("修改失败..." + Exception.getMessage()+Exception.getCause());
            modelMap.put("failImfor",updateImfor);
        }
        System.out.println(updateImfor);
        //刷新到修改页面
        return "PaymentDetail/UpdatePaymentDetails";
    }

    @RequestMapping(value = "/update")
    public String update(){
        System.out.println("正在更新中...");
        return "redirect:toListPaymentDetails";
    }


}
