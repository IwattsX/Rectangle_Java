package rectApp;


/** abstract Node class with five 5 abstract methods: insert, delete, update, dump, and find.*/
abstract class Node {
    Rectangle rect; //every Node has a rectangle it is within


    /**
     * inserts a rectangle into the QuadTree
     * @param r : the rectangle to be inserted inside of a leafNode
     * @throws Exception : if it is impossible to insert or if there is something already inserted there
     */
    abstract void insert(Rectangle r) throws Exception;

    /**
     * Deletes a rectangle at (x, y)
     * @param x : location of rectangle at x
     * @param y : location of rectangle at y
     * @throws Exception : nothing to be deleted
     */
    abstract void delete(float x, float y) throws Exception;

    /**
     * Updates the rectangles length and width based on (x,y)
     * @param x : location at x
     * @param y : location at y
     * @param l : update rectangle to this length
     * @param w : update rectangle to this width
     * @throws Exception : nothing to be updated
     */
    abstract void update(float x, float y, float l, float w) throws Exception;
    
    /**
     * prints the entire quadTree
     * @param tabs : the number of tabs that will be printed from the left side
     */
    abstract void dump(int tabs); 

    /**
     * @param x : location of rectangle at x
     * @param y : location of rectangle at y
     * @return Rectangle
     * @throws Exception : if there is nothing at (x, y)
     */
    abstract Rectangle find(float x, float y) throws Exception;


}
