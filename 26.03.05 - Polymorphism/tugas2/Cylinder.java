//*****************************************
// Cylinder.java
//
// Represents a cylinder.
//*****************************************
public class Cylinder extends Shape {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height){
        super("Cylinder");
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius * 2 * height;
    }

    @Override
    public String toString(){
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}
