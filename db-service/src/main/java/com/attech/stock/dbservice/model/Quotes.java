package com.attech.stock.dbservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Quotes {

    private String userName;
    private List<String> quotes;

    public Quotes(String userName, List<String> quotes) {
        this.userName = userName;
        this.quotes = quotes;
    }

    public Quotes() {
    }
}
