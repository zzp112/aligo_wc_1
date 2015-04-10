package controller;

import AuthorityException.DataException;
import com.alibaba.fastjson.JSON;
import entities.PaymentDetail;
import entities.PaymentDetailHelper;
import entities.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.IPaymentDetailService;
import services.IStationService;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
     * 创建小站/服务对象
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
        try{
            List<Station> listStationId = iStationService.findAllStation();
            modelMap.put("stationList", listStationId);
        }catch(DataException ex){
            modelMap.put("stationList","null");
        }
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
    public String CreatePaymentDetail(PaymentDetail paymentDetail, ModelMap modelMap
    ) {
        try {
            paymentDetailService.CreatePaymentDetail(paymentDetail);
            System.out.println("创建一条新的小站支出记录成功..." + paymentDetail);
            modelMap.put("IsRight", "yes");
        } catch (DataException Exception) {
            System.out.println("创建失败..." + Exception.getMessage());
            modelMap.put("IsRight", "no");
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
    public String updateCurrentRowPaymentDetail(PaymentDetail paymentDetail, ModelMap modelMap) {
        //更新是否成功消息定义
        String updateImfor = new String();
        System.out.println("正在更新中...");
        //标准化时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        paymentDetail.setCreate_date(format.format(paymentDetail.getCreate_date()));
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
     * 多条件查询出小站收支明细
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchPaymentDetailBySql")
    public String searchPaymentDetailBySql(PaymentDetailHelper paymentDetailHelper){
        if(paymentDetailHelper.getStart_time().equals("")){
            paymentDetailHelper.setStart_time(null);
        }
        if(paymentDetailHelper.getEnd_time().equals("")){
            paymentDetailHelper.setEnd_time(null);
        }
//        if (paymentDetailHelper.getBalance().equals("")){
//            paymentDetailHelper.setBalance(null);
//        }
//        if(paymentDetailHelper.getBalance_type().equals("")){
//            paymentDetailHelper.setBalance_type(null);
//        }
        System.out.println(paymentDetailHelper.getBalance()+":"+paymentDetailHelper.getBalance_type()+":"+paymentDetailHelper.getEnd_time()+":"+paymentDetailHelper.getStart_time());
        return JSON.toJSONString(paymentDetailService.findPaymentDetailBySql(paymentDetailHelper));
    }

//    /**
//     * 按类别查询收支明细记录
//     *
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/searchPaymentDetail")
//    public String searchPaymentDetail(String balance, HttpServletResponse response) {
//
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            out.write(JSON_STR + "(" + JSON.toJSONString(paymentDetailService.search(balance)) + ")");
//            out.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//
//            out.close();
//        }
//        return null;
//    }
//
//    /**
//     * 按日期查询收支明细记录
//     *
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/searchPaymentDetailByTime")
//    public String searchPaymentDetailByTime(@RequestParam("start_time") String begin_time, @RequestParam("end_time") String end_time, HttpServletResponse response) {
//
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            out.write(JSON_STR + "(" + JSON.toJSONString(paymentDetailService.searchByTime(begin_time, end_time)) + ")");
//            out.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            out.close();
//        }
//        return null;
//    }
//
//    /**
//     * 按收支类别日期查询收支明细记录
//     *
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/searchByAll", method = RequestMethod.POST, params = "json")
//    public String searchByAll(@RequestBody Map<String, Object> info) {
//        System.out.println("success");
//        List<PaymentDetail> list = new ArrayList<PaymentDetail>();
//        String s1 = "", s2 = "", s3 = "";
//        System.out.println(info.toString());
//
//        s1 = (String) info.get("balance");
//        s2 = (String) info.get("begin_time");
//        s3 = (String) info.get("end_time");
//        // list = paymentDetailService.searchByAll(s1,s2,s3);
//        return JSON.toJSONString(paymentDetailService.searchByAll(s1, s2, s3));
//    }
}
