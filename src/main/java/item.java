public class item {
    private String longname;
    private String shortName;

    public item(String longname, String shortName) {
        this.longname=longname;
        this.shortName=shortName;
    }

    public String getLongname() {
        return longname;
    }

    public String getShortName() {
        return shortName;
    }
}
