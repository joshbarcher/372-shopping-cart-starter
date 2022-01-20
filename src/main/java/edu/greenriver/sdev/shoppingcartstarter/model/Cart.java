package edu.greenriver.sdev.shoppingcartstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart
{
    private UUID id;
    private List<Product> listItems = new ArrayList<>();

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (!obj.getClass().equals(this.getClass())) return false;

        return ((Cart)obj).id.equals(id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    public Product getProductByName(Product product)
    {
        return listItems
            .stream()
            .filter(prod -> prod.getName().equals(product.getName()))
            .findFirst()
            .orElse(null);
    }

    public void addProduct(Product product)
    {
        Product match = getProductByName(product);
        if (match != null)
        {
            int quantity = match.getQuantity();
            quantity++;
            match.setQuantity(quantity);
        }
        else
        {
            product.setQuantity(1);
            listItems.add(product);
        }
    }

    public void removeProduct(Product product)
    {
        Product match = getProductByName(product);
        if (match != null)
        {
            int quantity = match.getQuantity();
            quantity--;

            if (quantity == 0)
            {
                listItems.remove(product);
            }
            else
            {
                match.setQuantity(quantity);
            }
        }
        else
        {
            throw new IllegalStateException("Cart does not contain product");
        }
    }
}
