package products;

public abstract class SalesTaxFreeProduct extends Product {

    public SalesTaxFreeProduct(String name, float price, boolean doesApplyImportedGoodsTax) {
        super(name, price, false, doesApplyImportedGoodsTax);
    }
}
