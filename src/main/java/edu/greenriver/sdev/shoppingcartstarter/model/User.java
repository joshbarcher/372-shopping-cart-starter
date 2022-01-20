package edu.greenriver.sdev.shoppingcartstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    private UUID id;
    private String username;
    private LocalDateTime created;

    private Cart cart;

    public User(String username)
    {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (!obj.getClass().equals(this.getClass())) return false;

        return ((User)obj).id.equals(id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }
}
