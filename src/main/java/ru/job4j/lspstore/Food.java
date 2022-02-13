package ru.job4j.lspstore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Food {
    private String name;
    private Calendar createDate;
    private Calendar expiryDate;
    private double price;
    private double discount;

    public Food(String name, Calendar createDate, Calendar expiryDate, double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.expiryDate.setTimeZone(TimeZone.getTimeZone("GMT-7"));
        this.createDate.setTimeZone(TimeZone.getTimeZone("GMT-7"));
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPercent(Calendar checkDate) {
        long dayBetween = expiryDate.getTimeInMillis() - checkDate.getTimeInMillis();
        double allTime = expiryDate.getTimeInMillis() - createDate.getTimeInMillis();
        if (allTime == 0) {
            allTime = 0.0001D;
        }
        return dayBetween * 100.0 / allTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat dfr = new SimpleDateFormat("yyyy-MM-dd");
        return "Food{name='" + name + '\''
                + ", expiryDate=" + dfr.format(expiryDate.getTime())
                + ", price=" + price
                + ", discount=" + discount + '}';
    }
}
