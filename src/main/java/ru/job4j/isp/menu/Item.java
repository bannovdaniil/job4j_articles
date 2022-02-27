package ru.job4j.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Item implements MenuItem {
    private String parentName;
    private final List<MenuItem> children;
    private ActionDelegate actionDelegate;

    public Item(String parentName, ActionDelegate actionDelegate) {
        this.parentName = parentName;
        this.actionDelegate = actionDelegate;
        this.children = new ArrayList<>();
    }

    public boolean addSubItem(String parentName, String childName, ActionDelegate actionDelegate) {
        return parentName.equals(this.parentName) && this.children.add(new Item(childName, actionDelegate));
    }

    @Override
    public String getParentName() {
        return parentName;
    }

    @Override
    public List<MenuItem> getChildren() {
        return children;
    }

    @Override
    public ActionDelegate getActionDelegate() {
        return actionDelegate;
    }
}
