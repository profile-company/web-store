package com.example.webstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.List;

public class Context {

    private Dictionary data;

    private StrategyFilter strategy;

    public void setStrategy(StrategyFilter strategy) {
        this.strategy = strategy;
    }

    public void setData(Dictionary data) {
        this.data = data;
    }

    public List<Integer> filter() {
         return strategy.execute(data);
    }
}
