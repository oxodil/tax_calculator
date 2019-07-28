package products;

public abstract class Product {

    private String name;
    private float price;

    private boolean doesApplySalesTax;
    private boolean doesApplyImportedGoodsTax;

    private float salesTaxPercent;
    private float importedGoodsTaxPercent;

    private float salesTaxValue;
    private float importedGoodsTaxValue;
    private float totalTaxValue;
    private float priceWithTax;


    private final float salesTax10 = 10.00f;
    private final float salesTax0 = 0.00f;

    private final float importTax5 = 5.00f;
    private final float importTax0 = 0.00f;

    public Product(String name, float price, boolean doesApplySalesTax, boolean doesApplyImportedGoodsTax) {
        super();

        if (price < 0)
        {
            throw new IllegalArgumentException("Price of the product can't be negative.");
        }

        this.name = name;
        this.price = price;
        this.doesApplySalesTax = doesApplySalesTax;
        this.doesApplyImportedGoodsTax = doesApplyImportedGoodsTax;

        prepareTaxForObject();
    }

    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    private void setPrice(float price) {
        this.price = price;
    }

    public boolean isDoesApplySalesTax() {
        return doesApplySalesTax;
    }

    private void setDoesApplySalesTax(boolean doesApplySalesTax) {
        this.doesApplySalesTax = doesApplySalesTax;
    }

    public boolean isDoesApplyImportedGoodsTax() {
        return doesApplyImportedGoodsTax;
    }

    private void setDoesApplyImportedGoodsTax(boolean doesApplyImportedGoodsTax) {
        this.doesApplyImportedGoodsTax = doesApplyImportedGoodsTax;
    }

    public float getSalesTaxValue() {
        return salesTaxValue;
    }

    private void setSalesTaxValue() {
        this.salesTaxValue = this.getPrice()*(this.getSalesTaxPercent()/100);
    }

    public float getImportedGoodsTaxValue() {
        return importedGoodsTaxValue;
    }

    private void setImportedGoodsTaxValue() {
        this.importedGoodsTaxValue = this.getPrice()*(this.getImportedGoodsTaxPercent()/100);
    }

    public float getSalesTaxPercent() {
        return salesTaxPercent;
    }

    private void setSalesTaxPercent() {
        this.salesTaxPercent = (this.isDoesApplySalesTax()) ? salesTax10 : salesTax0;
    }

    public float getImportedGoodsTaxPercent() {
        return importedGoodsTaxPercent;
    }

    private void setImportedGoodsTaxPercent() {
        this.importedGoodsTaxPercent = (this.isDoesApplyImportedGoodsTax()) ? importTax5 : importTax0;
    }

    public float getTotalTaxValue() {
        return totalTaxValue;
    }

    private void setTotalTaxValue() {
        this.totalTaxValue = Math.round((this.getSalesTaxValue() + this.getImportedGoodsTaxValue())*20.0)/20.0f;
    }

    public float getPriceWithTax() {
        return priceWithTax;
    }

    private void setPriceWithTax() {
        this.priceWithTax = price + totalTaxValue;
    }

    private void prepareTaxForObject() {
        setDoesApplySalesTax(doesApplySalesTax);
        setSalesTaxPercent();
        setSalesTaxValue();

        setDoesApplyImportedGoodsTax(doesApplyImportedGoodsTax);
        setImportedGoodsTaxPercent();
        setImportedGoodsTaxValue();

        setTotalTaxValue();
        setPriceWithTax();
    }
}
