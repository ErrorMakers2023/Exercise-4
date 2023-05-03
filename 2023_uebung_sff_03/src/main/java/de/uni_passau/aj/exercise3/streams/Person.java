package de.uni_passau.aj.exercise3.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
@AllArgsConstructor
public class Person {
    String name;
    int age;
    String nationality;
}
