package market.disscount;

/**
 * Created by Walid 19/09/2019.
 * The formula for discounting
 */
public class DiscountFormula {

    private int initialPieces;//for initial number of piece discount
    private int finalPieces;// the final piees number
    // Buy One Get One Free on ==> initialPieces = 1 and finalPiees = 2;
    //Three For The Price Of Two =>initialPieces = 2; fnalPieces = 3
    private double percent;
    private DiscountType discountType;

    public boolean isDiscountedPieces() {
        return discountType == DiscountType.DISCOUNT_PIECE;
    }


    public boolean isDiscountedPercent() {
        return discountType == DiscountType.DISCOUNT_PERCENT;
    }


    public int getInitialPieces() {
        return initialPieces;
    }

    public void setInitialPieces(int initialPieces) {
        if (finalPieces != 0 && finalPieces < initialPieces)
            throw new IllegalArgumentException("The final number must be grather than the initial ");
        this.initialPieces = initialPieces;
    }

    public int getFinalPieces() {
        return finalPieces;
    }

    public void setFinalPieces(int finalPieces) {
        if (finalPieces < initialPieces)
            throw new IllegalArgumentException("The final number must be grather than the initial ");
        this.finalPieces = finalPieces;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountFormula)) return false;

        DiscountFormula that = (DiscountFormula) o;
        if (isDiscountedPercent()) {
            if (Double.compare(that.percent, percent) != 0) return false;
        } else {
            if (initialPieces != that.initialPieces) return false;
            if (finalPieces != that.finalPieces) return false;
        }


        return discountType == that.discountType;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = initialPieces;
        result = 31 * result + finalPieces;
        temp = Double.doubleToLongBits(percent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + discountType.hashCode();
        return result;
    }
}
