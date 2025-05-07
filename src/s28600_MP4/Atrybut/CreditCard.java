package s28600_MP4.Atrybut;

public class CreditCard {
    private double debt = 0.0f;

    public CreditCard(double debt) {
        setDebt(debt);
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        if (debt < this.debt)
            throw new IllegalArgumentException("New debt cannot be less than before");
        if (debt > 10000)
            throw new IllegalArgumentException("Credit card limit is 10k");
        this.debt = debt;
    }
}
