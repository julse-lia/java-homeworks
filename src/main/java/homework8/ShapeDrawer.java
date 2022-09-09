package homework8;

public class ShapeDrawer implements Draw {
    @Override
    public void draw(Shape shape) {
        System.out.println(shape + "is painted");
    }
}
