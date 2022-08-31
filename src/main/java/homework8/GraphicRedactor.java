package homework8;

public class GraphicRedactor {
    public static void main(String[] args) {
        Shape circle;
        Shape quad;
        Shape triangle;
        Shape rectangle;
        Shape trapeze;

        try {
            circle = new Circle("circle1", 0, 0, 5);
            quad = new Quad("quad1", 10, 10);
            triangle = new Triangle("triangle1", 3, 4, 5);
            rectangle = new Rectangle("rectangle1", 8, 6);
            trapeze = new Trapeze("trapeze1", 5, 10, 8);
        } catch (InappropriateParameterException e) {
            System.out.println(e.getMessage());
            return;
        }

        getShapesName(circle, quad, triangle, rectangle, trapeze);

        System.out.println("---------------------");

        drawShapes(circle, quad, triangle, rectangle, trapeze);

        System.out.println("---------------------");
        System.out.println(circle.dye());
        dyeShapes("blue", quad, triangle);
        dyeShapes("green", rectangle, trapeze);

        System.out.println("---------------------");

        clearShapes(circle, quad, triangle, rectangle, trapeze);

        System.out.println("---------------------");

    }

    public static void getShapesName(Shape... shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.getName());
        }
    }

    public static void drawShapes(Shape... shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void dyeShapes(String color, Shape... shapes) {
        for (Shape shape : shapes) {
            shape.dye(color);
        }
    }

    public static void clearShapes(Shape... shapes) {
        for (Shape shape : shapes) {
            shape.clear();
        }
    }
}
