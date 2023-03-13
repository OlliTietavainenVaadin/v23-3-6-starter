package com.example.application.views.masterdetail;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.data.selection.MultiSelectionEvent;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CustomMultiSelectionEvent<C extends Component, T> extends MultiSelectionEvent<C, T> {

    private SelectionStatus selectionStatus = SelectionStatus.EAGER;

    public CustomMultiSelectionEvent(C listing,
                                     HasValue<AbstractField.ComponentValueChangeEvent<C, Set<T>>, Set<T>> source,
                                     Set<T> oldSelection,
                                     boolean userOriginated) {
        super(listing, source, oldSelection, userOriginated);
    }

    public void setSelectionStatus(SelectionStatus selectionStatus) {
        this.selectionStatus = selectionStatus;
    }

    @Override
    public Optional<T> getFirstSelectedItem() {
        if (selectionStatus == SelectionStatus.LAZY_SELECT_ALL) {
            throw new IllegalStateException("Unknown first selection item, lazy select all");
        } else if (selectionStatus == SelectionStatus.EMPTY){
            return Optional.empty();
        } else {
            return super.getFirstSelectedItem();
        }
    }

    @Override
    public Set<T> getAllSelectedItems() {
        if (selectionStatus == SelectionStatus.LAZY_SELECT_ALL) {
            throw new IllegalStateException("Lazy select all");
        } else if (selectionStatus == SelectionStatus.EMPTY){
            return new HashSet<T>();
        } else {
            return getAllSelectedItems();
        }
    }

    public SelectionStatus getSelectionStatus() {
        return selectionStatus;
    }

}
