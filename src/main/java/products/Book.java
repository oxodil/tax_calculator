package products;

public class Book extends SalesTaxFreeProduct {

    public Book(String name, float price, boolean doesApplyImportedGoodsTax) {
        super(name, price, doesApplyImportedGoodsTax);
    }
}
