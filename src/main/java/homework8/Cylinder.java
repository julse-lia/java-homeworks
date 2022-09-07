package homework8;

import homework8.InappropriateParameterException;
import homework8.ThreeDimensional;
import lombok.Getter;
import lombok.Setter;

public class Cylinder extends ThreeDimensional {
    @Getter
    @Setter
    private int radius;
    @Getter
    @Setter
    private int height;
    @Getter
    private int angle;

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public Cylinder(String name, int height, int radius) throws InappropriateParameterException {
        super(name);
        if (radius <= 0 | height <= 0) {
            throw new InappropriateParameterException("Height and radius of the cylinder base"
                    + "must be positive");
        }

        this.radius = radius;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" + "radius=" + radius +
                ", height=" + height +
                ", angle=" + angle +
                ", name='" + name + '\'' +
                "} ";
    }
}
