package ru.job4j.isp.menu;

public class ItemsPrinter implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        var iteratorMenu = menu.iterator();
        StringBuilder out = new StringBuilder();
        while (iteratorMenu.hasNext()) {
            var menuItem = iteratorMenu.next();
            String space = "";
            String menuNumber = menuItem.getNumber();
            int countOfDot = -1;
            for (int i = 0; i < menuNumber.length(); i++) {
                if ('.' == menuNumber.charAt(i)) {
                    countOfDot++;
                }
            }
            int level = countOfDot;
            if (level != 0) {
                space = "-".repeat(level * 2) + " ";
            }
            out.append(String.format("%s%s %s%n",
                    space,
                    menuItem.getName(),
                    menuNumber));
        }
        System.out.print(out);
    }
}
