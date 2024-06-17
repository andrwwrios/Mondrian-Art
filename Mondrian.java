// andrew rios 
// ta : Shreya Nambi
// 05/08/2024
// C2: Mondarian Art

/*
 * this program creates an image that evokes the style of 20th century
 * Dutch abstract artist Piet Mondrian
 */
import java.util.*;
import java.awt.*;

public class Mondrian {
    private Random rand;
    Color color;

    // constructs a mondrian object initializing the neccessary fields 
    public Mondrian() {
        rand = new Random();
        color = new Color(0);
    }

    // randomly splits the pixels parameter into regions which then get filled with colors either
    // red, yellow, cyan, or white which are chosen at random for each region
    // parameters: 2D array of type Color where the elements inside represent pixels
    public void paintBasicMondrian(Color[][] pixels) {
        divideCanvas(pixels);
    }

    // with the given 2D array of Colors, randomly divides the array into regions
    /* 
     * If the region being considered is at least one-fourth the height of the full canvas and
     * at least one-fourth the width of the full canvas, it splits it into four smaller regions by
     * choosing one vertical and one horizontal dividing line at random.
     */
    /*
     * If the region being considered is at least one-fourth the height of the full canvas, 
     * it splits into two smaller regions by choosing a horizontal dividing line at random.
     */
    /*
     * If the region being considered is at least one-fourth the width of the full canvas,
     * it splits into two smaller regions by choosing a vertical dividing line at random.
     */
    /*
     * If the region being considered is smaller than one-fourth the height of the full canvas and 
     * smaller than one-fourth the width of the full canvas, the region then 
     * gets filled with a color chosen at random between white, yellow, cyan, and red.
     */
    // takes in a 2D array of Color where each element represnets a pixel
    private void divideCanvas(Color[][] pixels) {
        divideCanvas(pixels, 0, pixels[0].length, 0, pixels.length);
    }

    // helper method to help recurse through, divide, and paint the regions from pixels
    // parameters : 
    /*
     * 2D array of Color where each element represnets a pixel
     * int x1, int x2, int y1, int y2 -> where (x1, y1) represents the upper-left corner inclusive
     * and (x2, y2) represents the lower-right corner exclusive
     */
    private void divideCanvas(Color[][] pixels, int x1, int x2, int y1, int y2) {
        if((y2-y1 < pixels.length / 4 ) && (x2-x1 < pixels[0].length / 4)) {
            fill(pixels, x1, x2, y1, y2);
        } else if(y2-y1 >= pixels.length / 4 && x2-x1 >= pixels[0].length / 4) {
            int xMid = rand.nextInt(x1 + 10, x2 - 10); 
            int yMid = rand.nextInt(y1 + 10, y2 - 10);
            divideCanvas(pixels, x1, xMid, y1, yMid); // top left
            divideCanvas(pixels, xMid, x2, y1, yMid); // top right
            divideCanvas(pixels, x1, xMid, yMid, y2); // bottom left
            divideCanvas(pixels, xMid, x2, yMid, y2); // bottom right
        } else if(x2-x1 >= pixels[0].length / 4) { 
            int xMid = rand.nextInt(x1 + 10, x2 - 10); 
            divideCanvas(pixels, x1, xMid, y1, y2); // left
            divideCanvas(pixels, xMid, x2, y1, y2); // right
        } else {
            int yMid = rand.nextInt(y1 + 10, y2 - 10);
            divideCanvas(pixels, x1, x2, y1, yMid); // top
            divideCanvas(pixels, x1, x2, yMid, y2); // bottom
        }
    }

    // fills in the given array of Colors within the regions defined by x1, x2, y1, and y2
    // the color which the region is filled with is determined randomly
    // where (x1, y1) represents the upper-left corner inclusive,
    // and (x2, y2) represents the lower-right corner exclusive.
    private void fill(Color[][] pixels, int x1, int x2, int y1, int y2) {
        int num = rand.nextInt(0,4);
        if(num == 0) {
            color = Color.RED;
        } else if(num == 1) {
            color = Color.YELLOW;
        } else if(num == 2) {
            color = Color.CYAN;
        } else {
            color = Color.WHITE;
        }
        for(int row = y1 + 1; row<y2 - 1; row++) {
            for(int col = x1 +1; col<x2 - 1; col++) {
                pixels[row][col] = color;
            }
        }
    }

