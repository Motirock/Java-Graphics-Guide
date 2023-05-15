# Image Transformations

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

Let's say you want an animation of a ??? spinning. You can do that with the above method in the following way:  
First, let's create a new instance variable of `Game` called `degrees`.  
    
    private int degrees = 0;

Next, let's increase it every second by changing the `update()` method of `Game`.  
    
    //Increments the amount of updates
    updates++;
    //Increases the rotation by 1° every second
    if (updates % 20 == 0)
        degrees++;
    //Resets the rotation to 0 after reaching 360°
    if (degrees % 360 == 0)
        degrees = 0;
        
Because we are changing the image used, we need to upload the file. Drag in this [picture](TEMP) of the ??? into the `res` folder after downloading it.  
Next, update the file path to reflect the change in image. So if you named it `???.png`, you would change the the line loading the image to be:
    
    

If you want to have more image utilities, you can always modify the class, like adding another rotate method that takes radians instead of degrees.
