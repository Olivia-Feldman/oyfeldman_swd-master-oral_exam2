

import java.awt.*;



/**
 * @author Olivia
 * this class uses multithreading to allow a user to watch a planet orbit a star
 * multiple planets may be added (up to 8 per star)
 * and 8 moon can orbit a planet which is orbiting a star
 */
 public class Orbiting implements Runnable {
    /**
     * variable used to store the x coordinate position
     */
    private int x;
    /**
     * variable used to store the y coordinate position
     */
    private int y;
    /**
     * variables used to store the radius of the oval
     */
    private int radius;
    /**
     * variable used to store the color of the sun or planet
     */
    private Color color;

    /**
     * a getter for x variable
     * @return
     */
   public int getX() {
      return x;
   }

    /**
     * a setter for x variable
     * @param x
     */
   public void setX(int x) {
      this.x = x;
   }

    /**
     * a getter for y variable
     * @return
     */
   public int getY() {
      return y;
   }

    /**
     * a setter for y variable
     * @param y
     */
   public void setY(int y) {
      this.y = y;
   }

    /**
     * a getter for radius
     * @return
     */
   public int getRadius() {
      return radius;
   }

    /**
     * a setter method for radius
     * @param radius
     */
   public void setRadius(int radius) {
      this.radius = radius;
   }

    /**
     * a getter method for color
     * @return
     */
   public Color getColor() {
      return color;
   }

    /**
     * a setter method for color
     * @param color
     */
   public void setColor(Color color) {
      this.color = color;
   }

   /**
     * constructor used to initialize the position and color if planets
     */
    public Orbiting(int x, int y, int radius, Color color) {
       this.x = x;
       this.y = y;
       this.radius = radius;
       this.color = color;

    }

    /**
     * run method updates the x and coordinates for the planet to orbit
     * around the sun
     */
    @Override
    public void run() {

     while(true){
            try {
          double  angle = 25;
          //converts anlge to radians
         double c = Math.cos((Math.toRadians(angle)));
         double s = Math.sin((Math.toRadians(angle)));

        // translate the point to the origin to be rotates
        double ox = getX()-(500);
        double oy = getY()-(500);

        //equation to find new X and Y values with angle
         double tempX = c*ox -s*oy;
         double tempy = s*ox + c*oy;

         //translates the point back
         double newX = tempX + 500;
         double newY = tempy + 500;

         setX( (int)newX);
         setY((int)newY);

            //Puts the thread asleep for 200 milliseconds
             Thread.sleep(200);
         }
            //catch expression for error
            catch (Exception e) {
            e.printStackTrace();
         }

     }

   }
}