package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.IStationService;

/**
 * Created by HJ on 2015/4/2 0002.
 */
@Controller
public class StationController {
    @Autowired
    private IStationService stationService;

    @RequestMapping("/station/listStation")
    public void stationList(){}

    @ResponseBody
    @RequestMapping("/station/loadAllStation")
    public String loadAllStation(){
        return JSON.toJSONString(stationService.findAllStation());
    }
}
