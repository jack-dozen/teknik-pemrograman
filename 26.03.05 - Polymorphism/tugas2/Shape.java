public abstract class Shape {
    private final String ShapeName;

    public Shape(String ShapeName){
        this.ShapeName = ShapeName;
    }

    public abstract double area();

    @Override
    public String toString(){
        return ShapeName;
    }
}
