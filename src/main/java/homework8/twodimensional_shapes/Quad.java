package homework8.twodimensional_shapes;

import homework8.InappropriateParameterException;
import homework8.abstractclasses.TwoDimensional;
import lombok.Getter;
import lombok.Setter;

public class Quad extends TwoDimensional {
    @Getter
    @Setter
    private int length;
    @Getter
    @Setter
    private int width;

    public Quad(String name, int length, int width) throws InappropriateParameterException {
        super(name);
        if (length != width | length <= 0 | width <= 0) {
            throw new InappropriateParameterException("Height and width of the quad must be equal and positive");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Quad{" + "length=" + length +
                ", width=" + width +
                ", name='" + name + '\'' + "} ";
    }
}
