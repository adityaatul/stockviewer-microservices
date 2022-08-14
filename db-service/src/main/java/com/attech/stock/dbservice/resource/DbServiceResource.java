package com.attech.stock.dbservice.resource;

import com.attech.stock.dbservice.model.Quote;
import com.attech.stock.dbservice.model.Quotes;
import com.attech.stock.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    @Autowired
    private QuotesRepository quotesRepository;


    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username) {
        return getQuoteByUserName(username);
    }

    private List<String> getQuoteByUserName(String username) {
        return quotesRepository.findByUserName(username)
                .stream()
                .map(quote -> quote.getQuote()).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes) {
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUserName(), quote))
                .forEach(quote -> quotesRepository.save(quote));
        return getQuoteByUserName(quotes.getUserName());
    }

    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username")final String username){
        List<Quote> quotes = quotesRepository.findByUserName(username);
        quotesRepository.deleteAll(quotes);
        return getQuoteByUserName(username);
    }
}
