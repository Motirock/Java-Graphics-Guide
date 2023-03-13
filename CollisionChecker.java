/*
Use this class to stor methods used for checking collisions.
I currently have only one for checking collisions of Rectangles.
*/

package main;

import javafx.scene.shape.Rectangle;

public class CollisionChecker {
    public static boolean checkCollision (Rectangle a, Rectangle b) {
        return a.intersects(b.getBoundsInLocal());
    }
}
