package academy.learn.controller;

import academy.learn.model.TodoData;
import academy.learn.util.Mappings;
import academy.learn.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    @ModelAttribute
    public TodoData todoData(){
        return new TodoData();
    }

    //http://localhost:8080/todolist/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }


}
