package module8;

import module8.shapes.*;

public class ShapeEditor {

    public static void main(String[] args) {

        Printer printer = new Printer();

        Shape[] shapes = {
                new Circle(),
                new Quad(),
                new Triangle(),
                new Line(),
                new Point(),
                new Ellipse()
        };

        for (Shape shape : shapes) {
            printer.PrintName(shape);
        }

        // For single print use the following code with specified shape
        //printer.PrintName(new Circle());
    }

}
