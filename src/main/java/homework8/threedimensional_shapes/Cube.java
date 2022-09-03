package homework8.threedimensional_shapes;

import homework8.InappropriateParameterException;
import homework8.abstractclasses.ThreeDimensional;
import lombok.Getter;
import lombok.Setter;

public class Cube extends ThreeDimensional {
    @Getter
    @Setter
    private int height;
    @Getter
    @Setter
    private int width;
    @Getter
    @Setter
    private int length;

    public Cube(String name, int height, int width, int length) throws InappropriateParameterException {
        super(name);
        if (((height != width) & (height != length)) | height <= 0 | width <= 0 | length <= 0) {
            throw new InappropriateParameterException("Height, width and length of the cube must be equal and positive");
        }
        this.height = height;
        this.width = width;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cube{" + "height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", name='" + name + '\'' +
                "} ";
    }
}
