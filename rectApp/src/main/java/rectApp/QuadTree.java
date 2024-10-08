package rectApp;

/** A tree containing a root node that either points to other nodes (an internal node) or is a LeafNode that contains data */
public class QuadTree {
    private Node root;
    int initial_tabs = 0;


    /**Default constructor rectangle bottom left goes to (-50, -50), length = 100, width = 100 */
    public QuadTree() {
        this.root = new LeafNode(-50, -50, 100, 100); // Example dimensions; adjust as needed
    }

    /**
     * A public function that gets the root of the QuadTree
     */
    public Node getRoot(){
        return this.root;
    }

    /**
     * Insert a rectangle inside of the QuadTree
     * @param rectangle : Rectangle to be inserted into the QuadTree
     * @throws Exception : If it can't insert there or if there is already something inserted there
     */
    public void insert(Rectangle rectangle) throws Exception {
        // Check if the root is a LeafNode and needs to be updated
        if (root instanceof LeafNode) {
            try {
                root.insert(rectangle); // Attempt to insert
            } catch (Exception e) {
                // If inserting causes a split, we need to update the root
                if (root instanceof LeafNode) {
                    // Create a new InternalNode based on the current root's rectangle
                    InternalNode newRoot = new InternalNode(root.rect.point.x, root.rect.point.y, root.rect.length, root.rect.width);
                    
                    // Move existing rectangles from the leaf node to the new internal node
                    for (Rectangle r : ((LeafNode) root).rectangles) {
                        newRoot.insert(r);
                    }
    
                    // Now insert the new rectangle
                    newRoot.insert(rectangle);
                    
                    // Update the root of the QuadTree to this new internal node
                    root = newRoot;
                }
            }
        } else {
            // If root is already an InternalNode, just insert normally
            root.insert(rectangle);
        }
    }
    
    
    /**
     * Finds a rectangle object inside of the QuadTree
     * @param x : location at X
     * @param y : location at Y
     * @return Rectangle : the rectangle object at (x, y)
     * @throws Exception : if there is no rectangle at (x, y)
     */
    public Rectangle find(float x, float y) throws Exception{
        return root.find(x, y);
    }

    /**
     * Deletes a rectangle object inside of the QuadTree
     * @param x : location at X
     * @param y : location at Y
     * @throws Exception : nothing to be deleted at (x, y)
     */
    public void delete(float x, float y) throws Exception {
        root.delete(x,y);
    }

    /**
     * Updates a rectangle at (x, y)
     * @param x : location at X
     * @param y : location at Y 
     * @param l : length to be updated to
     * @param w : width to be updated to
     * @throws Exception
     */
    public void update(float x, float y, float l, float w) throws Exception{
        root.update(x,y,l,w);
    }

    /**
     * Prints to the stdout the whole QuadTree in a specific format
     * @param tabs : the amount of tabs on the left side of each stdout init at 0
     */
    public void dump(int tabs) {
        root.dump(tabs);
    }
}
