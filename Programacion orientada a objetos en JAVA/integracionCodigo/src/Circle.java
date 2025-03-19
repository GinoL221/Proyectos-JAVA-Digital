public class Circle implements GeometricFigure{

    public Double radius;

    public Circle(Double ratio){
        this.radius = ratio;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
