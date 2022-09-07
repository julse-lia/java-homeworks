package homework8;

import homework8.InappropriateParameterException;
import homework8.TwoDimensional;
import lombok.Getter;
import lombok.Setter;

public class Trapeze extends TwoDimensional {

    @Getter
    @Setter
    private int upperBase;
    @Getter
    @Setter
    private int lowerBase;
    @Getter
    @Setter
    private int height;

    public Trapeze(String name, int upperBase, int lowerBase, int height) throws InappropriateParameterException {

        super(name);
        if (upperBase <= 0 | lowerBase <= 0 | height <= 0) {
            throw new InappropriateParameterException(
                    "Trapeze lengths of both bases and height must be positive"
            );
        }
        this.upperBase = upperBase;
        this.lowerBase = lowerBase;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Trapeze{" + "upperBase=" + upperBase +
                ", lowerBase=" + lowerBase +
                ", height=" + height +
                ", name='" + name + '\'' + "} ";
    }
}
