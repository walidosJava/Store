package market.product;

import market.entity.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Walid on 10/09/2019.
 * The content of basket
 */
public class Basket {
    private Map<Product, Integer> items;

    public Basket() {
        items = new HashMap<>();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    /**
     * adding once product to baasket
     * @param product
     */
    public void addProduct(Product product){
      addProduct(product, 1);
    }

    /**
     * adding many  product to baasket
     * @param product
     */
    public void addProduct(Product product , int number){
        if(items.containsKey(product)){
            items.compute(product, (p,q ) -> Integer.valueOf(q+number));
        }else{
            items.put(product, number);
        }
    }
    public void removeProduct(Product product){
        if(items.get(product).intValue() > 1){
            items.compute(product, (p, q) -> Integer.valueOf(q-1));
        }else{
            items.remove(product);
        }
    }

    @Override
    public String toString() {
        return "market.product.Basket{" +
                "products =" + items +
                '}';
    }


}
