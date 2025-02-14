package org.java5.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Integer id;

    private String name;

    private double price;

    @Builder.Default
    private int qty = 1;
}

