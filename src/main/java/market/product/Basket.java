package market.product;

import market.entity.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Walid on 19/09/2019.
 * The content of basket.
 * Te main operation on the basket.
 * * This class is designed for use as a drop-in replacement for
 * in places where the basket  was being updated.
 * It is used for <b>creating a mutubale object for basket class</b>.
 */
public class Basket {
    private Map<Product, Integer> items;
    private MarketCash marketCash;


    public Basket() {
        items = new HashMap<>();
        marketCash = new MarketCash (this);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    /**
     * adding once product to basket
     *
     * @param product
     * @return this basket
     */
    public Basket addProduct(Product product) {
        addProduct(product, 1);
        return this;
    }

    /**
     * adding many  product to basket
     *
     * @param product
     * @return this basket
     */
    public Basket addProduct(Product product, int number) {
        if (computeProduct(product) > 0) {
            items.compute(product, (p, q) -> Integer.valueOf(q + number));
        } else {
            items.put(product, number);
        }
        return this;
    }

    /**
     * removing all  product from basket.
     * If  it is not existing,  nothing  happen
     *
     * @param product
     * @return this basket
     */
    public Basket removeProduct(Product product) {
        items.remove(product);
        return this;

    }

    /**
     * remove the number of product.
     * if number < 1, nothing happen
     * if number exceed thenumber of product existing in baaket , removing max number
     *
     * @param product
     * @param number
     * @return this basket
     */
    public Basket removeProduct(Product product, int number) {
        final int computeProduct = computeProduct(product);
        if (number < 1) return this;
        if (computeProduct > 1 && computeProduct > number) {
            items.compute(product, (p, q) -> Integer.valueOf(q - number));
        } else {
            removeProduct(product);
        }
        return this;
    }

    /**
     * compute number of elements in the basket.
     * If the product is not existing , it return zero
     *
     * @param product
     * @return number of product into basket
     */
    public int computeProduct(Product product) {
        return items.containsKey(product) ? items.get(product) : 0;
    }

    @Override
    public String toString() {
        double tolalAmount = marketCash.calculateMount();

        return "Basket content {" +
                 items +
                '}' + "==> total price = " + tolalAmount + "$";
    }


}
