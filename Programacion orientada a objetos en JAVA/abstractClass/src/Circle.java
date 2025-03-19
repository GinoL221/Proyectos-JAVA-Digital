public class Circle extends GeometricFigure{
    private Double diameter;

    public Circle(Double diameter) {
        super(0);
        this.diameter = diameter;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(diameter / 2, 2);
    }
}
