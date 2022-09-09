package homework8.twodimensional_shapes;

import homework8.Shape;

public abstract class TwoDimensional extends Shape {

    private static final String SHAPE_TYPE = "two-dimensional";

    public TwoDimensional(String name) {
        super(name);
    }

    public final String getType(){
        return SHAPE_TYPE;
    }

}
