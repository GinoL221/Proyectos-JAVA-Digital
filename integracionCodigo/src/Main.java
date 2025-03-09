public class Main {
    public static void main(String[] args) {
        CompleteObject completeObject = new CompleteObject();

        completeObject.addGeometricFigure(GeometricFigureFactory.CODE_CIRCLE);
        completeObject.addGeometricFigure(GeometricFigureFactory.CODE_RECTANGLE);
        completeObject.addGeometricFigure(GeometricFigureFactory.CODE_TRIANGLE);
        completeObject.addGeometricFigure(GeometricFigureFactory.CODE_SQUARE);

        System.out.println(completeObject.calculateTotalArea());
    }
}