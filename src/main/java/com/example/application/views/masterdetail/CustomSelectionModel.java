package com.example.application.views.masterdetail;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.grid.AbstractGridMultiSelectionModel;
import com.vaadin.flow.component.grid.CustomGrid;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.selection.SelectionEvent;

public class CustomSelectionModel<T> extends AbstractGridMultiSelectionModel<T> {
    public CustomSelectionModel(CustomGrid<T> grid) {
        super(grid);
        setSelectAllCheckboxVisibility(SelectAllCheckboxVisibility.VISIBLE);
    }

    @Override
    protected void fireSelectionEvent(SelectionEvent<Grid<T>, T> selectionEvent) {
        CustomGrid<T> grid = (CustomGrid) getGrid();
        grid.fireEvent((ComponentEvent<Grid<T>>) selectionEvent);
    }

    @Override
    protected void clientSelectAll() {
        if (!isSelectAllCheckboxVisible()) {
            // ignore event if the checkBox was meant to be hidden
            return;
        }

        doCustomUpdateSelectAll(true, true);
        getSelectionColumn().setSelectAllCheckboxState(true);
        getSelectionColumn().setSelectAllCheckboxIndeterminateState(false);
    }

    @Override
    protected void clientDeselectAll() {
        if (!isSelectAllCheckboxVisible()) {
            return;
        }
        doCustomUpdateSelectAll(false, true);
        getSelectionColumn().setSelectAllCheckboxState(true);
        getSelectionColumn().setSelectAllCheckboxIndeterminateState(false);
    }

    private void doCustomUpdateSelectAll(boolean selectionOn, boolean isUserOriginated) {
        CustomMultiSelectionEvent<Grid<T>, T> event = new CustomMultiSelectionEvent<>(getGrid(),
                getGrid().asMultiSelect(), null, isUserOriginated);
        event.setSelectionStatus(selectionOn ? SelectionStatus.LAZY_SELECT_ALL
                : SelectionStatus.EMPTY);
        fireSelectionEvent(event);
        // TODO: do something about client selection
    }
}
