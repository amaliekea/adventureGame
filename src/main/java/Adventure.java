public class Adventure {
    private player newPlayer = new player();

    public Adventure() {
        this.newPlayer = new player(); //laver et objekt af klassen player
    }
    public String movePlayer(String userInput) {
        return newPlayer.movePlayer(userInput);
    }
}
