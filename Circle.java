

public class Circle extends Figure {
    
    private final double radius;
    
    public Circle(String name, double radius) {
	super(name);
        this.radius = radius;
    }
    
    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }
    
    public double getRadius() {
        return radius;
    }
}