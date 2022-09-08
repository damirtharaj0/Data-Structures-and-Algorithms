/*
    Lab 3

    Daniel Amirtharaj

    This assignment demonstrates creating and using the ADTs Singly Linked List, Stack, and Queue
 */

package SinglyLinkedList;

import ObjectOrientedDesign.*;

public class SinglyLinkedList {
    private int count;
    private LinkNode start;
    private LinkNode end;

    public SinglyLinkedList() {
        this.start = null;
        this.end = null;
        this.count = 0;
    }

    /*
    These getter methods return the value of the private instance variables

    Pre : none
    Post : returns the value of the count, start, and end
    Return : int, LinkNode, LinkNode

    getCount ( )
        return count
    end getCount

    getStart ( )
        return start
    end getStart

    getEnd ( )
        return end
    end getEnd
    */
    public int getCount() {
        return count;
    }

    public void dosomething() {
        LinkNode cur = getStart();
        LinkNode prev = null;
        LinkNode next = null;

        while (cur != null) {
            next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        setStart(prev);
    }

    public LinkNode getStart() {
        return start;
    }

    public LinkNode getEnd() {
        return end;
    }

    /*
    These setter methods set the values of the member variables

    Pre : count - int, start - LinkNode, end - LinkNode
    Post : sets the member variables
    Return : void

    setCount ( )
        this.count = count
    end setCount

    setStart ( )
        this.start = start
    end setStart

    setEnd ( )
        this.end = end
    end setEnd
    */
    public void setCount(int count) {
        this.count = count;
    }

    public void setStart(LinkNode start) {
        this.start = start;
    }

    public void setEnd(LinkNode end) {
        this.end = end;
    }

    /*
    this method adds a currency at the nodeIndex specified.

    Pre: curr - Currency, nodeIndex - int
    Post: adds the currency given to the index given
    Return: void

    addCurrency ( curr, nodeIndex )
        if ( nodeIndex > count )
            throw exception
        end if
        newNode(curr)
        if ( list is empty )
            next of newNode = null
            start = newNode
            end = newNode
            count = 1
        end if
        previousNode = null
        curNode = start

        for ( i < nodeIndex )
            previousNode = curNode
            curNode = next of curNode
        end for
        if ( previousNode = null )
            next of newNode = curNode
            start = newNode
        else
            next of previousNode = newNode
            next of newNode = curNode
        end if
        increment count by 1
    end addCurrency
    */
    public void addCurrency(Currency curr, int nodeIndex) throws Exception {
        if (nodeIndex > getCount()) {
            throw new Exception("Index out of bounds");
        }
        LinkNode newNode = new LinkNode(curr);
        if (isListEmpty()) {
            newNode.setNext(null);
            setStart(newNode);
            setEnd(newNode);
            setCount(1);
            return;
        }

        LinkNode previousNode = null;
        LinkNode curNode = start;

        for (int i = 0; i < nodeIndex; i++) {
            previousNode = curNode;
            curNode = curNode.getNext();
        }
        if (previousNode == null) {
            newNode.setNext(curNode);
            setStart(newNode);
        }
        else {
            previousNode.setNext(newNode);
            newNode.setNext(curNode);
        }
        count++;
    }

    /*
    this methods returns the Currency at the index specified

    Pre: index - type int
    Post: returns the Currency of the index given
    Return: Currency

    getCurrency ( index )
        if ( list is empty )
            throw exception
        end if
        if ( index > count )
            throw exception
        end if
        currentNode equals start
        for ( i < index )
            curNode = next of curNode
        end for
        return data of currNode
    end getCurrency
    */
    public Currency getCurrency(int index) throws Exception {
        if (isListEmpty()) {
            throw new Exception("List is empty");
        }
        if (index > getCount()) {
            throw new Exception("Index out of bounds");
        }
        LinkNode currentNode = getStart();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    /*
    this method returns the index of the currency specified

    Pre: curr - type Currency
    Post: returns the index of the currency found
    Return: int

    findCurrency ( curr )
        currentNode = start
        for ( i < getCount )
            if ( variables of data of currentNode equals variables of curr )
                return i
            end if
            currentNode = next of currentNode
        end for
        return -1
    end findCurrency
    */
    public int findCurrency(Currency curr) {
        LinkNode currentNode = start;

        for (int i = 0; i < getCount(); i++) {
            if (currentNode.getData().getWhole() == curr.getWhole()
                    && currentNode.getData().getFraction() == curr.getFraction()
                    && currentNode.getData().getCurrencyName().equals(curr.getCurrencyName())) {
                return i;
            }
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    /*
    this method removes the currency given from the list

    Pre: curr - type Currency
    Post: removes the currency from list
    Return: void

    removeCurrency ( curr )
        if ( list is empty )
            return null;
        end if
        previous = null
        currentNode = start
        for ( i < count )
            if ( variables of data of currentNode = variables of curr )
                if ( previous = null )
                    start = currentNode
                else
                    next of previous = next of currentNode
                end if
                decrement count by 1
                return copy of data of currentNode
            end if
            previous = currentNode
            currentNode = next of currentNode
        end for
        return null
    end removeCurrency

    */
    public Currency removeCurrency(Currency curr) throws Exception {
        if (isListEmpty()) {
            return null;
        }

        LinkNode previous = null;
        LinkNode currentNode = getStart();

        for (int i = 0; i < getCount(); i++) {
            if (currentNode.getData().getWhole() == curr.getWhole()
                    && currentNode.getData().getFraction() == curr.getFraction()
                    && currentNode.getData().getCurrencyName().equals(curr.getCurrencyName())) {
                if (previous == null) {
                    setStart(currentNode);
                }
                else {
                    previous.setNext(currentNode.getNext());
                }
                count--;
                return currentNode.getData().copy();
            }
            previous = currentNode;
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /*
    this method removes the currency at the index specified

    Pre: nodeIndex - type int
    Post: removes the currency at the given index
    Return: void

    removeCurrency ( nodeIndex )
        if ( list is empty )
            throw Exception
        end if
        previous = null
        currentNode = start
        for ( i < nodeIndex )
            previous = currentNode
            currentNode = next of currentNode
        end for
        if ( previous = null )
            start = next of currentNode
        else
            next of previous = next of currentNode
        end if
        decrement count by 1
        return copy of data of currentNode
    end removeCurrency
    */
    public Currency removeCurrency(int nodeIndex) throws Exception {

        if (isListEmpty()) {
            return null;
        }

        LinkNode previous = null;
        LinkNode currentNode = getStart();

        for (int i = 0; i < nodeIndex; i++) {
            previous = currentNode;
            currentNode = currentNode.getNext();
        }
        if (previous == null) {
            setStart(currentNode.getNext());
        } else {
            previous.setNext(currentNode.getNext());
        }
        count--;
        return currentNode.getData().copy();
    }

    /*
    this methods checks if the list is empty

    Pre: none
    Post: returns true if the list is empty and false if it is not
    Return: true or false

    isListEmpty ( )
        if ( start == null )
            return true
        else
            return false
        end if
    end isListEmpty
    */
    public boolean isListEmpty() {
        return start == null;
    }

    /*
    this method returns the count of the list

    Pre: none
    Post: returns the count of the list
    Return: int

    countCurrency ( )
        counter = 0
        if ( list is empty )
            return counter
        end if
        curNode = start
        while ( curNode != end )
            increment counter by 1
            curNode = next of curNode
        end while
        return counter
    end countCurrency
    */
    public int countCurrency() {
        int counter = 0;
        if (isListEmpty()) {
            return counter;
        }
        counter++;
        LinkNode curNode = start;
        while(!curNode.equals(end)) {
            counter++;
            curNode = curNode.getNext();
        }
        return counter;
    }

    /*
    this method returns a string of all the data

    Pre: none
    Post: returns a string of the data in the list
    Return: String

    printList( )
        curNode = start
        message = ""
        for ( i < getCount )
            if ( fraction < 10 )
                message = whole + ".0" + fraction
            else
                message = whole + "." + fraction
            end if
            curNode = next of curNode
        end for
        return message
    end printList
    */
    public String printList() {
        LinkNode curNode = start;
        StringBuilder message = new StringBuilder(new String(""));
        for (int i = 0; i < countCurrency(); i++) {
            if (curNode.getData().getFraction() < 10)
                message.append(curNode.getData().getWhole()).append(".0")
                        .append(curNode.getData().getFraction()).append(" ")
                        .append(curNode.getData().getCurrencyName())
                        .append("\t");
            else
                message.append(curNode.getData().getWhole()).append(".")
                        .append(curNode.getData().getFraction()).append(" ")
                        .append(curNode.getData().getCurrencyName())
                        .append("\t");
            curNode = curNode.getNext();
        }
        return message.toString();
    }
}
