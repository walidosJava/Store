package market.product;

import market.entity.Product;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

/**
 * Created by Walid on 19/09/2019.
 * This is class is responsible for calculating a price of basket
 */
public class MarketCash {
    private Basket basket;

    public MarketCash(Basket basket) {
        this.basket = basket;
    }

    /**
     * encapsulate all product bying on a smae cash
     *
     * @return amount of basket
     */
    public double calculateMount() {
        double totalAmount = 0;
        for (Map.Entry<Product, Integer> entry : basket.getItems().entrySet()) {
            final Product product = entry.getKey();
            final Integer number = entry.getValue();
            if (product.getDiscountFormula() == null)
                totalAmount += product.getPrice() * number;
            else if (product.getDiscountFormula().isDiscountedPercent()) {
                totalAmount += calculateMountForDiscountPercent(product, number);
            } else {
                totalAmount += calculateMountForDiscountPieces(product, number);
            }

        }
        return  new BigDecimal(totalAmount, MathContext.DECIMAL32).setScale(2).doubleValue();

    }

    /**
     * @param product
     * @param number
     * @return amount of products how is discounted by piece
     */
    private double calculateMountForDiscountPieces(Product product, int number) {
        double amount = 0;
        int initialFormula = product.getDiscountFormula().getInitialPieces();
        int finalFormula = product.getDiscountFormula().getFinalPieces();
        int numberLot = number / finalFormula;
        int numberPiece = number % finalFormula;
        amount = numberLot * initialFormula * product.getPrice() + numberPiece * product.getPrice();
        return amount;
    }

    /**
     * @param product
     * @param number
     * @return amount of product ddisscounted by percent
     */
    private double calculateMountForDiscountPercent(Product product, int number) {
        double amount = 0;
        double discounted = 100.0d - product.getDiscountFormula().getPercent();
        return amount * discounted * (double) number;
    }
}
