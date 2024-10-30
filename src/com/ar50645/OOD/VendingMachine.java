package com.ar50645.OOD;

import java.util.LinkedList;
import java.util.List;

/** Add items to the vending machine in fixed number of slots
    Payment using card or cash
    Select item to dispense
 **/
class Slot {
    private final int row;
    private final int col;
    private final int size;
    private int availableItems;
    private Item itemName;
    Slot(int row, int col, int size) {
        this.row = row;
        this.col = col;
        this.size = size;
    }

    public void setItem(Item itemName) {
        this.itemName = itemName;
    }

    public void dispenseItem() {
        if(availableItems > 0) {
            availableItems--;
        }
        // release Item
    }

    public void refill(Item item, int noOfItems) {
        if(noOfItems + availableItems > size) {
            throw new OverFlowException();
        }
        availableItems+=noOfItems;
    }
}
record Item(Integer id, String name, Double price){
    // validation in the constructor
};

class Client{
    public static void main(String[] args) {

    }
}
class VendingMachine {

    public VendingMachine() {
        slots = new LinkedList<>();
    }
    List<Slot> slots;
    boolean add(Item item, Slot slot, int quantity) {
        if(!slots.contains(slot)) {
            throw new RuntimeException(" slots not found");
        }
        slot.refill(item, quantity);
        return true;
    }

    boolean checkout(Slot slot, PaymentMethod paymentMethod) {
        if(paymentMethod.getPaymentProcessor().processPayment(paymentMethod)) {
            slot.dispenseItem();
            return true;
        }
        return false; // or throw someException
    }

}

interface PaymentProcessor {
    PaymentResponse processPayment(double amount, PaymentDetails paymentDetails);
};

record PaymentDetails(PaymentMethod paymentMethod, String paymentDetails){};

record PaymentResponse(boolean success, String message){}

class CardPaymentProcessor implements PaymentProcessor {
    boolean processPayment() {
        //call remote API
        return true;
    }
}
class CashPaymentProcessor implements PaymentProcessor {
    boolean processPayment() {
        //call remote API
        return true;
    }
}

enum PaymentMethod {
    CASH,
    CARD;

    //factory to return the paymentProcessor
    public PaymentProcessor getPaymentProcessor() {
        switch(this) {
            case CARD -> {
                return new CardPaymentProcessor();
            }
            case CASH -> {
                return new CashPaymentProcessor();
            }
            default -> throw UnsupportedOperationException();
        }
    }
}

class SlotNotFoundException extends RuntimeException {
    public SlotNotFoundException(String message) {
        super(message);
    }
}


// entity -> Product, PaymentMethod, Slots

