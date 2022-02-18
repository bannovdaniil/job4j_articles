package ru.job4j.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Item implements MenuItem {
    private String name;
    private List<MenuItem> children;
    private ActionDelegate actionDelegate;

    public Item(String name, String children, ActionDelegate actionDelegate) {
        this.name = name;
        this.children = new ArrayList<>();
        this.children.add(new Item(children));
        this.actionDelegate = actionDelegate;
    }

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
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
