package homework8.shapeinterface;

import homework8.abstractclasses.Shape;

public interface Dye {
    String DEFAULT_FILLER_COLOR = "white";
    String DEFAULT_BORDER_COLOR = "black";

    default String dye(Shape shape){
        return String.format("%s is dyed in a default %s color with %s border",
                shape.getName(), DEFAULT_FILLER_COLOR, DEFAULT_BORDER_COLOR);
    }

    void dye();
}
