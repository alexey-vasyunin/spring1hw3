package ru.vasyunin.store;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @ManyToMany
    @JoinTable(name = "orders", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client() {
    }

    public void remove(long clientId){

    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

    public String toStringWithProducts() {
        StringBuilder sb = new StringBuilder("Client");
        sb.append(System.lineSeparator())
                .append("\tID: ")
                .append(id)
                .append(System.lineSeparator())
                .append("\tName: ")
                .append(name)
                .append(System.lineSeparator())
                .append("\t\tProducts: ")
                .append(products);
        return sb.toString();
    }
}
