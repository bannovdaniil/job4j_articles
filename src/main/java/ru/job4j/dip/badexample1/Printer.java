package ru.job4j.dip.badexample1;

import java.util.Map;

/**
 * Класс, нарушает принцип DIP, т.к. не зависит от абстракций, для исправления, надо вынести
 * репозиторий во внешнюю реализацию, а действия со страницами вынести в отдельный интерфейс и
 * добавить к нему реализацию.
 */
public class Printer {
    private Map<Long, Page> pages;

    public Page printPage(Long pageId) {
        return pages.get(pageId);
    }

    public void addPage(Long pageId, Page page) {
        pages.put(pageId, page);
    }

    public void removePage(Long pageId) {
        pages.remove(pageId);
    }
}
