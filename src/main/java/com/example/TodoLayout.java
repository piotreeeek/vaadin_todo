package com.example;

import com.vaadin.data.Binder;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Piotrek on 2017-05-10.
 */
public class TodoLayout extends HorizontalLayout{
    private final CheckBox done;
    private final TextField text;

    public TodoLayout(Todo todo) {
        setSpacing(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        done = new CheckBox();
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setWidth("100%");

        Binder <Todo> binder = new Binder<>();
        binder.bind(done, Todo::isDone, Todo::setDone);
        binder.bind(text, Todo::getText, Todo::setText);
        binder.setBean(todo);
        addComponents(done, text);
        setExpandRatio(text, 1);
    }
}
