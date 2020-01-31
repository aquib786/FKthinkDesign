//Example of a bad code with multiple embedded types in Bicycle class
class Bicycle {
    String style;
    char size;
    String tapeColor;
    String frontShock;
    String rearShock;

    Bicycle(String styleVar, char sizeVar, String ... var) {
        style = styleVar;
        size = sizeVar;
        if (var.length == 3) {
            tapeColor = var[0];
            frontShock = var[1];
            rearShock = var[2];
        }
        else if (var.length == 2) {
            tapeColor = var[0];
            frontShock = var[1];
            //rearShock = rearShockVar;
        }
        else if (var.length == 1) {
            tapeColor = var[0];
            //frontShock = frontShockVar;
            //rearShock = rearShockVar;
        }
    }

    void spares() {
        if (style.equals("road")) {
            System.out.println("chain : 11-Speed " + "Tire Size : 23 "+tapeColor);
        }
        else {
            System.out.println("chain : 11-Speed " + "Tire Size : 2.1 "+frontShock);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle("mountain", 'S', "Manitou", "Fox");
        bicycle.spares();
        Bicycle bicycle1 = new Bicycle("road", 'M', "Red");
        bicycle1.spares();
    }
}

//Inheritance

class MountainBike extends Bicycle {
    String frontShock;
    String rearShock;

    MountainBike(String frontShockVar, String rearShockVar) {
        frontShock = frontShockVar;
        rearShock = rearShockVar;
    }

    void spares() {
        super.spares();
    }
}

//Using Template method pattern

class Bicycle {
    char size;
    String chain;
    String tireSize;

    Bicycle(char sizeVar, String ... var) {
        size = sizeVar;
        if (var.length == 2) {
            chain = var[0];
            tireSize = var[1];
        }
        else if (var.length == 1) {
            defaultChain();
            tireSize = var[0];
        }
    }

    void defaultChain() {
        chain = "11-speed";
    }
}

class MountainBike extends Bicycle {

    void defaultTireSize() {
        tireSize = "23";
    }
}

class RoadBike extends Bicycle {
    void defaultTireSize() {
        tireSize = "2.1";
    }
}

//Decoupling subclasses using hook messages and defining Bicycle as abstract class

abstract class Bicycle {
    char size;
    String chain;
    String tireSize;

    Bicycle(char sizeVar, String ... var) {
        size = sizeVar;
        if (var.length == 2) {
            chain = var[0];
            tireSize = var[1];
        }
        else if (var.length == 1) {
            defaultChain();
            tireSize = var[0];
        }
    }

    void defaultChain() {
        chain = "11-speed";
    }

    void spares () {
        System.out.println(chain + " " + tireSize);
        localSpares();
    }

    abstract void defaultTireSize();
    abstract void localSpares();

    void postInitialize(String ... var) {

    }
}

class MountainBike extends Bicycle {

    String frontShock;
    String rearShock;

    void defaultTireSize() {
        tireSize = "23";
    }

    void postInitialize(String ... var) {
        if (var.length == 2) {
            frontShock = var[0];
            rearShock = var[1];
        }
        else {
            frontShock = var[0];
        }
    }

    void localSpares() {
        System.out.println(frontShock);
    }
}

class RoadBike extends Bicycle {

    String tapeColor;

    void defaultTireSize() {
        tireSize = "2.1";
    }

    void postInitialize(String var) {
        tapeColor = var;
    }

    void localSpares() {
        System.out.println(tapeColor);
    }
}
