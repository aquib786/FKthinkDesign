//Initial Definition of the gear class

class Gear {
    int chainRing;
    int cog;
    int rim;
    double tire;

    Gear(int chainVar, int cogVar, int rimVar, double tireVar) {
        chainRing = chainVar;
        cog = cogVar;
        rim = rimVar;
        tire = tireVar;
    }

    float ratio() {
        return (float)chainRing/cog;
    }

    float gearInches() {
        return  ratio() * (rim + (tire*2));
    }

    public static  void main(String[] args) {
        Gear gear1 = new Gear(52, 11, 26, 1.5);
        gearInches1 = gear1.gearInches();
    }
}

//Final Definition of the Gear class after refactoring

class Gear {
    int chainRing;
    int cog;
    Wheel wheel;

    Gear(int chainVar, int cogVar, Wheel wheelVar) {
        chainRing = chainVar;
        cog = cogVar;
        wheel = wheelVar;
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

        Wheel wheel = new Wheel(26, 1.5);
        Gear gear1 = new Gear(52, 11, wheel);
        gearInches1 = gear1.gearInches();
    }
}

