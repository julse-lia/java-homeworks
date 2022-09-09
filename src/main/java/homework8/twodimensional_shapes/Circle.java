package homework8.twodimensional_shapes;

import homework8.InappropriateParameterException;
import lombok.Getter;
import lombok.Setter;

public class Circle extends TwoDimensional {

    @Getter
    @Setter
    protected int radius;
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;

    public Circle(String name, int x, int y, int radius) throws InappropriateParameterException {
        super(name);
        if (radius <= 0) {
            throw new InappropriateParameterException("Radius of the circle "
                    + "must be positive");
        }

        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public Circle(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' + "} ";
    }
}
