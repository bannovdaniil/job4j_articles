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
        long dayBetween = createDate.getTimeInMillis() - checkDate.getTimeInMillis();
        double allTime = createDate.getTimeInMillis() - expiryDate.getTimeInMillis();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Food food = (Food) o;

        if (Double.compare(food.price, price) != 0) {
            return false;
        }
        if (Double.compare(food.discount, discount) != 0) {
            return false;
        }
        if (name != null ? !name.equals(food.name) : food.name != null) {
            return false;
        }
        if (createDate != null ? !createDate.equals(food.createDate) : food.createDate != null) {
            return false;
        }
        return expiryDate != null ? expiryDate.equals(food.expiryDate) : food.expiryDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
