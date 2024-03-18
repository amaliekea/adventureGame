public class Item {

    protected String longName;
    protected String shortName;

    public Item(String longName, String shortName) {
        this.longName = longName;
        this.shortName = shortName;
    }

    public String getLongName(){
        return longName;
    }

    public String getShortName(){
        return shortName;
    }
}

