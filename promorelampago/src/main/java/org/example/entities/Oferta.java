package org.example.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Oferta {
    private String productName;
    private String price;
    private String offerLink;
    private long periodEndTime;
    private int sales;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOfferLink() {
        return offerLink;
    }

    public void setOfferLink(String offerLink) {
        this.offerLink = offerLink;
    }

    public long getPeriodEndTime() {
        return periodEndTime;
    }

    public void setPeriodEndTime(long periodEndTime) {
        this.periodEndTime = periodEndTime;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", offerLink='" + offerLink + '\'' +
                ", periodEndTime=" + periodEndTime +
                ", sales=" + sales +
                '}';
    }
}
