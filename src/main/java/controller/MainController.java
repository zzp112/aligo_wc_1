package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/4/2 0002.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/common/welcome")
    public void toWelcome(){

    }
}
