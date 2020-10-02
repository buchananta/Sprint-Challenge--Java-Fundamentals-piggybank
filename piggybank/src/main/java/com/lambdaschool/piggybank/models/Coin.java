package com.lambdaschool.piggybank.models;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class Coin
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coinid;
    private String name;
    private String nameplural;
    private double value;
    private int quantity;

    public Coin(String name, String nameplural, double value, int quantity)
    {
        this.name = name;
        this.nameplural = nameplural;
        this.value = value;
        this.quantity = quantity;
    }
    public Coin()
    {
        // required by jpa (still don't know why)
    }

    public int getCoinid()
    {
        return coinid;
    }

    public String getName()
    {
        return name;
    }

    public String getNameplural()
    {
        return nameplural;
    }

    public double getValue()
    {
        return value;
    }

    public int getQuantity()
    {
        return quantity;
    }
    public String removeCoin(int quantity)
    {
        if (this.quantity >= quantity)
        {
            this.quantity -= quantity;
            return this.quantity + " " + "left";
        }
        return "unable to withdraw";
    }
    @Override
    public String toString()
    {
        return "Coin{" +
                "coinid=" + coinid +
                ", name='" + name + '\'' +
                ", nameplural='" + nameplural + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}


