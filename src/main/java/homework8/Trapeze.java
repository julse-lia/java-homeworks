package homework8;

import lombok.Getter;
import lombok.Setter;

class Trapeze extends Shape {
    private static String SHAPE_TYPE = "two-dimensional";
    @Getter
    @Setter
    private int upperBase;
    @Getter
    @Setter
    private int lowerBase;
    @Getter
    @Setter
    private int height;

    public Trapeze(String name, int upperBase, int lowerBase, int height)
            throws InappropriateParameterException {

        super(name, SHAPE_TYPE);
        if (upperBase <= 0 || lowerBase <= 0 || height <= 0) {
            throw new InappropriateParameterException(
                    "Trapeze lengths of both bases and height must be positive"
            );
        }
        this.upperBase = upperBase;
        this.lowerBase = lowerBase;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.printf(
                "%s with upper base %d, lower base %d and height %d is painted\n",
                name, upperBase, lowerBase, height
        );
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
        return "Trapeze{" +
                "upperBase=" + upperBase +
                ", lowerBase=" + lowerBase +
                ", height=" + height +
                ", name='" + name + '\'' +
                "} ";
    }
}
