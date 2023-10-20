package com.project.api.clearingcost;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="clearing_cost")
public class ClearingCost {


    @Id
    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[A-Za-z]{2,6}$",message = "Country should be a string between 2 and 6 characters")
    private String country;
    private float cost;

    public ClearingCost(){
    }

    public ClearingCost(String country, float cost){
        this.country =country;
        this.cost = cost;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

}
