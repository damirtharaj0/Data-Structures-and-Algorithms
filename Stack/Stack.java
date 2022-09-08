/*
    Lab 3

    Daniel Amirtharaj

    This assignment demonstrates creating and using the ADTs Singly Linked List, Stack, and Queue
 */

package Stack;

import ObjectOrientedDesign.*;
import SinglyLinkedList.*;

public class Stack extends SinglyLinkedList {
    public Stack() {
        super();
    }

    /*
    this method pushes an object of Currency to the top of the stack

    pre : curr - Currency
    post : pushes curr to the top of the stack
    return : void

    push( curr )
        start = getStart()
        newNode( curr, start )
        if ( start is null )
            set end to newNode
        end if
        set start to newNode
        increment count by 1
    end push
    */
    public void push(Currency curr) {
        LinkNode start = getStart();
        LinkNode newNode = new LinkNode(curr, start);
        if (start == null) {
            setEnd(newNode);
        }
        setStart(newNode);
        setCount(getCount()+1);
    }

    /*
    this method pops the top object from the list

    pre : none
    post : removes the top object from the list and returns it
    return : Currency

    pop( )
        start = getStart()
        if ( start equals null )
            throw Exception
        end if
        popped = data of start
        set start to next of start
        decrement count by 1
        if ( next of start equasl null )
            set end to null
        end if
        return popped
    end pop
    */
    public Currency pop() throws Exception {
        LinkNode start = getStart();
        if (start == null) {
            throw new Exception("Stack is Empty");
        }
        Currency popped = start.getData();
        setStart(start.getNext());
        setCount(getCount()-1);
        if (start.getNext() == null) {
            setEnd(null);
        }
        return popped;
    }
    /*
    this method returns the top element of the list

    pre : none
    post : returns the element at the top of the list
    return : Currency

    peek( )
        if ( start = null )
            return null
        end if
        return copy of data of start
    end peek
    */
    public Currency peek() throws Exception {
        if (getStart() == null) {
            return null;
        }
        return getStart().getData().copy();
    }

    /*
    this method returns the stack in a String

    pre : none
    post : return String of the data
    return : String

    printStack ( )
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
    end printStack
    */
    public String printStack() {
        LinkNode curNode = getStart();
        StringBuilder message = new StringBuilder(new String(""));
        for (int i = 0; i < countCurrency(); i++) {
            if (curNode.getData().getFraction() < 10)
                message.append(curNode.getData().getWhole()).append(".0")
                        .append(curNode.getData().getFraction())
                        .append(" ")
                        .append(curNode.getData().getCurrencyName())
                        .append("\t");
            else
                message.append(curNode.getData().getWhole()).append(".")
                        .append(curNode.getData().getFraction())
                        .append(" ")
                        .append(curNode.getData().getCurrencyName())
                        .append("\t");
            curNode = curNode.getNext();
        }
        return message.toString();
    }
}
