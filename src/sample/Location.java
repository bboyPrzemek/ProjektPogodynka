package sample;


public class Location {

    private String coords;
    private String name;
    private Integer ID=1;

    public Location(String coords, String name){
        this.coords=coords;
        this.name=name;
        this.ID=ID;
    }

    public String getCoords() {
        return coords;
    }

    public String getName() {
        return name;
    }

    public Integer getID() {
        return ID;
    }

}

