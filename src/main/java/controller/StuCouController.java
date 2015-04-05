package controller;

import com.alibaba.fastjson.JSON;
import entities.StuCou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.IStuCouService;

import java.util.List;

/**
 * Created by Administrator on 2015/4/4.
 */
@Controller
public class StuCouController {
    @Autowired
    private IStuCouService stuCouService;

    /**
     * 小站列表页面
     */
    @RequestMapping("/stuCou/listStuCou")
    public void stationList(){}

    @ResponseBody
    @RequestMapping("/stuCou/loadStuCou")
    public String loadAllStuCou(){
        List<StuCou> stuCous=null;
        stuCous=stuCouService.loadStuCus();
        return JSON.toJSONString(stuCous);
    }
}
