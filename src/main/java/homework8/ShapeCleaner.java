package homework8;


public class ShapeCleaner implements Clear {

    @Override
    public void clear(Shape shape){
        System.out.println(shape.getName() + " is cleared from the canvas");
    }
}
