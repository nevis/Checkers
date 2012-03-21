package Model;

public class Player {
    private String name;
    private int hashCode;
    public Player(String name, int hashCode) {
        this.name = name;
        this.hashCode = hashCode;
    }
    public String getName() {
        return this.name;
    }
    public int getHashCode() {
        return this.hashCode;
    }
}
