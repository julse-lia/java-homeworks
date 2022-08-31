package homework8;

import lombok.Getter;
import lombok.Setter;

class Circle extends Shape {

    private static String SHAPE_TYPE = "two-dimensional";
    @Getter
    @Setter
    private int radius;
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;

    public Circle(String name, int x, int y, int radius) throws InappropriateParameterException {
        super(name, SHAPE_TYPE);
        if (radius <= 0) {
            throw new InappropriateParameterException("Radius of the circle "
                    + "must be positive");
        }

        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.printf("%s with center coordinates (%d; %d) and radius %d " +
                "is painted\n", name, x, y, radius);
    }

    @Override
    public void dye(String color) {
        System.out.printf("%s is dyed in %s color\n", name, color);
    }

    @Override
    public String dye() {
        return this.name + super.dye();
    }

    @Override
    public void clear() {
        System.out.println(name + " is cleared from the canvas");
    }

    @Override
    public String toString() {
        return "Circle{" + 
                "radius=" + radius + ", " +
                "x=" + x + "," +
                " y=" + y + ", "
                + "name='" + name + '\'' + "} ";
    }


}
