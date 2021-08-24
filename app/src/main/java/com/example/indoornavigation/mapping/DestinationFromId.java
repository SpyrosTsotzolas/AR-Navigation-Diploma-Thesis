package com.example.indoornavigation.mapping;

import java.util.ArrayList;

public class DestinationFromId {

    private String id;

    public DestinationFromId(String id) {
        this.id = id;
    }

    public ArrayList<Integer> getCoordinates() {

        ArrayList<Integer> coords = new ArrayList<>();

        switch (id) {
            case "A.2":
                coords.add(1);
                coords.add(365);
                coords.add(231);
                return coords;
            case "A.3":
                coords.add(2);
                coords.add(390);
                coords.add(234);
                return coords;
            case "A.4":
                coords.add(3);
                coords.add(420);
                coords.add(229);
                return coords;
            case "A.7":
                coords.add(4);
                coords.add(902);
                coords.add(228);
                return coords;
            case "A.8":
                coords.add(5);
                coords.add(929);
                coords.add(234);
                return coords;
            case "A.9":
                coords.add(6);
                coords.add(958);
                coords.add(229);
                return coords;
            default:
                return null;
        }
    }
}
