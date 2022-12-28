package com.example.spring.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "productname")
    private String productName;
    @Column(name = "cost")
    private Double cost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(productName, that.productName) && Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return 32;
    }

    @Override
    public String toString() {
        return "ProductEntity{" + "id=" + id + ", productName='" + productName + '\'' + ", cost=" + cost + '}';
    }
}
