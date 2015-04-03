package controller;

import com.alibaba.fastjson.JSON;
import entities.PaymentDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.IPaymentDetailService;
import services.impl.PaymentDetailService;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 张超红 on 2015-04-01.
 */
@Controller
public class PaymentDetailController {
    @Autowired
    private PaymentDetailService paymentDetailService;

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

        if (paymentDetailService.CreatePaymentDetail(paymentDetail)) {
            System.out.println("创建一条新的小站支出记录成功..." + paymentDetail);
        } else {
            System.out.println("创建失败...");
        }
        return "PaymentDetail/ListPaymentDetails";
    }

    /**
     * 删除一条明细记录
     * @return
     */
    @RequestMapping(value = "deleteCurrentRowPaymentDetail")
    public String deletePaymentDetail(Integer detail_id ){
        paymentDetailService.DeletePaymentDetail(detail_id);
        return "PaymentDetail/ListPaymentDetails";
    }

    /**
     * 更新选中行小站支出明细
     * @return
     */
    @RequestMapping(value = "updateCurrentRowPaymentDetail")
    public String updateCurrentRowPaymentDetail(){
        return "PaymentDetail/ListPaymentDetails";
    }
}
