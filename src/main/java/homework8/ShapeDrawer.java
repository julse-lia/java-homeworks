package homework8;

import homework8.abstractclasses.Shape;
import homework8.shapeinterface.Draw;

public class ShapeDrawer implements Draw {
    @Override
    public void draw(Shape shape) {
        System.out.println(shape + "is painted");
    }
}
