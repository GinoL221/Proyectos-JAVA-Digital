import java.util.ArrayList;
import java.util.List;

public class GeometricFigureComposite implements GeometricFigure{

    private List<GeometricFigure> figureList;

    public GeometricFigureComposite() {
        figureList = new ArrayList<>();
    }

    public void addGeometricFigure(GeometricFigure figure){
        figureList.add(figure);
    }

    @Override
    public Double calculateArea() {
        Double finalArea = 0.0;
        for(GeometricFigure geometricFigure : figureList){
            finalArea += geometricFigure.calculateArea();
        }
        return finalArea;
    }
}
