/*
Rectangle objects are super useful, so here's a simple class for doing so.
This class is also used by the CollisionChecker class.
Please note that just like graphics, its intended use is based around the top-left corner.
This means a Rectangle created like
    new Rectangle(100, 100, 200, 300)
has its left edge at 100, its top edge at 100, a width of 200, and a height of 300
This would also mean that said rectangle's bottom left corner would be at (300, 400)

In theory, you could have x and y represent the center coordinates, but then using Graphics2D would be a bit more complicated
*/

package main;

public class Rectangle {
    public double x, y, width, height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean intersects(Rectangle other) {
        return x < other.x + other.width && x + width > other.x && y < other.y + other.height && y + height > other.y;
    }
}
