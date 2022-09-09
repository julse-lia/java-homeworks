package homework8.threedimensional_shapes;

import homework8.Shape;

public abstract class ThreeDimensional extends Shape {

    private static final String SHAPE_TYPE = "three-dimensional";

    public ThreeDimensional(String name) {
        super(name);
    }

    public final String getType() {
        return SHAPE_TYPE;
    }
}
