package academy.learn.service;

import academy.learn.model.TodoData;
import academy.learn.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    public static final TodoData todoData = new TodoData();


    @Override
    public void addItem(TodoItem todoItem) {
        todoData.addItem(todoItem);
    }

    @Override
    public void removeItem(Integer id) {
        todoData.removeItem(id);
    }

    @Override
    public TodoItem getItem(Integer id) {
        return todoData.getItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        todoData.updateItem(todoItem);
    }

    @Override
    public TodoData getData() {
        return todoData;
    }
}
