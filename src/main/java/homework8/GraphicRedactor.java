package homework8;

public class GraphicRedactor {
    public static void main(String[] args) {
        Shape circle;
        Shape quad;
        Shape triangle;
        Shape rectangle;
        Shape trapeze;

        Shape cube;
        Shape cylinder;

        Shape circleRadial;

        try {
            circle = new Circle("circle1", 0, 0, 5);
            quad = new Quad("quad1", 10, 10);
            triangle = new Triangle("triangle1", 3, 4, 5);
            rectangle = new Rectangle("rectangle1", 8, 6);
            trapeze = new Trapeze("trapeze1", 5, 10, 8);

            cube = new Cube("cube1", 8, 8, 8);
            cylinder = new Cylinder("cylinder1", 4, 10);

            circleRadial = new RadialCircle("circle2", 45, 10);

        } catch (InappropriateParameterException e) {
            System.out.println(e.getMessage());
            return;
        }
        ShapeDrawer shapeDrawer = new ShapeDrawer();
        ShapeDyer shapeDyer = new ShapeDyer();
        ShapeCleaner shapeCleaner = new ShapeCleaner();

        getShapesName(circle, quad, triangle, rectangle, trapeze, cube, cylinder, circleRadial);

        System.out.println("---------------------");

        drawShapes(shapeDrawer, circle, quad, triangle, rectangle, trapeze, cube, cylinder, circleRadial);

        System.out.println("---------------------");

        dyeShapes(shapeDyer, "blue", "red", quad, triangle);

        dyeShapes(shapeDyer, "yellow", "green", rectangle, trapeze, cube);

        System.out.println("---------------------");

        clearShapes(shapeCleaner, circle, quad, triangle, rectangle, trapeze, cube, cylinder, circleRadial);

        System.out.println("---------------------");

        System.out.println("Rectangle is " + rectangle.getType());
        System.out.println("Cube is " + cube.getType());
    }

    public static void getShapesName(Shape... shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.getName());
        }
    }

    public static void drawShapes(ShapeDrawer shapeDrawer, Shape... shapes) {
        for (Shape shape : shapes) {
            shapeDrawer.draw(shape);
        }
    }

    public static void dyeShapes(ShapeDyer shapeDyer, String fillerColor, String borderColor, Shape... shapes) {
        for (Shape shape : shapes) {
            shapeDyer.setFillerColor(fillerColor);
            shapeDyer.setBorderColor(borderColor);
            shapeDyer.dye(shape);
        }
    }

    public static void clearShapes(ShapeCleaner shapeCleaner, Shape... shapes) {
        for (Shape shape : shapes) {
            shapeCleaner.clear(shape);
        }
    }
}
