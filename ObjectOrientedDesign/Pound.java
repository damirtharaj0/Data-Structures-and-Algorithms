/*
    Lab 2

    Daniel Amirtharaj

    This assignment derives two child classes from the abstract class Currency and demonstrates operations on the objects.
 */

package ObjectOrientedDesign;

public class Pound extends Currency {
    final private String currencyName = "Pound";

    Pound() {
        super();
    }

    public Pound(double value) throws Exception {
        super(value);
    }

    public Pound(Pound p) {
        super(p);
    }

    // This method returns the currencyName and overrides the method in the base class Currency
    @Override
    public String getCurrencyName() {
        return currencyName;
    }

    // This method returns a copy of a pound object
    @Override
    public Currency copy() {
        return new Pound(this);
    }
}