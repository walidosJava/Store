import junit.framework.Assert;
import market.product.Basket;
import market.product.MarketCash;
import market.product.CreateProduct;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Walid  on 11/09/2019.
 * this the main class fr testing filling bbaskaae and calculate ammount
 */
public class BasketTest {
    private Basket basket;

    @Before
    public void setUp() throws Exception {
        basket = fillBasket();
    }

    @Test
    public void testPrice() {
        MarketCash marketCash = new MarketCash(basket);
        System.out.print(basket);
        double tolalAmoount = new BigDecimal( marketCash.calculateMount(), MathContext.DECIMAL32).setScale(2).doubleValue();
        System.out.print("\n totla price = " + tolalAmoount + "$");
        Assert.assertEquals(" Amount  equals " ,  tolalAmoount, 5.10);
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * filling a basket by prooduct
     *
     * @return
     */
    private Basket fillBasket() {
        Basket basket = new Basket();
        basket.addProduct(CreateProduct.getApple(), 4);
        basket.addProduct(CreateProduct.getOrange(), 3);
        basket.addProduct(CreateProduct.getWatermelon(), 5);
        return basket;
    }




}