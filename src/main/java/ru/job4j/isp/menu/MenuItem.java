package ru.job4j.isp.menu;

import java.util.List;

public interface MenuItem {
    String getParentName();

    List<MenuItem> getChildren();

    ActionDelegate getActionDelegate();
}
