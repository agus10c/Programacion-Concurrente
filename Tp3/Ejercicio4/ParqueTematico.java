package Tp3.Ejercicio4;

public class ParqueTematico {
    public static void main(String[] args) {
        Visitante v1, v2, v3;
        AreaParqueTematico[] colAreas = new AreaParqueTematico[4];
        colAreas[0] = new AreaParqueTematico("area 1", 15);
        colAreas[1] = new AreaParqueTematico("area 2", 10);
        colAreas[2] = new AreaParqueTematico("area 3", 7);
        colAreas[3] = new AreaParqueTematico("area 4", 7);
        v1 = new Visitante("visitante1", colAreas);
        v2 = new Visitante("visitante2", colAreas);
        v3 = new Visitante("visitante3", colAreas);
        v1.start();
        v2.start();
        v3.start();
    }
}
