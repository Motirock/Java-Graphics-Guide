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

    //Simple constructor
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //Default constructor, with all values as 0 by default (useless rectangle)
    public Rectangle() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    //Simple getters (accessors) and setters (mutators)

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

    //If rectangles overlap, not just touch
    //Based around x and y being corner positions, but in theory should work if they represent center
    public boolean intersects(Rectangle other) {
        double centerX1 = this.x+this.width/2.0;
        double centerY1 = this.y+this.height/2.0;
        double centerX2 = other.x+other.width/2.0;
        double centerY2 = other.y+other.height/2.0;
        if (Math.abs(centerX2-centerX1) > (this.width+other.width)/2.0
         || Math.abs(centerY2-centerY1) > (this.height+other.height)/2.0)
            return false;
        return true;
    }
}
