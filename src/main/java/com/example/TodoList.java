package com.example;

import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Piotrek on 2017-05-10.
 */

@Component
public class TodoList extends VerticalLayout{
    @Autowired
    TodoRepository repository;
    private List<Todo> todos;

    @PostConstruct
    void init(){
        setSpacing(true);
        update();
    }

    private void update() {
        setTodos(repository.findAll());
    }

    private void setTodos(List<Todo> todos) {
        this.todos=todos;
        removeAllComponents();

        todos.forEach(todo -> {
            addComponent(new TodoLayout(todo));
        });
    }

    public void add(Todo todo) {
        repository.save(todo);
        update();
    }

    public void deleteCompleted() {
        repository.deleteInBatch(todos.stream().filter(Todo::isDone).collect(Collectors.toList()));

        update();
    }
}
