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
    

### Steps
