# 1.6 Creating Text

We can always create text with shapes, but it is much easier to use built in methods.

### Setting Font

First, import java.awt.Font.  

    import java.awt.Font;

Please note that, like other draw methods, drawString's color depends on what you set it to previously.  
This means that we will first have to set the color (red in this case):
    
    g2.setColor(Color.RED);
    
Now, we can set the font.  
The first paramater is the name of the file storing the font you want to use. If your code does not work, it may because you don't have it on your computer. 
The second parameter is styling options. For example, if you want it to be plain, you put Font.PLAIN. If you want to have several different styles at once, like italic and bold, you must create a union between the two using the '|' operator.  If this fails, it will resort to using Font.PLAIN.  
The following code sets the Font used by g2 to 80 point Times Roman that is bold and italic.  

    g2.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 80));
    
### Drawing Text
    
Now, we can draw the String.  

    String str = "Hello!";
    int xCoordinate = 400;
    int yCoordinate = 400;
    g2.drawString(str, xCoordinate, yCoordinate);
    
#### Learning More

To learn more about the libraries I used, you can check out the [java.awt.Font](https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html) and [java.awt.Font API](https://docs.oracle.com/javase/7/docs/api/java/awt/Font.html).

[1.7](https://github.com/Motirock/An-Introduction-To-Java-Graphics/edit/main/Part%201/1.7)


