import org.junit.Assert;
import org.junit.Test;
import products.*;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorTest {

    @Test
    public void shouldThrowException() {
        System.out.println("\nTest case 1: Testing an exception mechanism for incorrect price value");
        Boolean isExceptionHasBeenThrown = false;
        try {
            Product book = new Book("book", -12.49f, false);
        } catch (IllegalArgumentException e) {
            isExceptionHasBeenThrown = true;
            System.out.println("Product's price can't be a negative number.");
        }

        Assert.assertTrue("Exception has not been thrown.", isExceptionHasBeenThrown);
        System.out.println("Setting a negative price value for a product does throw an IllegalArgumentException");
    }

    @Test
    public void shouldApply0TaxForNotImportedBook() {
        System.out.println("\nTest case 2: Testing if not imported book will have 0 tax value.");
        Book book = new Book("book", 12.49f, false);

        int expectedTaxValue = 0;
        Assert.assertTrue("Has not applied 0 tax but: " + book.getTotalTaxValue(), book.getTotalTaxValue() == expectedTaxValue);
        System.out.println("Not imported book has 0 total tax value.");
    }

    @Test
    public void shouldApply5PercentTaxForImportedBook() {
        Book book = new Book("book", 15.49f, true);
        System.out.println("\nTest case 3: Testing if not imported book will have 0 tax value.");

        float expectedTaxValue = 5.00f;
        Assert.assertTrue("Has not applied 5 tax but: " + book.getImportedGoodsTaxPercent(), book.getImportedGoodsTaxPercent()== expectedTaxValue);
        System.out.println("Imported Book has 5% tax.");
    }

    @Test
    public void shouldCalculateTotalValueForImportedCDPlayer() {
        System.out.println("\nTest case 4: Testing if total price to pay for an imported CD player will be equal to 115.");
        SalesTaxedProduct cdPlayer = new SalesTaxedProduct("CD player", 100.00f, true);

        float expectedFinalValue = 115.00f;
        Assert.assertTrue("Total product value with tax is not equal to 115 but: " + cdPlayer.getPriceWithTax(), cdPlayer.getPriceWithTax() == expectedFinalValue);
        System.out.println("Imported CD player total price is equal to: " + cdPlayer.getPriceWithTax() + " with included total tax of " + cdPlayer.getTotalTaxValue());

    }

    @Test
    public void shouldCalculateValuesTestCase1() {
        System.out.println("\nTest case 5: Testing a given scenario Input1");

        Book book = new Book("book", 12.49f, false);
        SalesTaxedProduct musicCD = new SalesTaxedProduct("music CD", 14.99f, false);
        Food chocolateBar = new Food("chocolate bar", 0.85f, false);

        List<Product> listOfProducts = new ArrayList<Product>();

        listOfProducts.add(book);
        listOfProducts.add(musicCD);
        listOfProducts.add(chocolateBar);

        String receipt = TaxCalculator.getTotalTaxedValue(listOfProducts);
        System.out.println(receipt);

        String expectedValue = "1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83";

        Assert.assertTrue("Receipt is not correct", expectedValue.equals(receipt));
        System.out.println("Algorithm has calculated the total value and tax value correctly");
    }

    @Test
    public void shouldCalculateValuesTestCase2() {
        System.out.println("\nTest case 6: Testing a given scenario Input2");
        Food importedBoxOfChocolates = new Food("imported box of chocolates", 10.00f, true);
        SalesTaxedProduct importedBottleOfPerfume = new SalesTaxedProduct("imported bottle of perfume", 47.50f, true);

        List<Product> listOfProducts = new ArrayList<Product>();

        listOfProducts.add(importedBoxOfChocolates);
        listOfProducts.add(importedBottleOfPerfume);

        String receipt = TaxCalculator.getTotalTaxedValue(listOfProducts);
        System.out.println(receipt);

        String expectedValue = "1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15";

        Assert.assertTrue("Receipt is not correct", expectedValue.equals(receipt));
        System.out.println("Algorithm has calculated the total value and tax value correctly");
    }

    @Test
    public void shouldCalculateValuesTestCase3() {
        System.out.println("\nTest case 7: Testing a given scenario Input3");
        SalesTaxedProduct importedBottleOfPerfume = new SalesTaxedProduct("imported bottle of perfume", 27.99f, true);
        SalesTaxedProduct bottleOfPerfume = new SalesTaxedProduct("bottle of perfume", 18.99f, false);
        MedicalProduct headachePills = new MedicalProduct("packet of headache pills", 9.75f, false);
        Food importedBoxOfChocolates = new Food("imported box of chocolates", 11.25f, true);

        List<Product> listOfProducts = new ArrayList<Product>();

        listOfProducts.add(importedBottleOfPerfume);
        listOfProducts.add(bottleOfPerfume);
        listOfProducts.add(headachePills);
        listOfProducts.add(importedBoxOfChocolates);

        String receipt = TaxCalculator.getTotalTaxedValue(listOfProducts);
        System.out.println(receipt);

        String expectedValue = "1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.80\n" +
                "Sales Taxes: 6.65\n" +
                "Total: 74.63";

        Assert.assertTrue("Receipt is not correct", expectedValue.equals(receipt));
        System.out.println("Algorithm has calculated the total value and tax value correctly");
    }
}