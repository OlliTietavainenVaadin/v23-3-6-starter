package com.example.application.views.about;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

    public AboutView() {
        setSpacing(false);

        TextField textField = new TextField("'U' shortcut listener");
        add(textField);
        Shortcuts.addShortcutListener(this, e -> Notification.show("TextField shortcut listener"),
                        Key.KEY_U).listenOn(textField);

        PasswordField pwField = new PasswordField("No shortcut listener");
        add(pwField);

        Shortcuts.addShortcutListener(this, e -> Notification.show("Entire view shortcut listener"),
                Key.KEY_U);

    }

}
