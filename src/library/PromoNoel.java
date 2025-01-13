package library;

public class PromoNoel implements PromoStrategy {
    public double calculerPromo(double prix) {
        return prix * 0.7; 
    }
}
