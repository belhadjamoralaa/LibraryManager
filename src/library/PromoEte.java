package library;

public class PromoEte implements PromoStrategy {
    public double calculerPromo(double prix) {
        return prix * 0.8; 
    }
}
