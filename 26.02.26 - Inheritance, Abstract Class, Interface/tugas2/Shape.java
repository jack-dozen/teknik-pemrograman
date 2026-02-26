package tugas2;

public class Shape {
    private String color;
    private boolean filled;

    public Shape(){
        color = "green";
        filled = true;
    }

    public Shape(String nc, boolean tf){
        color = nc;
        filled = tf;
    }

    public void setColor(String nc){
        this.color = nc;
    }

    public String getColor(){
        return color;
    }

    public boolean isFilled(){
        return filled;
    }

    public void setFilled(boolean nf){
        this.filled = nf;
    }

    @Override
    public String toString(){
        return "A Shape with color of " + color + " and " + (filled ? "filled" : "Not filled");
    }
}
