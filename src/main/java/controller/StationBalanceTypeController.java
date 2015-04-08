package controller;

import AuthorityException.DataException;
import com.alibaba.fastjson.JSON;
import entities.StationBalanceDetailType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.impl.StationBalanceTypeService;

/**
 * Created by 张超红 on 2015-04-03.
 * 小站收支明细类型的控制层
 */
@Controller
public class StationBalanceTypeController {
    @Autowired
    StationBalanceTypeService stationBalanceTypeService;

    @Autowired
    StationBalanceDetailType stationBalanceDetailType;


    /**
     * 跳转到显示所有小站收支明细类别的界面
     * @return
     */
    @RequestMapping(value = "toListBalanceTypePage")
    public String toListBalanceTypePage(){
        return "";
    }

    /**
     * 跳转到添加小站收支明细类别界面
     * @return
     */
    @RequestMapping(value = "toInputBalanceTypePage")
    public String toInputBalanceTypePage(){
        return "";
    }
    /**
     * 加载小站收支明细所有的类型并返回一串json数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "toListBalanceType")
    public String toListBalanceType(){
        try {
            return JSON.toJSONString(stationBalanceTypeService.listAllStationBalanceType());
        }catch (DataException ex){
            return ex.getMessage();
        }
    }
    /**
     * 返回收支明细类型的json数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toShowTypeInBox")
    public String selectStationBalanceType(){
        //正确加载返回json数据，否则返回错误信息
        String typeJson;
        try {
            typeJson= JSON.toJSONString(stationBalanceTypeService.listAllStationBalanceType());
            return typeJson;
        }catch (DataException ex)
        {
            return ex.getMessage();
        }
    }

    /**
     * 添加一个小站收支明细类型
     * @return
     */
    @RequestMapping(value = "/toAddStationBalanceType")
    public String CreateStationBalanceType(@Param("type_name") String type_name, Model model){
        try {
            stationBalanceDetailType.setPaymentTypeName(type_name);
            stationBalanceTypeService.CreateStationBalanceType(stationBalanceDetailType);
            //成功的话，重定向到主页面
            return "redirect:/toListBalanceTypePage";
        }catch (DataException dataException)
        {
            //失败的话重定向到主页面并打印错误信息
            String error=dataException.getMessage();
            model.addAttribute("error",error);
            return "redirect:/toListBalanceTypePage";
        }
    }

    /**
     * 删除小站收支明细
     * @param type_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/toDeleteStationBalanceType")
    public String DeleteStationBalanceType(@RequestParam("type_id") Integer type_id,Model model){
        //删除成功，重定向到list界面，删除失败返回到添加界面并打印出错误信息
        try {
            stationBalanceTypeService.RemoveStationBalanceType(type_id);
            return "redirect:/toListBalanceTypePage";
        }catch (DataException ex){
            model.addAttribute("error",ex.getMessage());
            return "redirect:/toInputBalanceTypePage";
        }
    }

    /**
     * 修改小站收支明细中的类别
     * @param type_id
     * @param type_name
     * @param model
     * @return
     */
    @RequestMapping(value = "/toUpdateStationBalanceType")
    public String toUpdateStationBalanceType(@Param("type_id") Integer type_id,@Param("type_name") String type_name,Model model){
        try {
            stationBalanceDetailType.setPaymentTypeId(type_id);
            stationBalanceDetailType.setPaymentTypeName(type_name);
            stationBalanceTypeService.UpdateStationBalanceType(stationBalanceDetailType);
            return "redirect:/toListBalanceTypePage";
        }catch (DataException ex){
            model.addAttribute("error",ex.getMessage());
            return "redirect:/toInputBalanceTypePage";
        }
    }

}
