package Ex3;

import java.io.Serializable;

// Représente une vente dans le système analytique
// (saleId, product, region, amount, date)
public class Vente implements Serializable {

    private int saleId;
    private String product;
    private String region;
    private double amount;
    private String date; // pour rester simple : date sous forme de String

    public Vente(int saleId, String product, String region, double amount, String date) {
        this.saleId = saleId;
        this.product = product;
        this.region = region;
        this.amount = amount;
        this.date = date;
    }

    public Vente() {
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

