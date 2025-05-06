package s28600_MP4.Atrybut;

public class CreditCard {
    private float debt = 0.0f;

    public CreditCard(float debt) {
        setDebt(debt);
    }

    public float getDebt() {
        return debt;
    }

    public void setDebt(float debt) {
        if (debt < this.debt)
            throw new IllegalArgumentException("New debt cannot be less than before");
        if (debt > 10000)
            throw new IllegalArgumentException("Credit card limit is 10k");
        this.debt = debt;
    }
}
