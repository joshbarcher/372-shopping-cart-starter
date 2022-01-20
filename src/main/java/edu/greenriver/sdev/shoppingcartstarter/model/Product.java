package edu.greenriver.sdev.shoppingcartstarter.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    private String name;
    private double price;
    private String description;
    private int quantity;

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (!obj.getClass().equals(this.getClass())) return false;

        return ((Product)obj).name.equals(name);
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }
}
