package homework8;

import lombok.Getter;
import lombok.Setter;

class Rectangle extends Shape {
    private static String SHAPE_TYPE = "two-dimensional";
    @Getter
    @Setter
    private int height;
    @Getter
    @Setter
    private int width;

    public Rectangle(String name, int height, int width) throws InappropriateParameterException {
        super(name, SHAPE_TYPE);
        if (height <= 0 || width <= 0) {
            throw new InappropriateParameterException("Height and width of the rectangle must be positive");
        }
        this.height = height;
        this.width = width;

    }

    @Override
    public void draw() {
        System.out.printf("%s with height %d and width %d is painted\n", name, height, width);
    }

    @Override
    public void dye(String color) {
        System.out.printf("%s is dyed in %s color\n", name, color);
    }

    @Override
    public void clear() {
        System.out.println(name + " is cleared from the canvas");
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", name='" + name + '\'' +
                "} ";
    }
}
