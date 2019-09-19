import junit.framework.Assert;
import market.entity.Product;
import market.product.Basket;
import market.product.CreateProduct;
import market.product.MarketCash;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Walid  on 19/09/2019.
 * this the main class for testing filling baskaae and calculate amount
 */
public class BasketTest {
    public static final Product ORANGE = CreateProduct.getOrange();
    public static final Product WATERMELON = CreateProduct.getWatermelon();
    public static final Product APPLE = CreateProduct.getApple();
    private Basket basket;
   private  MarketCash marketCash;

    @Before
    public void setUp() throws Exception {
        basket = fillBasket();
        marketCash = new MarketCash(basket);
    }

    /**
     * test price for 4 apples , 3 oranges, 5 watermelon
     * * <table>
     <thead>
     <tr>
     <th>item</th>
     <th>Quantity</th>
     </tr>
     </thead>
     <tbody>
     <tr>
     <td>Apple</td>
     <td>4</td>
     </tr>
     <tr>
     <td>Orange</td>
     <td>3</td>
     </tr>
     <tr>
     <td>Watermelon</td>
     <td>5</td>
     </tr>
     </tbody>
     </table>
     */

    @Test
    public void testPrice() {

        System.out.println(basket);
        double tolalAmount = marketCash.calculateMount();
        System.out.println("\n total price = " + tolalAmount + "$");
        Assert.assertEquals(" Amount  equals ", tolalAmount, 5.10);
    }


    /**
     * test all operation for basket and content, such as add, remove ,remove all
     */

    @Test
    public void testOperationBasket() {
        basket = new Basket();
        basket.addProduct(APPLE, 5);//basket contains 5 apples
        basket.addProduct(ORANGE, 6);//adding 6 orange
        basket.addProduct(WATERMELON, 12);//adding 10 watermelon
        basket.addProduct(APPLE, 4);//adding 4 apples => total  9 apples
        basket.addProduct(APPLE);// aading apple ==>total 10 apples
        System.out.println("*****************\n***************   content of the basket initial ********************\n"+ basket);
        Assert.assertEquals("Basket contains 10 apples ", basket.computeProduct(APPLE), 10);
        Assert.assertEquals("Basket contains 6 oranges ", basket.computeProduct(ORANGE), 6);
        Assert.assertEquals("Basket contains 12 watermelon ", basket.computeProduct(WATERMELON), 12);
        basket.removeProduct(WATERMELON, 10);//watermelon contains 2
        System.out.println("*****************\n***************   content of the basket after remmoving 10 watermelon ********************\n"+ basket);
        Assert.assertEquals("Basket contains 2 watermelon ", basket.computeProduct(WATERMELON), 2);
        basket.removeProduct(WATERMELON, -5);// nothing happen
        System.out.println("*****************\n***************   content of the basket after remmoving -5 watermelon ********************\n"+ basket);
        Assert.assertEquals("Basket contains 2 watermelon ", basket.computeProduct(WATERMELON), 2);
        basket.removeProduct(ORANGE);//removing all orange from basket
        System.out.println("*****************\n***************   content of the basket after removing all orange ********************\n"+ basket);
        Assert.assertTrue("Basket does not contains orange  ", basket.getItems().containsKey(ORANGE) == false);


    }

    /**
     * filling a basket by product
     *
     * @return basket containing 4 aapples, 3 oranges && 5 watermelon
     */
    private Basket fillBasket() {
        Basket basket = new Basket();
        basket.addProduct(APPLE, 4);
        basket.addProduct(ORANGE, 3);
        basket.addProduct(WATERMELON, 5);
        return basket;
    }


}