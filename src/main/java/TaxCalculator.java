import products.Product;

import java.util.List;
import java.util.Locale;

public class TaxCalculator {

    public static String getTotalTaxedValue(List<Product> listOfProducts) {

        float totalTaxesValue = 0.00f;
        float totalProductsCost = 0.00f;
        String productsWithTaxes = "";

        for(Product product : listOfProducts) {
            productsWithTaxes = productsWithTaxes + "1 " + product.getName() + ": " + String.format(Locale.US,"%.2f", product.getPriceWithTax()) + "\n";
            totalTaxesValue += product.getTotalTaxValue();
            totalProductsCost += product.getPriceWithTax();
        }

        String taxesInfo = "Sales Taxes: " + String.format(Locale.US,"%.2f", totalTaxesValue);
        String totalValue = "Total: " + String.format(Locale.US, "%.2f", totalProductsCost);

        String infoString = productsWithTaxes  + taxesInfo +"\n" + totalValue;
        return infoString;
    }


}
