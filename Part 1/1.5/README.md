# 1.5 Shapes and Colors

So far, we have seen some basic capabilities of java.awt.Color and java.awt.Graphics2D by drawing a red circle.  
In this part, I will explain more of the fundamentals of these libraries.

### Colors

When we set a color, there is two ways to do this. First we will have to import java.awt.Color, like so.

    import java.awt.Color;
   
The Color class is a relatively simple class used for color, as you probably guessed.  
The first way to get a color is by using already created colors within the Color class.
We can access them like so:
    
    Color a = Color.red;    //Creates a Color called "a" that is red
    Color b = Color.RED;    //Creates a Color called "b" that is red
    
A more adaptable way is by creating a new Color from RGB values.  
We can also have an alpha value at the end, which controls opacity.  
To specify a color, we use either integers between 0 and 255 (inclusive) or floats between 0.0 and 1.0 (inclusive).  
The following code is an example of *four* different ways to get the same shade of red:

    Color a = new Color(255, 0, 0);             //Red with three integers: r, g, and b
    Color a = new Color(1.0, 0.0, 0.0);         //Red with three floats: r, g, and b
    Color a = new Color(255, 0, 0, 255);        //Red with four integers: r, g, b, and a (opaque)
    Color a = new Color(1.0, 0.0, 0.0, 0.5);    //Red with four floats: r, g, b, and a (translucent)

### Layering
Imagine you are a painter. If you first paint a red circle, and then you cover the canvas in yellow paint, the red circle will no longer be visible. This is how creating shapes with Graphics2D works.  
For example, try to think what would be shown as a result of this code:
    
    g2.setColor(Color.BLUE);
    g2.fillOval(400, 50, 800, 800);
    g2.setColor(Color.GREEN);
    g2.fillOval(400, 50, 800, 800);
    
If you thought it would show a green circle, you are correct.  
The reason for this is that *first* and blue circle is drawn, and then a green circle is drawn *over* the green circle. It is important to remember that the blue circle is still there, even if we can't see it.  
    
### Shapes

There are many shapes that we can draw with the Graphics2D class.  
The most common to be used is probably fillRect method.  
The fillRect method is used like so:
    
    g2.fillRect(int xPosition, int yPosition, int width, int height)
    
For most shapes (including ovals and rectangles) the x and y parameters refer to the top-left corner of the shape.  
There are manny other methods for drawing shapes which I will not cover here, but we can use the API: [java.awt.Graphics2D API](https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html)

[1.6](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Part%201/1.6)
