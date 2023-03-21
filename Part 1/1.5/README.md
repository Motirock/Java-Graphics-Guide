# 1.5 Shapes and Colors

So far, we have seen some basic capabilities of java.awt.Color and java.awt.Graphics2D by drawing a red circle.  
In this part, I will explain more of the fundamentals of these libraries.

### Layering
Imagine you are a painter. If you first paint a red circle, and then you cover the canvas in yellow paint, the red circle will no longer be visible. This is how creating shapes with Graphics2D works.  
For example, try to think what would be shown as a result of this code:
    
    g2.setColor(Color.BLUE);
    g2.fillOval(400, 50, 800, 800);
    g2.setColor(Color.GREEN);
    g2.fillOval(400, 50, 800, 800);
    
If you thought it would show a green circle, you are correct.  
The reason for this is that *first* and blue circle is drawn, and then a green circle is drawn *over* the green circle. It is important to remember that the blue circle is still there, even if you can't see it.  
    
### Shapes

There are many shapes that you can draw with the Graphics2D class.  
The most common to be used is probably fillRect method.  
The fillRect method is used like so:
    
    g2.fillRect(int xPosition, int yPosition, int width, int height)
    
For most shapes (including ovals and rectangles) the x and y parameters refer to the top-left corner of the shape.  
There are manny other methods for drawing shapes which I will not cover here but there a
