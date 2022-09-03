package homework8;

import homework8.abstractclasses.Shape;
import homework8.shapeinterface.Dye;
import lombok.Getter;
import lombok.Setter;

public class ShapeDyer implements Dye {
    @Getter
    @Setter
    private Shape shape;
    @Getter
    @Setter
    private String fillerColor;
    @Getter
    @Setter
    private String borderColor;

    public ShapeDyer() {

    }

    @Override
    public void dye(){
        System.out.printf("%s is dyed in %s color with %s border\n", shape.getName(), fillerColor, borderColor);
    }
}
