package com.project.api.cardcost;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "card_cost_request")
public class CardCost {
    @Id
    @SequenceGenerator(
            name="card_cost_requests_sequence",
            sequenceName = "card_cost_requests_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "card_cost_requests_sequence"
    )
    private Long id;
    @CreationTimestamp
    private Date timestamp;
    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[0-9]{8,19}$",message = "PAN should be between 8 and 19 digits")
    private String card_number;

    private String status;

    public CardCost() {}
    public CardCost(String card_number) {
        this.card_number = card_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }
}
