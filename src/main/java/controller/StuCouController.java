package controller;

import com.alibaba.fastjson.JSON;
import entities.StuCou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.IStuCouService;
import entities.StuCouSearchHelper;

import java.util.List;

/**
 * Created by Administrator on 2015/4/4.
 */
@Controller
public class StuCouController {
    @Autowired
    private IStuCouService stuCouService;

    public static Integer id;

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

        return JSON.toJSONString(stuCous);
    }
    @ResponseBody
    @RequestMapping("/stuCou/loadStuCouByStuId")
    public String loadStuCouByStuId(int id){
        //测试路径/stuCou/loadStuCouByStuId?id=x
        List<StuCou> stuCous=null;

        stuCous=stuCouService.loadStuCouByStuId(id);
        return JSON.toJSONString(stuCous);
    }
    @ResponseBody
    @RequestMapping("/stuCou/loadStuCouByCouId")
    public String loadStuCouByCouId(int id){
        //测试路径/stuCou/loadStuCouByCouId?id=x
        List<StuCou> stuCous=null;

        stuCous=stuCouService.loadStuCouByCouId(id);

        return JSON.toJSONString(stuCous);
    }
    @ResponseBody
    @RequestMapping("/stuCou/loadStuCouByStuCouId")
    public String loadStuCouByStuCouId(int id){
        //测试路径/stuCou/loadStuCouByStuCouId?id=x
        StuCou stuCou=null;

        stuCou=stuCouService.loadStuCouByStuCouId(id);

        return JSON.toJSONString(stuCou);
    }
    @ResponseBody
    @RequestMapping("/stuCou/deleteStuCou")
    public String deleteStuCou(int id){
        //测试路径/stuCou/deleteStuCou?id=x
        stuCouService.deleteStuCou(id);
        return null;
    }

    @RequestMapping("/stuCou/toUpdateStuCou")
    public String toUpdateStuCou(Integer id){
        this.id=id;
        return "/stuCou/updateStuCou";
    }

    @ResponseBody
    @RequestMapping("/stuCou/preUpdateStuCou")
    public String preUpdateStuCou(){

        return JSON.toJSONString(stuCouService.loadStuCouByStuCouId(id));
    }

    @ResponseBody
    @RequestMapping("/stuCou/updateStuCou")
    public String updateStuCou(StuCou stuCou){
        List<StuCou> stuCous=null;

        stuCouService.updateStuCou(stuCou);

        return JSON.toJSONString(stuCous);
    }




    @RequestMapping("/stuCou/inputStuCou")
    public String inputStuCou(){
        return "/stuCou/inputStuCou";
    }

    @RequestMapping("/stuCou/addStuCou")
    public String addStuCou(StuCou stuCou){
        stuCouService.addStuCou(stuCou);
        return "/stuCou/listStuCou";
    }


    /**
     * 根据日期范围获取学生上课记录
     * @Param beginDate 起始日期
     * @Param endDate 结束日期
     * */
    @ResponseBody
    @RequestMapping("/stuCou/loadByDate")
    public String loadByDateScope (String beginDate,String endDate){
        //测试路径/stuCou/loadByDate?beginDate=2015-04-20&endDate=2015-04-22
        return JSON.toJSONString(stuCouService.loadStuCouByDateScope(beginDate, endDate));
    }

    @ResponseBody
    @RequestMapping("/stuCou/loadStuCouByDate")
    public String loadByDate(String searchDate){
        //测试路径/stuCou/loadStuCouByDate?searchDate=2014-04
        return JSON.toJSONString(stuCouService.loadStuCouByDate(searchDate));
    }

    @ResponseBody
    @RequestMapping("/stuCou/findStuCou")
    public String findStuCou(StuCouSearchHelper stuCouSearchHelper){
        //测试路径/stuCou/findStuCou
        return JSON.toJSONString(stuCouService.findByParam(stuCouSearchHelper));
    }
}
