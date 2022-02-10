package ru.job4j.lsp;

public class Animal {
    public void voice() {
        if (this.getClass() == Animal.class) {
            System.out.println("Woof, woof");
        } else {
            System.out.println("Mur Mur");
        }

    }
}
