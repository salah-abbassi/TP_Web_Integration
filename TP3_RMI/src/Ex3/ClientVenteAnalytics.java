package Ex3;

import java.rmi.Naming;
import java.util.List;

// Client RMI pour tester le service d'analytics de ventes
public class ClientVenteAnalytics {
    public static void main(String[] args) throws Exception {
        IRemoteVenteAnalytics analytics =
                (IRemoteVenteAnalytics) Naming.lookup("rmi://127.0.0.1:1099/ventes");

        System.out.println("Chiffre d'affaires total = " + analytics.getChiffreAffairesTotal());
        System.out.println("CA région Nord = " + analytics.getChiffreAffairesParRegion("Nord"));
        System.out.println("Produit le plus vendu = " + analytics.getProduitLePlusVendu());

        System.out.println("Ventes > 5000 :");
        List<Vente> bigSales = analytics.getVentesSuperieures(5000.0);
        for (Vente v : bigSales) {
            System.out.println(" - #" + v.getSaleId() + " " + v.getProduct()
                    + " / " + v.getRegion() + " / " + v.getAmount());
        }

        System.out.println("Toutes les ventes :");
        for (Vente v : analytics.getAllVentes()) {
            System.out.println(" - #" + v.getSaleId() + " " + v.getProduct()
                    + " / " + v.getRegion() + " / " + v.getAmount()
                    + " / " + v.getDate());
        }
    }
}

