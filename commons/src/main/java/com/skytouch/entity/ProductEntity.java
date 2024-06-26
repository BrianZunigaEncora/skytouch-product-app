package com.skytouch.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "store_name")
    private String storeName;
}
