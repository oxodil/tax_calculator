package products;

public class Food extends SalesTaxFreeProduct {

    public Food(String name, float price, boolean doesApplyImportedGoodsTax) {
        super(name, price, doesApplyImportedGoodsTax);
    }
}
