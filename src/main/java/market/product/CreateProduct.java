package market.product;

import market.disscount.DiscountFormula;
import market.disscount.DiscountType;
import market.entity.Product;

/**
 * Created by Walid on 11/09/2019.
 * Create product properties.
 *
 */
public class CreateProduct {
    /**
     * customize appple product
     *price : 0.2 <br>
     *     Buy One Get One Free on Apples
     *
     * @return
     */
    public static Product getApple() {
        Product apple = new Product();
        apple.setName("Apple");
        apple.setPrice(0.2);
        apple.setDiscounted(true);
        DiscountFormula discountFormula = getDiscountFormulaPieces(1, 2);
        apple.setDiscountFormula(discountFormula);
        return apple;
    }

    /**
     * customize watermelon.
     * price : 0.8<br>
     * Three For The Price Of Two on Watermelons

     *
     * @return product termelon
     */
    public static Product getWatermelon() {
        Product watermelon = new Product();
        watermelon.setName("Watermelon");
        watermelon.setPrice(0.8);
        watermelon.setDiscounted(true);
        DiscountFormula discountFormula = getDiscountFormulaPieces(2, 3);
        watermelon.setDiscountFormula(discountFormula);
        return watermelon;
    }

    /**
     * customize orange product
     *price : 0.5 <br>
     *     without dicoount

     * @return orange product entity
     */
    public static Product getOrange() {
        Product orange = new Product();
        orange.setName("Oraage");
        orange.setPrice(0.5);
        orange.setDiscounted(false);
        return orange;
    }

    /**
     * custoize discouunt with pieces
     *
     * @param initial
     * @param finalPiece
     * @return
     */

    private static DiscountFormula getDiscountFormulaPieces(int initial, int finalPiece) {
        DiscountFormula discountFormula = new DiscountFormula();
        discountFormula.setDiscountType(DiscountType.DISCOUNT_PIECE);
        discountFormula.setInitialPieces(initial);
        discountFormula.setFinalPieces(finalPiece);
        return discountFormula;
    }

}

