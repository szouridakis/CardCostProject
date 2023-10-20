package com.project.api.bin.data;

public class Data {
    private Card card;

    private Country country;

    private Bank bank;

    public Data(){}

    public Data(Card card, Country country, Bank bank) {
        super();
        this.card = card;
        this.country = country;
        this.bank = bank;
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
