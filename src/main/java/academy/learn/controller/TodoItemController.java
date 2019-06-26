package academy.learn.controller;

import academy.learn.model.TodoData;
import academy.learn.model.TodoItem;
import academy.learn.service.TodoItemService;
import academy.learn.util.AttributeNames;
import academy.learn.util.Mappings;
import academy.learn.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    //http://localhost:8080/todolist/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    //http://localhost:8080/todolist/addItem
    @GetMapping(Mappings.ADD_ITEMS)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") Integer id, Model model) {
        log.info("editing id = {}", id);
        TodoItem todoItem=todoItemService.getItem(id);

        if (todoItem==null){
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEMS)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form ={}", todoItem);

        if (todoItem.getId()==null){
            todoItemService.addItem(todoItem);
        }else{
            todoItemService.updateItem(todoItem);
        }

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEMS)
    public String deleteItem(@RequestParam Integer id){
        log.info("todoItem removeItem form = {}",id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam Integer id, Model model){
        log.info("todoItem view form = {}",id);
        TodoItem todoItem=todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.VIEW_ITEM;
    }

}
