package com.vaadin.flow.component.grid;

import com.vaadin.flow.component.ComponentEvent;

public class CustomGrid<T> extends Grid<T> {

    public CustomGrid(Class<T> samplePersonClass, boolean b) {
        super(samplePersonClass, b);
        setSelectionMode(SelectionMode.MULTI);
        CustomSelectionModel<T> model = new CustomSelectionModel<>(this);
        setSelectionModel(model, SelectionMode.MULTI);
    }

    @Override
    protected void fireEvent(ComponentEvent<?> componentEvent) {
        super.fireEvent(componentEvent);
    }
}
