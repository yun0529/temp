package com.example.demo.src.temp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TempRequest {
    private String temp;

    public TempRequest(){}
}
