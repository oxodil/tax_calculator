package products;

public class SalesTaxedProduct extends Product {

    public SalesTaxedProduct(String name, float price, boolean doesApplyImportedGoodsTax) {
        super(name, price, true, doesApplyImportedGoodsTax);
    }
}
