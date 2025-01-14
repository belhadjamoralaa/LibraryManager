package library;

interface DiscountStrategy {
    double calculateDiscount(double originalPrice);
}

class DirectDiscount implements DiscountStrategy {
    private double percentage;
    
    DirectDiscount(double percentage) {
        this.percentage = percentage;
    }
    
    public double calculateDiscount(double originalPrice) {
        return originalPrice * (1 - percentage);
    }
}

class CodeDiscount implements DiscountStrategy {
    private String code;
    
    CodeDiscount(String code) {
        this.code = code;
    }
    
    public double calculateDiscount(double originalPrice) {
        if(code.equals("CODE20")) {
            return originalPrice * 0.8;
        }
        return originalPrice;
    }
}

