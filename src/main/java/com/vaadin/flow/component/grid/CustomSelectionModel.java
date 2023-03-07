package com.vaadin.flow.component.grid;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.hierarchy.HierarchicalDataProvider;
import com.vaadin.flow.data.selection.SelectionEvent;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    void clientSelectAll() {
        if (!isSelectAllCheckboxVisible()) {
            // ignore event if the checkBox was meant to be hidden
            return;
        }
        /*Stream<T> allItemsStream;
        DataProvider<T, ?> dataProvider = getGrid().getDataCommunicator()
                .getDataProvider();
        if (dataProvider instanceof HierarchicalDataProvider) {
            allItemsStream = fetchAllHierarchical(
                    (HierarchicalDataProvider<T, ?>) dataProvider);
        } else {
            allItemsStream = dataProvider.fetch(getGrid().getDataCommunicator()
                    .buildQuery(0, Integer.MAX_VALUE));
        }
        */

        doCustomUpdateSelectAll(true, true);
        //selectionColumn.setSelectAllCheckboxState(true);
        //selectionColumn.setSelectAllCheckboxIndeterminateState(false);
    }

    private void doCustomUpdateSelectAll(boolean selectionOn, boolean isUserOriginated) {
        getGrid().isInActiveRange(null);

    }
}
