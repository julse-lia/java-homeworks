package homework8;

import lombok.Getter;
import lombok.Setter;

public class ShapeDyer implements Dye {
    @Getter
    @Setter
    private String fillerColor;
    @Getter
    @Setter
    private String borderColor;

    public ShapeDyer() {

    }

    @Override
    public void dye(Shape shape){
        System.out.printf("%s is dyed in %s color with %s border\n", shape.getName(), fillerColor, borderColor);
    }
}
