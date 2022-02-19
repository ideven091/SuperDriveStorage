package com.example.cloudstorage_project1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taco {

    private String name;

    private List<Ingredient> ingredients;
}
