public class Geometry {
    public static void main(String[] args) {
        PrintSquareArea(7.);
        PrintSquareArea(.5);
        PrintSquareArea(.3);
        PrinnRectangelArea(3.0,5.);
        PrinnRectangelArea(9.,4.);
        }

    private static void PrinnRectangelArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами "+a+" "+ " и "+ b+" = "+ rectangleArea(a, b));
    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }

    static void PrintSquareArea(double a)
    {
        System.out.println("Площадь квадрата со стороной "+a+" = "+ squareArea(a));
    }

    private static double squareArea(double a) {
        return a * a;
    }
}
