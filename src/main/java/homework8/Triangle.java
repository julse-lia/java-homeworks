package homework8;

import homework8.InappropriateParameterException;
import homework8.TwoDimensional;
import lombok.Getter;
import lombok.Setter;

public class Triangle extends TwoDimensional {
    @Getter
    @Setter
    private int firstSide;
    @Getter
    @Setter
    private int secondSide;
    @Getter
    @Setter
    private int base;
    @Getter
    @Setter
    private int height;

    public Triangle(String name, int firstSide, int secondSide, int base)
            throws InappropriateParameterException {

        super(name);
        if (firstSide <= 0 | secondSide <= 0 | base <= 0) {
            throw new InappropriateParameterException("Triangle lengths of sides must be positive");
        }
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.base = base;
    }

    @Override
    public String toString() {
        return "Triangle{" + "firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", base=" + base +
                ", height=" + height +
                ", name='" + name + '\'' + "} ";
    }
}
