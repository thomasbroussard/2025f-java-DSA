package fr.epita.bank.datamodel;

/**
 * it has to be created in order to store the information about what was bought from what account
 * <ul>
 *     <li><code>StockOrder order = new StockOrder();</code></li>
 *     <li><code>order.setAccount(investmentAccount);</li>
 *     <li><code>order.setStock(boughtStock);</li>
 *     <li><code>//...</code></li>
 *  *
 * </ul>
 */
public class StockOrder {

    private Integer id;
    private Integer quantity;
    private Double price;
    private Double commission;

    private Stock stock;
    private InvestmentAccount investmentAccount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public InvestmentAccount getInvestmentAccount() {
        return investmentAccount;
    }

    public void setInvestmentAccount(InvestmentAccount investmentAccount) {
        this.investmentAccount = investmentAccount;
    }
}
