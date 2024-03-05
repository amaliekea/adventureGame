public class Rooms {

    //Declaring the room attributes
    private String name;
    private String description;
    private Rooms n;
    private Rooms e;
    private Rooms s;
    private Rooms w;


    //Setting up the constructor for the rooms
    public Rooms(String name, String description){
        this.name = name;
        this.description = description;

        this.n = null;
        this.e = null;
        this.s = null;
        this.w = null;
    }

    //Getter and setter methods
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Rooms getN() {
        return n;
    }

    public Rooms getE(){
        return e;
    }

    public Rooms getS(){
        return s;
    }

    public Rooms getW(){
        return w;
    }

    public void setN(Rooms n){
        this.n = n;
    }

    public void setE(Rooms e){
        this.e = e;
    }

    public void setS(Rooms s){
        this.s = s;
    }

    public void setW(Rooms w) {
        this.w = w;
    }



}
