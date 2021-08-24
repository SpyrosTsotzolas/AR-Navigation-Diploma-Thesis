package com.example.indoornavigation.mapping;

import java.util.ArrayList;

public class Destination implements Location{

    private String name;

    public Destination(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<Integer> getCoordinates() {

        ArrayList<Integer> coords = new ArrayList<>();

        switch (name) {
            case "blekasOffice":
                coords.add(1);
                coords.add(365);
                coords.add(231);
                return coords;
            case "vlachosOffice":
                coords.add(2);
                coords.add(390);
                coords.add(234);
                return coords;
            case "lykasOffice":
                coords.add(3);
                coords.add(420);
                coords.add(229);
                return coords;
            case "zarrasOffice":
                coords.add(4);
                coords.add(902);
                coords.add(228);
                return coords;
            case "polenakisOffice":
                coords.add(5);
                coords.add(929);
                coords.add(234);
                return coords;
            case "mamoulisOffice":
                coords.add(6);
                coords.add(958);
                coords.add(229);
                return coords;
        }
        return null;
    }
}
