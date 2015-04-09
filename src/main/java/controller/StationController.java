package controller;

import com.alibaba.fastjson.JSON;
import entities.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import services.IStationService;
import services.impl.StationService;

import java.io.UnsupportedEncodingException;

/**
 * Created by HJ on 2015/4/2 0002.
 */
@Controller
public class StationController {
    @Autowired
    private IStationService stationService;
    /**
     * 小站列表页面
     */
    @RequestMapping("/station/listStation")
    public void stationList(){}

    /**
     * 查找所有小站
     * @return 小站信息列表json
     */
    @ResponseBody
    @RequestMapping("/station/loadAllStation")
    public String loadAllStation(){
        return JSON.toJSONString(stationService.findAllStation());
    }

    /**
     * 通过id查找小站
     * @param id 小站id
     * @return 小站信息json
     */
    @ResponseBody
    @RequestMapping("/station/findStationById")
    public String findStationById(@RequestParam(value="id") String id){
//        测试路径：/station/findStationById?id=x
        return JSON.toJSONString(stationService.findStationById(id));
    }

    /**
     * 删除小站
     * @param id 小站id
     * @return 小站
     */
    @ResponseBody
    @RequestMapping("/station/delStationById")
    public String delStationById(@RequestParam(value="id") String id){
//        测试路径：/station/delStationById?id=x
        return JSON.toJSONString(stationService.delStationById(id));
    }

    /**
     * 更新小站收入
     * @param id 小站id
     * @param totalAmount 小站收入
     * @return 是否成功
     */
    @ResponseBody
    @RequestMapping("/station/updateStationTotalById")
    public String updateStationTotalById(@RequestParam(value="id") String id, @RequestParam(value="totalAmount") String totalAmount){
//        测试路径：/station/updateStationTotalById?id=x&totalAmount=1024
        return JSON.toJSONString(stationService.updateStationTotalById(id, totalAmount));
    }

    /**
     * 更新小站所有信息
     * @param id 小站id
     * @param address 小站地址
     * @param managerId 负责人Id
     * @param accountRatio 拆账比例，格式：(0.x) 或 (0.xx)
     * @param totalAmount 总收入
     * @return 是否成功
     */
    @ResponseBody
    @RequestMapping("/station/updateStationById")
    public String updateStationById(@RequestParam(value="id") String id,@RequestParam(value="address") String address,
                                    @RequestParam(value="managerId") String managerId,@RequestParam(value="accountRatio") String accountRatio,
                                    @RequestParam(value="totalAmount") String totalAmount){
//        测试路径：/station/updateStationById?id=x&address=软件大楼&managerId=1&accountRatio=0.6&totalAmount=1000
        String addressInChinise = null;
        try {
            addressInChinise = new String(address.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException exception) {
            System.out.println(exception.getMessage());
        }

        return JSON.toJSONString(stationService.updateStationById(id,addressInChinise,managerId,accountRatio,totalAmount));
    }

    /**
     * 添加小站
     * @param address 小站地址
     * @param managerId 负责人Id
     * @param accountRatio 拆账比例，格式：(0.x) 或 (0.xx)
     * @return 是否成功
     */
//    @ResponseBody
    @RequestMapping("/station/addStation")
    public ModelAndView addStation(@RequestParam(value="address") String address,@RequestParam(value="managerId") String managerId,
                             @RequestParam(value="accountRatio") String accountRatio){
//        测试路径：/station/addStation?address=南方&managerId=1&accountRatio=0.6

        stationService.addStation(address, managerId, accountRatio);
        return  new ModelAndView("redirect:/station/listStation");
    }
}
