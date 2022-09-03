package homework8;


import homework8.abstractclasses.Shape;
import homework8.shapeinterface.Clear;

public class ShapeCleaner implements Clear {

    @Override
    public void clear(Shape shape){
        System.out.println(shape.getName() + " is cleared from the canvas");
    }
}
