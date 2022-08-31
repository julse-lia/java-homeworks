package homework8;

import lombok.Getter;
import lombok.Setter;

class Triangle extends Shape {
    private static String SHAPE_TYPE = "two-dimensional";
    @Getter
    @Setter
    private int firstSide;
    @Getter
    @Setter
    private int secondLeg;
    @Getter
    @Setter
    private int base;
    @Getter
    @Setter
    private int height;

    public Triangle(String name, int firstSide, int secondSide, int base)
            throws InappropriateParameterException {

        super(name, SHAPE_TYPE);
        if (firstSide <= 0 || secondSide <= 0 || base <= 0) {
            throw new InappropriateParameterException("Triangle lengths of sides must be positive");
        }
        this.firstSide = firstSide;
        this.secondLeg = secondSide;
        this.base = base;
    }

    @Override
    public void draw() {
        System.out.printf("%s with first side %d, second side %d and base %d is painted\n",
                name, firstSide, secondLeg, base);
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
        return "Triangle{" +
                "firstLeg=" + firstSide +
                ", secondLeg=" + secondLeg +
                ", base=" + base +
                ", height=" + height +
                ", name='" + name + '\'' +
                "} ";
    }
}
