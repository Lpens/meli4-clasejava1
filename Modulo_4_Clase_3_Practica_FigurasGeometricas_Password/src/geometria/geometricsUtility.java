package geometria;

public class geometricsUtility {

    public static double areaPromedio(FiguraGeometrica[] fArr)
    {
        double sumArea = 0;
        for(FiguraGeometrica f : fArr)
        {
            sumArea += f.area();
        }
        return sumArea/fArr.length;
    }
}