    // randomly splits the pixels parameter into regions which then get filled with colors either
    // red, yellow, cyan, or white which are chosen at random for each region. 
    // there is a color related region on the upper left region of the overall canvas making white
    // more likely, but not guaranteed to occur in that area
    // parameters: 2D array of type Color where the elements inside represent pixels
    public void paintComplexMondrian(Color[][] pixels) {
        complexDivideCanvas(pixels);
    }

    // with the given 2D array of Colors, randomly divides the array into regions
    /* 
     * If the region being considered is at least one-fourth the height of the full canvas and
     * at least one-fourth the width of the full canvas, it splits it into four smaller regions by
     * choosing one vertical and one horizontal dividing line at random.
     */
    /*
     * If the region being considered is at least one-fourth the height of the full canvas, 
     * it splits into two smaller regions by choosing a horizontal dividing line at random.
     */
    /*
     * If the region being considered is at least one-fourth the width of the full canvas,
     * it splits into two smaller regions by choosing a vertical dividing line at random.
     */
    /*
     * If the region being considered is smaller than one-fourth the height of the full canvas and 
     * smaller than one-fourth the width of the full canvas, the region then 
     * gets filled with a color chosen at random between white, yellow, cyan, and red.
     */
    // takes in a 2D array of Color where each element represnets a pixel
    private void complexDivideCanvas(Color[][] pixels) {
        complexDivideCanvas(pixels, 0, pixels[0].length, 0, pixels.length);
    }

    // helper method to help recurse through, divide, and paint the regions from pixels
    // parameters : 
    /*
     * 2D array of Color where each element represnets a pixel
     * int x1, int x2, int y1, int y2 -> where (x1, y1) represents the upper-left corner inclusive
     * and (x2, y2) represents the lower-right corner exclusive
     */
    private void complexDivideCanvas(Color[][] pixels, int x1, int x2, int y1, int y2) {
        if((y2-y1 < pixels.length / 4 ) && (x2-x1 < pixels[0].length / 4)) {
            complexFill(pixels, x1, x2, y1, y2);
        } else if(y2-y1 >= pixels.length / 4 && x2-x1 >= pixels[0].length / 4) {
            int xMid = rand.nextInt(x1 + 10, x2 - 10); 
            int yMid = rand.nextInt(y1 + 10, y2 - 10);
            complexDivideCanvas(pixels, x1, xMid, y1, yMid); // top left
            complexDivideCanvas(pixels, xMid, x2, y1, yMid); // top right
            complexDivideCanvas(pixels, x1, xMid, yMid, y2); // bottom left
            complexDivideCanvas(pixels, xMid, x2, yMid, y2); // bottom right
        } else if(x2-x1 >= pixels[0].length / 4) { 
            int xMid = rand.nextInt(x1 + 10, x2 - 10); 
            complexDivideCanvas(pixels, x1, xMid, y1, y2); // left
            complexDivideCanvas(pixels, xMid, x2, y1, y2); // right
        } else { 
            int yMid = rand.nextInt(y1 + 10, y2 - 10);
            complexDivideCanvas(pixels, x1, x2, y1, yMid); // top
            complexDivideCanvas(pixels, x1, x2, yMid, y2); // bottom
        }
    }

    // fills in the given array of Colors within the regions defined by x1, x2, y1, and y2
    // the color which the region is filled with is determined randomly
    // where (x1, y1) represents the upper-left corner inclusive,
    // and (x2, y2) represents the lower-right corner exclusive.
    // if the current region is within upper left corner of the overall canvas, 
    // the color white becomes more likely but not guaranteed, to occur in that region
    private void complexFill(Color[][] pixels, int x1, int x2, int y1, int y2) {
        int num = 0;
        
        // upper left region of the canvas is more likely to be colored white
        if(x2 <= pixels[0].length / 2 && y2 <= pixels.length / 2) {
            num = rand.nextInt(15); 
        } else {
            num = rand.nextInt(4);
        }
        if(num == 0) {
            color = Color.RED;
        } else if(num == 1) {
            color = Color.YELLOW;
        } else if(num == 2) {
            color = Color.CYAN;
        } else {
            color = Color.WHITE;
        }
        for(int row = y1 + 1; row<y2 - 1; row++) {
            for(int col = x1 +1; col<x2 - 1; col++) {
                pixels[row][col] = color;
            }
        }
    }
}