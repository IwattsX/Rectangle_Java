package rectApp;

import java.util.ArrayList;

/** A leafNode that inherits from Node containing an ArrayList of Rectangles and its reference to a parent (if any) */
public class LeafNode extends Node {
    ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

    // default constructor
    LeafNode() {
        // default values for leaf node
        this.rect = new Rectangle(-50, -50, 100, 100);
    }

    /**
     * A parameterized constructor w/o a parent node
     * @param x : location of bottom left point at X
     * @param y : location of bottom left point at Y
     * @param l : length of the rectangle
     * @param w : width of the rectangle
     */
    LeafNode(float x, float y, float l, float w) {
        this.rect = new Rectangle(x, y, l, w);
    }
    
    /** 
     * Insert a rectangle into an ArrayList of rectangles in LeafNode or puts them for insertion inside of an InternalNode that will eventually have LeafNodes to insert into
     * @param r : the rectangle being inserted into this LeafNode.rectangles ArrayList
     * @throws Exception
     */
    @Override
    void insert(Rectangle r) throws Exception{
        if(this.rect.length == 0 || this.rect.width == 0 || !this.rect.contains(r)
        ){
            throw new Exception("You can not insert at this position");
        }
        if(rectangles.size() == 5){
            throw new Exception("Root isn't an internal node");
        }
        for(Rectangle rectangle : rectangles){
            if(r.point.x == rectangle.point.x && r.point.y == rectangle.point.y){
                throw new Exception("You can not double insert at a position.");
            }
        }
        rectangles.add(r);
        
    }

    
    /** 
     * Deletes a rectangle from the ArrayList at (x,y)
     * @param x : location at x
     * @param y : location at y
     * @throws Exception : nothing to be deleted at (x,y)
     */
    @Override
    void delete(float x, float y) throws Exception {
        boolean flag = true;
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle rectangle = rectangles.get(i);
            if (rectangle.point.x == x && rectangle.point.y == y) {
                rectangles.remove(i);
                flag = false;
                break;
            }
        }

        if (flag) {
            throw new Exception("Nothing to delete at " + x + ", " + y + ".");
        }
    }

    
    /** 
     * Updates one of the rectanges in an ArrayList to have length l and width w
     * @param x : location of rectangle at x
     * @param y : location of rectangle at y
     * @param l : length to be updated to
     * @param w : width to be updated to
     * @throws Exception : if there is no rectangles at (x,y)
     */
    @Override
    void update(float x, float y, float l, float w) throws Exception {

        boolean flag = true;
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle rectangle = rectangles.get(i);
            if (rectangle.point.x == x && rectangle.point.y == y) {
                rectangle.length = l;
                rectangle.width = w;
                flag = false;
                break;
            }
        }

        if (flag) {
            throw new Exception("Nothing to update at " + x + ", " + y + ".");
        }

    }

    
    /** 
     * prints to the stout all the rectangles within the ArrayList
     * @param tabs : The amount of tabs that need to be intented
     */
    @Override
    void dump(int tabs) {
        System.out.printf("\t".repeat(tabs) + "Leaf Node - %s\n", this.rect.toString());
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle tmpRect = rectangles.get(i);
            System.out.printf("\t".repeat( tabs + 1) + "%s\n", tmpRect.toString());
        }
    }

    /**
     * Finds a rectangle at position (x, y)
     * @param x : location of rectangle at x
     * @param y : location of rectangle at y
     * @throws Exception : if no rectangle is there at (x, y)
     */
    @Override
    Rectangle find(float x, float y) throws Exception {
        for (Rectangle rectangle : rectangles) {
            if (rectangle.point.x == x && rectangle.point.y == y) {
                return rectangle;
            }
        }

        throw new Exception("Nothing is at " + x + ", " + y + ".");

    }
}
