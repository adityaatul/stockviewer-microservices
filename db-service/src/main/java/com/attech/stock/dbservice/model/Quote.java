package com.attech.stock.dbservice.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "quotes", catalog = "stock_db_service")
@Getter
@Setter
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private  String userName;

    @Column(name = "quote")
    private String quote;

    public Quote(String userName, String quote) {
        this.userName = userName;
        this.quote = quote;
    }

    public Quote() {
    }
}
