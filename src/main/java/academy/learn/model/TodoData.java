package academy.learn.model;


import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {

    private static Integer idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    public TodoData() {
        addItem(new TodoItem("first","first details", LocalDate.now()));
        addItem(new TodoItem("second","second details", LocalDate.now()));
        addItem(new TodoItem("third","third details", LocalDate.now()));
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(Integer id) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        while (itemListIterator.hasNext()) {
            TodoItem todoItem = itemListIterator.next();

            if (todoItem.getId().equals(id)) {
                itemListIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(Integer id) {
        for (TodoItem item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()) {
            TodoItem todoItem = itemListIterator.next();
            if (todoItem.equals(toUpdate)) {
                itemListIterator.set(toUpdate);
                break;
            }
        }
    }
}
