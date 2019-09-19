package market.entity;

import market.disscount.DiscountFormula;

/**
 * Created by Walid on 19/09/2019.
 * This class englobe alla informatins for product such as  pricee and discount
 */
public class Product {
    private String name;
    private double price;
    private boolean discounted;
    private DiscountFormula discountFormula;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscounted() {
        return discounted;
    }

    public void setDiscounted(boolean discounted) {
        this.discounted = discounted;
    }

    public DiscountFormula getDiscountFormula() {
        return discountFormula;
    }

    public void setDiscountFormula(DiscountFormula discountFormula) {
        this.discountFormula = discountFormula;
    }

    /**
     * equality of two object.
     * if these product have the same name ==> there are the same product.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return name.equals(product.name);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (discounted ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
