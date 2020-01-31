//Initial code to isolate instance creation
class Gear {
    int chainRing;
    int cog;
    Wheel wheel;

    Gear(int chainVar, int cogVar, int rimVar, double tire) {
        chainRing = chainVar;
        cog = cogVar;
        wheel = new Wheel(rimVar, tire);
    }

    float ratio() {
        return (float)chainRing/cog;
    }

    float gearInches() {
        return  ratio() * wheel.diameter;
    }
}

class Wheel {
    int rim;
    double tire;
    public static final PI = 3.14;

    Wheel(int rimVar, double tireVar) {
        rim = rimVar;
        tire = tireVar;
    }

    double diameter () {
        return (rim + tire * 2);
    }

    double circumference() {
        return diameter() * PI;
    }
}

class Main {

    public static  void main(String[] args) {

        //Wheel wheel = new Wheel(26, 1.5);
        Gear gear1 = new Gear(52, 11, 26, 1.5);
        gearInches1 = gear1.gearInches();
    }
}

//Removing argument oreder dependencies by defining default constructors

class Gear {
    int chainRing;
    int cog;
    Wheel wheel;

    Gear(int chainVar, int cogVar, int rimVar, double tire) {
        chainRing = chainVar;
        cog = cogVar;
        wheel = new Wheel(rimVar, tire);
    }

    Gear() {
        chainRing = 40;
        cog = 11;
    }

    float ratio() {
        return (float)chainRing/cog;
    }

    float gearInches() {
        return  ratio() * wheel.diameter;
    }
}

class Wheel {
    int rim;
    double tire;
    public static final PI = 3.14;

    Wheel(int rimVar, double tireVar) {
        rim = rimVar;
        tire = tireVar;
    }

    Wheel() {
        rim = 26;
        tire = 1.5;
    }

    double diameter () {
        return (rim + tire * 2);
    }

    double circumference() {
        return diameter() * PI;
    }
}

class Main {

    public static  void main(String[] args) {

        //Wheel wheel = new Wheel(26, 1.5);
        Gear gear1 = new Gear(52, 11, 26, 1.5);
        gearInches1 = gear1.gearInches();
    }
}

//Reversing Dependencies

class Gear {
    int chainRing;
    int cog;
    //Wheel wheel;

    Gear(int chainVar, int cogVar) {
        chainRing = chainVar;
        cog = cogVar;
        //wheel = new Wheel(rimVar, tire);
    }

    float ratio() {
        return (float)chainRing/cog;
    }

    float gearInches(double diameter) {
        return  ratio() * diameter;
    }
}

class Wheel {
    int rim;
    double tire;
    Gear gear;
    public static final PI = 3.14;

    Wheel(int rimVar, double tireVar, int chainVar, int cogVar) {
        rim = rimVar;
        tire = tireVar;
        gear = new Gear(chainVar, cogVar);
    }

    double diameter () {
        return (rim + tire * 2);
    }

    double circumference() {
        return diameter() * PI;
    }

    double gearInches() {
        return gear.gearInches(diameter());
    }
}

class Main {

    public static  void main(String[] args) {

        Wheel wheel = new Wheel(26, 1.5);
        //Gear gear1 = new Gear(52, 11, 26, 1.5);
        gearInches1 = wheel.gearInches();
    }
}
