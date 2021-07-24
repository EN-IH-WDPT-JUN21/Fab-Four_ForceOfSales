package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.enums.Product;
import com.ironhack.FabFour.homework2.enums.Status;
import com.ironhack.FabFour.homework2.common.CommandHandler;

import java.util.Objects;
import java.util.Scanner;

public class Opportunity {
    private static long opportunityIDCount = 1000;
    private long id;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
        setId(id);
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(Status.OPEN);
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        setId(id);
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    public long getId() {
        return Opportunity.opportunityIDCount;
    }

    public void setId(long id) {
        this.id = opportunityIDCount;
        opportunityIDCount++;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (product != null) {
            this.product = product;
        }
        else {
            Scanner aScanner = new Scanner(System.in);
            System.out.println("Please provide the type of the product you're interested in\n Possible choices are: HYBRID, FLATBED, BOX\n");
            if (aScanner.hasNextLine()) {
                setProduct(CommandHandler.getRequiredProduct(aScanner.next()));
            }
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0 && quantity <= 300) {
            this.quantity = quantity;
        }
        else {
            Scanner aScanner = new Scanner(System.in);
            System.out.println("Please provide the number of trucks you're interested in\n Maximum amount: 300");
            if (aScanner.hasNextLine()) {
                setQuantity(Integer.parseInt(aScanner.next()));
            }
        }
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunity that = (Opportunity) o;
        return id == that.id && quantity == that.quantity && product == that.product && decisionMaker.equals(that.decisionMaker) && status == that.status;
    }
}
