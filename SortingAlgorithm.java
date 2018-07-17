import java.awt.*;
import java.util.Random;

public class SortingAlgorithm {

   //Height and width in pixels for drawingboard. Increment determines how many squares
   public static int height = 500;
   public static int width = 500;
   public static int increment = 1;
   
   //Amount of rows/collumns used for Calculation (Is 1 increment less than this number since x/y end at the end of the screen)
   public static int rows = height / increment;
   public static int cols = width / increment;
   
   //List of all colors as Color Objects
   public static Color[][] colorList = new Color[rows][cols];
   public static int[][] ListOfColors = new int[rows][cols];
   
   //List for rgb values added up to help with sorting
   public static int[][] RGBList = new int[rows][cols];
   
   //Object Construction
   public static Random rand = new Random();
   public static DrawingPanel panel = new DrawingPanel(width, height);
   public static Graphics g = panel.getGraphics();
   
   //Main
   public static void main(String[] args)
   {
      initializeImage();
      setRGBList();
      sortColors();
      
      
      //refreshPanel();

   }
   
   
   //Initialize the drawing board and colorList[][]
   public static void initializeImage()
   {
      for(int i = 0; i < width; i += increment)
         {
            for(int j = 0; j < height; j += increment)
            {
               Color randomColor = getRandomRGB();
               g.create((i/increment), (j/increment), increment, increment);
               g.setColor(randomColor);
               colorList[i/increment][j/increment] = randomColor;
               g.fillRect(i, j, increment, increment);
            }
         }
   }
   
   public static void refreshPanel()
   {
      for(int i = 0; i < width; i += increment)
      {
         for(int j = 0; j < height; j += increment)
         {

            
         }
      }
      
   }
   
   //Gets random r,g,b values
   public static Color getRandomRGB()
   {
      float r = rand.nextFloat();
      float g = rand.nextFloat();
      float b = rand.nextFloat();
      
      return new Color(r, g, b);
   }
   
   //Sets the RGBList with the total rgb of the color
   public static void setRGBList()
   {
      for(int i = 0; i < width; i += increment)
      {
         for(int j = 0; j < height; j += increment)
         {
            int currRed = colorList[i/increment][j/increment].getRed();
            int currGreen = colorList[i/increment][j/increment].getGreen();
            int currBlue = colorList[i/increment][j/increment].getBlue();
            
            RGBList[i/increment][j/increment] = currRed + currGreen + currBlue;
         }
      }

   }

   public static void sortColors()
   {
      for(int i = 0; i < width; i += increment)
      {
         for(int j = 0; j < height; j += increment)
         {
            for (int k = 0; k < height - j; k+= increment)
            {
                    if (RGBList[i/ increment][k/ increment] > RGBList[i/ increment][(k + 1)/ increment])
                    {
 
                        // swapping of elements
                        int t = RGBList[i/ increment][k];
                        RGBList[i/ increment][k/ increment] = RGBList[i/ increment][(k + 1)/ increment];
                        RGBList[i/ increment][(k + 1)/ increment] = t;
                        
                    }
                    refreshPanel();
            }
         }
      }
   }
}