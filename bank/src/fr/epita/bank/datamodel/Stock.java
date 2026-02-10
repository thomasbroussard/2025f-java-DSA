package fr.epita.bank.datamodel;

public class Stock {
    private String ticker;
    private Double currentPrice;


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        if (ticker != null) {
            this.ticker = ticker;
        }

    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
