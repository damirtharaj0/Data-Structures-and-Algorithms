/*
    Lab 2

    Daniel Amirtharaj

    This assignment derives two child classes from the abstract class Currency and demonstrates operations on the objects.
 */

package ObjectOrientedDesign;

public class Dollar extends Currency {
    final private String currencyName = "Dollar";

    Dollar() {
        super();
    }

    public Dollar(double value) throws Exception {
        super(value);
    }

    public Dollar(Dollar dol) {
        super(dol);
    }

    // This method returns the currencyName and overrides the method in the base class Currency
    @Override
    public String getCurrencyName() {
        return currencyName;
    }

    // This method returns a copy of a dollar object
    @Override
    public Currency copy() {
        return new Dollar(this);
    }
}