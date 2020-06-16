package net.emamarquez.atms.atmapi.entity;

public class Atm {
    private Address address;
    private int distance;

    public Atm(Address address, int distance, String type) {
        this.address = address;
        this.distance = distance;
        this.type = type;
    }

    private String type;

    @Override
    public String toString() {
        return "Atm{" +
                "address=" + address.toString() +
                ", distance=" + distance +
                ", type='" + type + '\'' +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
