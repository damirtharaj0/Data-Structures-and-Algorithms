/*
    Lab 2

    Daniel Amirtharaj

    This assignment derives two child classes from the abstract class Currency and demonstrates operations on the objects.
 */

package ObjectOrientedDesign;

public abstract class Currency {
    private int whole;
    private int fraction;

    Currency() {
        this.whole = 0;
        this.fraction = 0;
    }

    public Currency(double value) throws Exception {
        if (value < 0.0) {
            throw new Exception("Invalid Input");
        }
        whole = (int) value;
        fraction = (int) Math.round(value % 1 * 100);
    }

    public Currency(Currency curr) {
        this.whole = curr.getWhole();
        this.fraction = curr.getFraction();
    }

    /*
    These getter methods return the value of the private instance variables

    Pre : none
    Post : returns the value of the whole of fraction number
    Return : int

    getWhole ( )
        return whole
    end getWhole

    getFraction ( )
        return fraction
    end getFraction

    */

    public int getWhole() {
        return whole;
    }
    public int getFraction() {
        return fraction;
    }

    //This abstract method will be implemented in the derived class with this signature
    abstract public String getCurrencyName();

    abstract public Currency copy();

    // This method adds another object of the same currency
    public void add(Currency curr) throws Exception {
        if (!getCurrencyName().equals(curr.getCurrencyName())) {
            throw new Exception("Invalid Addition");
        }

        fraction += curr.getFraction();
        whole += curr.getWhole();

        if (fraction >= 100) {
            whole++;
            fraction -= 100;
        }
    }

    // This method subtracts another object of the same currency
    public void subtract(Currency curr) throws Exception {
        if (!getCurrencyName().equals(curr.getCurrencyName())) {
            throw new Exception("Invalid Subtraction");
        }
        if (!isGreater(curr)) {
            throw new Exception("Invalid Subtraction");
        }
        fraction -= curr.getFraction();
        whole -= curr.getWhole();

        if(fraction < 0.0) {
            whole--;
            fraction += 100;
        }
    }

    // This method checks if another object of the same currency has equal values
    public boolean isEqual(Currency curr) throws Exception {
        if (!getCurrencyName().equals(curr.getCurrencyName())) {
            throw new Exception("Invalid Input");
        }
        return whole == curr.getWhole() && fraction == curr.getFraction();
    }

    // This method checks if another object of the same currency is greater
    public boolean isGreater(Currency curr) throws Exception {
        if (!getCurrencyName().equals(curr.getCurrencyName())) {
            throw new Exception("Invalid Input");
        }
        if (whole < curr.getWhole()) {
            return false;
        }
        if (whole == curr.getWhole() && fraction < curr.getFraction()) {
            return false;
        }
        return true;
    }
    
    // This method prints the values of whole and fraction
    public void print() {
        if(fraction < 10)
            System.out.printf("%d.0%d %s ", whole, fraction, getCurrencyName());
        else
            System.out.printf("%d.%d %s ", whole, fraction, getCurrencyName());
    }
}