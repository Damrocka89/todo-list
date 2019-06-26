package academy.learn.service;

import academy.learn.model.TodoData;
import academy.learn.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;


@Service
public class TodoItemServiceImpl implements TodoItemService {

    public static final TodoData data = new TodoData();


    @Override
    public void addItem(TodoItem todoItem) {
        data.addItem(todoItem);
    }

    @Override
    public void removeItem(Integer id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(Integer id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        data.updateItem(todoItem);
    }

    @Override
    public TodoData getData() {
        return data;
    }


}
