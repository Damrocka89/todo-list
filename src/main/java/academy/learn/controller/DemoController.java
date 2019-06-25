package academy.learn.controller;

import academy.learn.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService=demoService;
    }

    //http://localhost:8080/todolist/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    //http://localhost:8080/todolist/welcome?user=Ewa
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        log.info("model = {}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMsg")
    public String welcomeMsg(){
        log.info("welcomeMsg() called");
        return demoService.getWelcomeMessage();
    }
}
