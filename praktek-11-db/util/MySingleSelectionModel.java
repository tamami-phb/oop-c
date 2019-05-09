package util;

import javax.swing.*;

public class MySingleSelectionModel extends DefaultListSelectionModel {

    public MySingleSelectionModel() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}