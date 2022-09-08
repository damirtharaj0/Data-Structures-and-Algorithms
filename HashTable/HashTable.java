/*
    Lab 5

    Daniel Amirtharaj

    This assignment demonstrates a hash table with the inert and search functionality.
 */

package HashTable;

import ObjectOrientedDesign.Currency;

public class HashTable {
    private Currency[] table;

    public HashTable(int size) throws Exception {
        if (size > 0)
            table = new Currency[size];
        else
            throw new Exception("Invalid size. Size should be greater than 0");
    }
    
    public int getSize() {
        return table.length;
    }

    public int search(Currency cur) {
        final int m = 2;
        int w = cur.getWhole();
        final int n = 3;
        int f = cur.getFraction();
        int index = ((m * w) + (n * f)) % getSize();
        for (int i = 1; i <= getSize(); i++) {
            if (table[index] == null) {
                return -1;
            } else if (isCurrencyEqual(table[index], cur)) {
                return index;
            } else {
                index = (index + i + (i * i)) % getSize();
            }
        }
        return -1;
    }

    private int hash(Currency cur) {
        final int m = 2;
        final int n = 3;
        int w = cur.getWhole();
        int f = cur.getFraction();
        return ((m * w) + (n * f)) % getSize();
    }

    private boolean isCurrencyEqual(Currency cur1, Currency cur2) {
        try {
            return cur1.isEqual(cur2);
        } catch (Exception e) {
            return false;
        }
    }

    private int quadraticProbe(int index, Currency cur) throws Exception {
        int numCollisions = 0;
        for (int i = 1; i <= getSize(); i++) {
            if (table[index] == null) {
                table[index] = cur;
                break;
            } else if (isCurrencyEqual(table[index], cur)) {
                numCollisions++;
                // index = (index + i + (i * i)) % getSize();
                System.out.println("Duplicate item found");
                return 0;
            } else {
                numCollisions++;
                index = (index + i + (i * i)) % getSize();
            }
        }
        return numCollisions;
    }

    public int insert(Currency cur) throws Exception {
        int index = hash(cur);
        return quadraticProbe(index, cur);
    }

    public int numItems() {
        int numSlots = 0;
        for (int i = 0; i < getSize(); i++) {
            if (table[i] != null) {
                numSlots++;
            }
        }
        return numSlots;
    }

    public double loadFactor() {
        return (double)numItems() / (double)getSize();
    }
}
