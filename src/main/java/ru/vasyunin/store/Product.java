package ru.vasyunin.store;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product_name;
    private Long price;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @ManyToMany
    @JoinTable(name = "orders", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return product_name;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Product() {
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }

    public String toStringWithClients(){
        StringBuilder sb = new StringBuilder("Product");
        sb.append(System.lineSeparator())
                .append("\tID: ")
                .append(id)
                .append(System.lineSeparator())
                .append("\tProduct_name: ")
                .append(product_name)
                .append(System.lineSeparator())
                .append("\t\tClients: ")
                .append(clients);
        return sb.toString();
    }
}
