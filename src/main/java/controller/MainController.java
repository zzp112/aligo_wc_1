package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/4/2 0002.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/common/mainFrame")
    public void toWelcome(){}

    /**
     * 默认页面
     * @return
     */
    @RequestMapping(value = "/toAttention")
    public String toAttention(){
        return "demo/attention";
    }

    @RequestMapping(value = "/error")
    public String toError(){
        return "error";
    }
}
