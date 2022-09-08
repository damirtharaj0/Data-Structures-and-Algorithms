/*
    Lab 3

    Daniel Amirtharaj

    This assignment demonstrates creating and using the ADTs Singly Linked List, Stack, and Queue
 */

package Queue;

import ObjectOrientedDesign.*;
import SinglyLinkedList.*;

public class Queue extends SinglyLinkedList {
    public Queue() {
        super();
    }

    /*
    this method adds a currency to the end of the queue

    pre : curr - Currency
    post : adds the currency object to the end of the queue
    return : void

    enqueue ( )
        newNode(curr, null)
        if ( end = null )
            set start to newNode
            set end to newNode
        end if
        set next of end to newNode
        increment count by 1
        set end to newNode
    end enqueue
    */
    public void enqueue(Currency curr) {
        LinkNode newNode = new LinkNode(curr, null);
        if (getEnd() == null) {
            setStart(newNode);
            setEnd(newNode);
        }
        getEnd().setNext(newNode);
        setCount(getCount()+1);
        setEnd(newNode);
    }

    /*
    this method removes an element from the front of the queue

    pre : none
    post : removes element from queue and returns it
    return : Currency

    dequeue ( )
        start = start
        if ( start = null )
            return null
        end if
        dequeued = data of start
        set start to next of start
        decrement count by 1
        if ( next of start = null )
            set end to null
        end if
        return dequeued
    end dequeue
    */
    public Currency dequeue() {
        LinkNode start = getStart();
        if (start == null) {
            return null;
        }
        Currency dequeued = start.getData();
        setStart(start.getNext());
        setCount(getCount()-1);
        if (start.getNext() == null) {
            setEnd(null);
        }
        return dequeued;
    }

    /*
    this method returns the currency at the start of the list

    pre : none
    post : returns the data of the starting link node
    return : Currency

    peekFront ( )
        if ( start = null )
            return null
        end if
        return copy of data of getStart
    end peekFront ( )
    */
    public Currency peekFront() {
        if (getStart() == null) {
            return null;
        }
        return getStart().getData().copy();
    }

    /*
    this method returns the currency at the end of the list

    pre : none
    post : returns the data of the end link node
    return : Currency

    peekEnd ( )
        if ( end = null )
            return null
        end if
        return copy of data of end
    end peekEnd ( )
    */
    public Currency peekRear() {
        if (getEnd() == null) {
            return null;
        }
        return getEnd().getData().copy();
    }

    /*
    this method returns a String of the data

    pre : none
    post : String of data
    return : String

    printQueue ( )
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
    end printQueue
    */
    public String printQueue() {
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
