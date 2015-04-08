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
    public void stationList(){
        //测试路径/stuCou/listStuCou
    }

    @ResponseBody
    @RequestMapping("/stuCou/loadStuCou")
    public String loadAllStuCou(){
        //测试路径/stuCou/loadStuCou
        List<StuCou> stuCous=null;
        stuCous=stuCouService.loadStuCus();
        System.out.println(JSON.toJSONString(stuCous));
        return JSON.toJSONString(stuCous);
    }
    @ResponseBody
    @RequestMapping("/stuCou/loadStuCouByStuId")
    public String loadStuCouByStuId(int id){
        //测试路径/stuCou/loadStuCouByStuId?id=x
        List<StuCou> stuCous=null;
        stuCous=stuCouService.loadStuCouByStuId(id);
        System.out.println(JSON.toJSONString(stuCous));
        return JSON.toJSONString(stuCous);
    }
    @ResponseBody
    @RequestMapping("/stuCou/loadStuCouByCouId")
    public String loadStuCouByCouId(int id){
        //测试路径/stuCou/loadStuCouByCouId?id=x
        List<StuCou> stuCous=null;
        stuCous=stuCouService.loadStuCouByCouId(id);
        System.out.println(JSON.toJSONString(stuCous));
        return JSON.toJSONString(stuCous);
    }
    @ResponseBody
    @RequestMapping("/stuCou/loadStuCouByStuCouId")
    public String loadStuCouByStuCouId(int id){
        //测试路径/stuCou/loadStuCouByStuCouId?id=x
        StuCou stuCou=null;
        stuCou=stuCouService.loadStuCouByStuCouId(id);
        System.out.println(JSON.toJSONString(stuCou));
        return JSON.toJSONString(stuCou);
    }
    @ResponseBody
    @RequestMapping("/stuCou/deleteStuCou")
    public String deleteStuCou(int id){
        //测试路径/stuCou/deleteStuCou?id=x
        stuCouService.deleteStuCou(id);
        return null;
    }
    @ResponseBody
    @RequestMapping("/stuCou/updateStuCou")
    public String updateStuCou(StuCou stuCou){
        List<StuCou> stuCous=null;
        stuCous=stuCouService.loadStuCus();
        System.out.println(JSON.toJSONString(stuCous));
        return JSON.toJSONString(stuCous);
    }
}
