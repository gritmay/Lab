package products;

import enums.PotatoEnums;

public class Potato {

    private PotatoEnums.size size;
    private PotatoEnums.sauce sauce;

    @Override
    public String toString() {
        return "Potato{" +
                "size=" + size +
                ", sauce=" + sauce +
                '}';
    }

    public PotatoEnums.size getSize() {
        return size;
    }

    public void setSize(PotatoEnums.size size) {
        this.size = size;
    }

    public PotatoEnums.sauce getSauce() {
        return sauce;
    }

    public void setSauce(PotatoEnums.sauce sauce) {
        this.sauce = sauce;
    }
}
