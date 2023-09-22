package models;

public class Position {

    private int quantity;
    private boolean isReady;

    public Position(int quantity, boolean isReady) {
        this.quantity = quantity;
        this.isReady = isReady;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isReady() {
        return isReady;
    }

    public String isReadyString() {
        if (isReady){
            return "готов";
        } else return "не готов";
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
