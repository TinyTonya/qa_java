package com.example;

import java.util.List;

public interface FelineInterface {
    int getKittens();
    String getFamily();
    List<String> getFood(String type) throws Exception;
}
