package com.model;

import javafx.beans.property.SimpleStringProperty;

public class Students {
    private final SimpleStringProperty ID;
    private final SimpleStringProperty name;
    private final SimpleStringProperty Country;

    public Students(String ID, String name, String Country) {
        this.ID = new SimpleStringProperty(ID);
        this.name = new SimpleStringProperty(name);
        this.Country = new SimpleStringProperty(Country);
    }

    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCountry() {
        return Country.get();
    }

    public SimpleStringProperty countryProperty() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country.set(country);
    }
}
