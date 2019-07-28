package products;

public class MedicalProduct extends SalesTaxFreeProduct {
    public MedicalProduct(String name, float price, boolean doesApplyImportedGoodsTax) {
        super(name, price, doesApplyImportedGoodsTax);
    }
}
