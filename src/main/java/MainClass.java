import market.product.Basket;
import market.product.CreateProduct;
import market.product.MarketCash;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Walid on 11/09/2019.
 * this is a main class for calcculating amount of basket
 */
public class MainClass {
    public static void main(String... args) {
        Basket basket = new Basket();
        basket.addProduct(CreateProduct.getApple(), 14);
        basket.addProduct(CreateProduct.getOrange(), 9);
        basket.addProduct(CreateProduct.getWatermelon(), 7);
        MarketCash marketCash = new MarketCash(basket);
        System.out.println(basket);
        double tolalAmoount = new BigDecimal(marketCash.calculateMount(), MathContext.DECIMAL32).setScale(2).doubleValue();
        System.out.print("\n totla price = " + tolalAmoount + " $");
    }
}
