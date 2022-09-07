package homework8;

import lombok.Getter;
import lombok.Setter;

public class RadialCircle extends Circle {
    @Getter
    @Setter
    private int angle;

    public RadialCircle(String name, int angle, int radius) throws InappropriateParameterException {
        super(name);
        if (radius <= 0 | angle < 0 | angle > 360) {
            throw new InappropriateParameterException("Radius of the circle must be positive and" +
                    " angle must be between 0 and 360 degree");
        }
        this.angle = angle;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "RadialCircle{" +
                "angle=" + angle +
                ", radius=" + radius +
                ", name='" + name + '\'' + "} ";
    }
}
