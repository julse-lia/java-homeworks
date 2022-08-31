package homework8.shapeinterface;

public interface Dye {
    String DEFAULT_COLOR = "white";

    default String dye() {
        return " is dyed in a default " + DEFAULT_COLOR + " color";
    }

    void dye(String color);
}
