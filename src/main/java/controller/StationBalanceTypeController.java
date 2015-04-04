package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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


    /**
     * 返回收支明细类型的json数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "")
    public String selectStationBalanceType(){
        String typeJson;
        typeJson= JSON.toJSONString(stationBalanceTypeService.listAllStationBalanceType());
        return typeJson;
    }
}
