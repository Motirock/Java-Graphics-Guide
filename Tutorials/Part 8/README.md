# Part 8: Image Transformations

So far, the images that we have drawn are aligned with the edges of the window. But if we wanted to rotate it? This tutorial demonstrates how to rotate and draw an image in java.  

### Rotating an Image

This tutorial is a bit different, because we will first look at a class and method that I wrote.  
The class we'll being using is the `ImageUtils` class located inside the `ImageUtils.java` file in the `main` folder/package.  

Inside, is the following method:  

    //Rotates and draws an image about a point
    public static void drawRotatedImage(Graphics2D g2, BufferedImage image, int degrees, int x, int y, int width, int height, int pivotX, int pivotY, double GS) {
        //Rotates
        g2.rotate(Math.toRadians(degrees), (int) (pivotX*GS), (int) (pivotY*GS));
        //Draws
        g2.drawImage(image, (int) (x*GS), (int) (y*GS), (int) (width*GS), (int) (height*GS), null);
        //Rotates back to the normal orientation
        g2.rotate(Math.toRadians(-degrees), (int) (pivotX*GS), (int) (pivotY*GS));
    }
    
This method takes care of bothing rotating and drawing the image.  
`g2` is the same `g2` in our draw methods.  
`image` is the image that we want to draw. 
Just like in our other methods, `x`, `y`, `width`, and `height` refer to the position and dimensions of the image *before* being rotated.  
`degrees`, `pivotX`, and `pivotY` are all more complicated.  
`pivotX` and `pivotY` is the position which the image is rotated around.  If you want to just rotate the image, like a top would spin, make the pivot point be the center of the image's rectangle.  
The way that things are rotated might not be intuitive.  
Rotations work like in polar the polar coordinate system, where 0° is directly right, and as the rotation amount (by default in radians) increases, it rotates *counterclockwise*.  
To help visualize you can use a [graphing calculator](https://www.desmos.com/calculator) with polar graphing.  
For example, in the graph below the red point has been rotated 0°, the blue point has been rotated 45°, and the black point has been rotated 450°.  
![Polar Graph](/Assets/polar_graph.png "Polar Graph")

### Use in a Program

Let's say you want an animation of anv image spinning. You can do that with the above method in the following way:  
First, let's create a new instance variable of `Game` called `degrees`.  
    
    private int degrees = 0;
    
Also, to make an image spin around its center, we need it to pivot around its center.

    private int centerX = x+w/2;
    private int centerY = y+h/2;

Next, let's increase the rotation of the image every second by changing the `update()` method of `Game`.  
    
    //Increments the amount of updates
    updates++;
    //Increases the rotation by 1° every second
    if (updates % 20 == 0)
        degrees++;
    //Resets the rotation to 0 after reaching 360°
    if (degrees % 360 == 0)
        degrees = 0;
        
Bif you want to change the image used, you need to upload the file. For my example, I'll use the same chest image, which you likely download in [1.7](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Part%201/1.7).  
Next, if you want to change the image used, update the file path to reflect the change in image. So if you named the image `apple.png`, you would change the the line loading the image to be:
    
    image = ImageIO.read(getClass().getResourceAsStream("/res/apple.png"));
    
Now, we will have to modify our `draw(Graphics2D, double)` method of `Game` to rotate the image.  

    ImageUtils.drawRotatedImage(g2, image, degrees, x, y, w, h, centerX, centerY, GS);

### A Note on "Graphics Scaling"

If you have looked through my code, you may notice the variable `GS`. I use this to keep track of how large the graphics are, relative to 1600x900. So if I want my window to be 2400x1350, `GS` would become 1.5 (this is relying on the fact that the ratio is constant). Then, I multiply the position and dimensions by this, so that the graphics scale correctly.  

If you want to have more image utilities, you can always modify the class, like adding another rotate method that takes radians instead of degrees.

### Other Transformations

I only have one image transformation included. If you want to include others, you can research and implement them yourself. Generally, if you can think of the image transformation, there is already a method to do it.  

[Part 9: Sound](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Tutorials/Part%209)
