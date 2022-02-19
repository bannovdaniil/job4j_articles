package ru.job4j.isp.menu;

import java.util.*;

public class SimpleMenu implements Menu {
    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        boolean result = false;
        MenuItem element = new Item(parentName, childName, actionDelegate);
        if (!rootElements.contains(element)) {
            rootElements.add(element);
            result = true;
        }
        return result;
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        Optional<MenuItemInfo> info = Optional.ofNullable(null);
        for (MenuItem element : rootElements) {
            if (element.getName().equals(itemName)) {
                info = Optional.ofNullable(null);
            }
            for (var children : element.getChildren()) {
                info = Optional.ofNullable(null);
            }
        }
        return info;
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        return null;
    }

    private Optional<ItemInfo> findItem(String name) {
        Optional<ItemInfo> info = Optional.ofNullable(null);
        for (MenuItem element : rootElements) {
            if (element.getName().equals(name)) {
                info = getItemInfo(element);
            }
            for (var children : element.getChildren()) {
                info = getItemInfo(children);
            }
        }
        return info;
    }

    private Optional<ItemInfo> getItemInfo(MenuItem element) {
        String[] number = element.getName().split(".");
        return Optional.ofNullable(new ItemInfo(element, number[0]));
    }

    private static class SimpleMenuItem implements MenuItem {

        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
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

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();

            /**
             * for (var i = children.listIterator(children.size()); i.hasPrevious(); ) {
             *   stack.addFirst(i.previous());
             *   numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
             *   }
            */
            return new ItemInfo(current, lastNumber);
        }

    }

    private class ItemInfo {
        MenuItem menuItem;
        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }

}
