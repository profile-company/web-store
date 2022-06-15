package com.example.webstore.services;

import java.util.Dictionary;
import java.util.List;

public interface StrategyFilter {

    public List<Integer> execute(Dictionary data);
}
