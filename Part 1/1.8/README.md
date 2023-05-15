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
To help visualize let's use a [graphing calculator]().  
    
    
