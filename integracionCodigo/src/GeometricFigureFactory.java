public class GeometricFigureFactory {

    public static final String CODE_CIRCLE = "Circle";
    public static final String CODE_RECTANGLE = "Rectangle";
    public static final String CODE_TRIANGLE = "Triangle";
    public static final String CODE_SQUARE = "Square";

    private static GeometricFigureFactory instance;

    public GeometricFigureFactory() {
    }

    public static GeometricFigureFactory getInstance() {
        if (instance == null) {
            instance = new GeometricFigureFactory();
        }
        return instance;
    }

    public GeometricFigure generateGeometricFigure(String code) throws GeometricFigureFactoryException{
        switch (code) {
            case CODE_CIRCLE:
                return new Circle(2.0);
            case CODE_RECTANGLE:
                return new Rectangle(2.0, 3.0);
            case CODE_TRIANGLE:
                return new Triangle(2.0, 3.0);
            case CODE_SQUARE:
                return new Rectangle(3.0, 3.0);
        }
        throw new GeometricFigureFactoryException("'"+ code + "' is not a valid code");
    }
}
