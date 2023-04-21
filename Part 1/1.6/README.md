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
The second parameter is styling options. For example, if you want it to be plain, you put Font.PLAIN
    
### Drawing Text
g2.setFont(new Font("TimesRoman", Font.PLAIN, 80));
g2.setColor(card.getCardColorAsColor());
g2.drawString(card.getNumber()+"", 55+125*i, 825);

