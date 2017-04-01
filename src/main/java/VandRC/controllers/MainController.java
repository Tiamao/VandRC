package VandRC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @RequestMapping(value = "/")
  @ResponseBody
  public String index() {
    return "Proudly handcrafted by " +
        "<a href='http://VandRC.com/en'>VandRC</a> :)";
  }

}
