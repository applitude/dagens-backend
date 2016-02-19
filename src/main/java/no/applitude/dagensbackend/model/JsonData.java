package no.applitude.dagensbackend.model;

class JsonData{
    private int timestamp;
    private Location []locations;
    public JsonData(){
        long millis = System.currentTimeMillis();
        this.timestamp = (int)millis/1000;
    }
    public void add(Location l){
        locations = Arrays.copyOf(locations, locations.length+1);
        locations[locations.length-1] = l;
    }
}
