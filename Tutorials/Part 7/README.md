# Part 7: Drawing Images

Whenever you use an application, you are sure to notice that images are involved.  
Even if the images can be made with shapes, it is generally best to use images.  

### Getting an Image
Lucky for you, I already have some files you can use.  
To get a simple, pixelated image of a chest, click on this [link](https://github.com/Motirock/An-Introduction-To-Java-Graphics/blob/main/Resources/Images/chest.png) and press the download icon on the right.  
Once it is downloaded, name it chest.png if it is not named so already.  

### Resources Folder

For our project, we will need a place to store assets. To do this, we will create a resources folder. 
In the folder that shares the game and main folder (this is likely the `src` folder), create a new `res` folder (the name matters).  
Next, drag the `chest.png` image into the `res` folder.  

### Importing Necessary Classes

To help track an image's position and dimensions in one object, we will use the `main.Rectangle` class found in the `main` package.

    import main.Rectangle;

To store an image, we will use the `java.awt.image.BufferedImage` class.  It is imported like so:  
    
    import java.awt.image.BufferedImage;
    
To download the image, we will use the `javax.imageio.ImageIO` library.  

    import javax.imageio.ImageIO;
    
Finally, to catch errors while loading the image, we will use the `java.io.IOException` library.  

    import java.io.IOException;

### Loading an Image

First, let's create an `BufferedImage` instance variable of `Game` that will store our image.  
    
    //A BufferedImage which does not store anything yet
    public BufferedImage image = null;
    
Now, let's load the chest image to `image` from the `res` folder. These statements should be run inside the `Game` constructor. I implemented a try-catch statement in case it fails to load, like if the file path specified was wrong.  
    
    //Loads the chest image from the res folder to image
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/chest.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    
### Creating a `Rectangle` Object to Help

Remember how we drew shapes with the `Graphics2D` library? We can do the same for images!  
Because images are rectangles, it can be very useful to keep track of them using `Rectangle` objects that store the x and y positions and the dimensions.
First, create a `Rectangle` instance variable in the `Game` class:

    //Position and dimensions of the image stored in a Rectangle objects
    //Note that by default it will have a position of (0, 0) and both its width and height will be 0
    private Rectangle rect;
        
Then, in the `Game` constructor, let's create some variables to make it clear the intended starting dimensions and position of the image rectangle:
    
    //Creating rectangle to store image position and dimensions
    int x = 350;    //Top left corner x
    int y = 100;    //Top left corner y
    int w = 800;    //Image width
    int h = 800;    //Image height

Finally, we can create the rectangle itself, now with the proper attributes:

    rect = new Rectangle(x, y, w, h);

### Making the Image Change

To demonstrate how an image's position can be changed, let's try changing them in the `update()` method.  
        
    //Keeps track of total times update() was called
    updates++;
    
    //The image moves right and then left, switching directions after the image moves over 100 units
        if (updates % 2000 < 1000)
            rect.x += 0.1;  //Moving right
        else
            rect.x -= 0.1;  //Moving left
    
Finally, we will draw the image in the `draw(Graphics2D)` method.  
I will demonstrate two methods.  

##### Method 1: Drawing the Whole Image
To draw the image, call the `Graphics2D.drawImage` method with the parameters `(Image image, int x, int y, int width, int height, ImageObserver observer)`.  
For the `ImageObserver` parameter, we will put it as null. I don't use it, but if you want to learn more about the `java.awt.image.ImageObserver` interface, [here's the API.](https://docs.oracle.com/javase/8/docs/api/java/awt/image/ImageObserver.html)  
Here is the simplest way to draw the image using our rectangle, drawing the entirety of the image:  
    
     g2.drawImage(image, (int) (rect.x*GS), (int) (rect.y*GS), (int) (rect.width*GS), (int) (rect.height*GS), null);

Note that because we are using the non-integer GS to scale the graphics, we have to cast the parameters back to integers for the method call to work.
     
##### Method 2: Drawing a Part of the Image:
You may choose to use "spritesheets," where multiple images used are kept as part of the same file. This can be helpful if there are multiple frames for an animated image.  
We will use the `Graphics2D.drawImage` method with the different parameters `(Image image, int destinationX1, int destinationY1, int destinationX2, int destinationY2, int sourceX1, int sourceY1, int sourceX2, int sourceY2, ImageObserver observer)`.  
The *destination* variables define the top left and bottom right locations of the *destination* rectangle (where it is drawn). The *source* variables define the top left and bottom right locations of the *source* rectangle (where in the file the drawn image is taken from). The *source* rectangle depends on the dimensions of your file.  
Below is a code sample using this method and the variables we previously defined:  
    
    //Setting variables to get the right part of the source file
    int sourceX = 0;    //Top left corner y
    int sourceY = 0;    //Top left corner x
    int sourceW = 20;   //Width for whole image
    int sourceH = 20;   //Height for whole image
    g2.drawImage(image, //Image
        (int) (rect.x*GS), (int) (rect.y*GS), (int) ((rect.x+rect.width)*GS), (int) ((rect.y+rect.height)*GS),  //Destination rectangle, with the last two parameters forming the bottom-left point
        sourceX, sourceY, sourceX+sourceW, sourceY+sourceH, //Source Rectangle
        null);  //ImageObserver
        
   
To learn more about `BufferedImage` class, you can visit the [API.](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html)

[Part 8: Image Transformations](https://github.com/Motirock/An-Introduction-To-Java-Graphics/tree/main/Tutorials/Part%208)
