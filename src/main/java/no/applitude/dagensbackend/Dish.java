package no.applitude.dagensbackend;

class Dish{
    private String title;
    private String description;
    private String[] allergies;
    private String price;
    private boolean veggie;

    public Dish(String title, String description, String []allergies, String price, boolean veggie){
        this.title = title;
        this.description = description;
        this.allergies = allergies;
        this.price = price;
        this.veggie = veggie;
    }
}
