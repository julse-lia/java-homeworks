package homework8;

import homework8.shapeinterface.Clear;
import homework8.shapeinterface.Draw;
import homework8.shapeinterface.Dye;

abstract class Shape implements Draw, Clear, Dye {
    protected String name;
    protected String type;

    public Shape(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }


}
