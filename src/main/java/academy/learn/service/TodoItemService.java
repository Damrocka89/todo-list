package academy.learn.service;

import academy.learn.model.TodoData;
import academy.learn.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem todoItem);
    void removeItem(Integer id);
    TodoItem getItem(Integer id);
    void updateItem(TodoItem todoItem);
    TodoData getData();

}
