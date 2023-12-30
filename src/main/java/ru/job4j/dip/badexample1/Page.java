package ru.job4j.dip.badexample1;

public class Page {
    private final Long id;
    private String contains;

    public Page(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }
}
