package ru.vasyunin.store;

import javax.persistence.*;

@Entity
@Table(name = "order_information")
public class OrderInformation {
    @Id
    private Long order_id;
    private long price;

    public Long getId() {
        return order_id;
    }

    public void setId(Long id) {
        this.order_id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public OrderInformation() {
    }

    @Override
    public String toString() {
        return "price=" + price;
    }
}
