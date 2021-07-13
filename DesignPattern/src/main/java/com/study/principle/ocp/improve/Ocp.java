package com.study.principle.ocp.improve;

/**
 * The type Ocp.
 */
public class Ocp {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new OtherGraphic());
    }

}

/**
 * The type Graphic editor.
 */
class GraphicEditor {
    /**
     * Draw shape.
     *接收Shape对象，然后根据type，来绘制不同的图形
     * @param s the s
     */
    public void drawShape(Shape s) {
        s.draw();
    }


}

/**
 * Shape类，基类
 */
//
abstract class Shape {
    /**
     * The M type.
     */
    int m_type;

    /**
     * Draw.
     */
    public abstract void draw();
}

/**
 * The type Rectangle.
 */
class Rectangle extends Shape {
    /**
     * Instantiates a new Rectangle.
     */
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

/**
 * The type Circle.
 */
class Circle extends Shape {
    /**
     * Instantiates a new Circle.
     */
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

/**
 * The type Triangle.
 */
class Triangle extends Shape {
    /**
     * Instantiates a new Triangle.
     */
    Triangle() {
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}

/**
 * The type Other graphic.
 */
//新增一个图形
class OtherGraphic extends Shape {
    /**
     * Instantiates a new Other graphic.
     */
    OtherGraphic() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
        System.out.println("绘制其它图形");
    }
}