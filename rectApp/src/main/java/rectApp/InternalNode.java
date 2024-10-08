package rectApp;

/** An internal Node which has the child Nodes topLeft, topRight, bottomLeft, bottomRight */
public class InternalNode extends Node {

    Node topLeft;
    Node topRight;
    Node bottomLeft;
    Node bottomRight;
    
    /** Default constructor constructing Internal Node rectangle at (-50, 50), length = 100, width = 100 */
    InternalNode(){
        //default values for leaf node
        this.rect = new Rectangle(-50, -50, 100, 100);
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    /**
     * Parameterized constructor that constructs the Interal Node rectangle at (x, y), length = l, width = w
     * @param x : location at X
     * @param y : location at Y
     * @param l : length
     * @param w : width
     */
    InternalNode(float x, float y, float l, float w){
        this.rect = new Rectangle(x, y, l, w);
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    
    /** 
     * @param r : Rectangle
     * @throws Exception : if there are any problems with inserting
     */
    @Override
    void insert(Rectangle r) throws Exception {
        // Ensure children are initialized
        if (topLeft == null) {
            topLeft = new LeafNode(rect.point.x, rect.point.y + (rect.width / 2), rect.length / 2, rect.width / 2);
        }
        if (topRight == null) {
            topRight = new LeafNode(rect.point.x + (rect.length / 2), rect.point.y + (rect.width / 2), rect.length / 2, rect.width / 2);
        }
        if (bottomLeft == null) {
            bottomLeft = new LeafNode(rect.point.x, rect.point.y, rect.length / 2, rect.width / 2);
        }
        if (bottomRight == null) {
            bottomRight = new LeafNode(rect.point.x + (rect.length / 2), rect.point.y, rect.length / 2, rect.width / 2);
        }
    
        // Insert the rectangle into the appropriate child node
        if (topLeft.rect.contains(r)) {
            if(topLeft instanceof LeafNode && ((LeafNode)topLeft).rectangles.size() == 5){
                InternalNode node = new InternalNode(topLeft.rect.point.x, topLeft.rect.point.y, topLeft.rect.length, topLeft.rect.width);
                for(Rectangle rectangle : ((LeafNode)topLeft).rectangles){
                    node.insert(rectangle);
                }
                node.insert(r);

                this.topLeft = node;
            }
            else{
                topLeft.insert(r);
            }
        } 
        
        else if (topRight.rect.contains(r)) {
            if(topRight instanceof LeafNode && ((LeafNode)topRight).rectangles.size() == 5){
                InternalNode node = new InternalNode(topRight.rect.point.x, topRight.rect.point.y, topRight.rect.length, topRight.rect.width);
                for(Rectangle rectangle : ((LeafNode)topRight).rectangles){
                    node.insert(rectangle);
                }
                node.insert(r);

                this.topRight = node;
            }
            else{
                topRight.insert(r);
            }
        } 
        
        else if (bottomLeft.rect.contains(r)) {
            if(bottomLeft instanceof LeafNode && ((LeafNode)bottomLeft).rectangles.size() == 5){
                InternalNode node = new InternalNode(bottomLeft.rect.point.x, bottomLeft.rect.point.y, bottomLeft.rect.length, bottomLeft.rect.width);
                for(Rectangle rectangle : ((LeafNode)bottomLeft).rectangles){
                    node.insert(rectangle);
                }
                node.insert(r);

                this.bottomLeft = node;
            }
            else{
                bottomLeft.insert(r);
            }
        } 
        
        else if (bottomRight.rect.contains(r)) {
            if(bottomRight instanceof LeafNode && ((LeafNode)bottomRight).rectangles.size() == 5){
                InternalNode node = new InternalNode(bottomRight.rect.point.x, bottomRight.rect.point.y, bottomRight.rect.length, bottomRight.rect.width);
                for(Rectangle rectangle : ((LeafNode)bottomRight).rectangles){
                    node.insert(rectangle);
                }
                node.insert(r);

                this.bottomRight = node;
            }
            else{
                bottomRight.insert(r);
            }
        } else {
            throw new Exception("Rectangle does not fit in any quadrant.");
        }
    }
    
    
    /** 
     * Deletes a Rectangle from the data
     * @param x : location at the x coordinate
     * @param y : location at the y coordinate
     * @throws Exception : if there is nothing to delete at (x,y)
     */
    @Override
    void delete(float x, float y) throws Exception{
        Rectangle checkRect = new Rectangle(x, y, 10, 10);

        if(topLeft != null && topLeft.rect.contains(checkRect)){
            topLeft.delete(x, y);
        }
        else if(topRight != null && topRight.rect.contains(checkRect)){
            topRight.delete(x,y);
        }
        else if(bottomLeft != null && bottomLeft.rect.contains(checkRect)){
            bottomLeft.delete(x,y);
        }
        else if(bottomRight != null && bottomRight.rect.contains(checkRect)){
            bottomRight.delete(x,y);
        }
        else{
            throw new Exception("Nothing to delete at " + x + "," + y + ".");
        }
        
    }


    
    
    /** 
     * @param x : location of rectange at x
     * @param y : location of rectange at y
     * @param l : length of the rectangle being updated to
     * @param w : width of the rectangle being updated to
     * @throws Exception
     */
    @Override
    void update(float x, float y, float l, float w) throws Exception{
        Rectangle checkRect = new Rectangle(x, y, 10, 10);
        if(topLeft != null && topLeft.rect.contains(checkRect)){
            topLeft.update(x,y, l, w);
        }
        else if(topRight != null && topRight.rect.contains(checkRect)){
            topRight.update(x,y, l, w);
        }
        else if(bottomLeft != null && bottomLeft.rect.contains(checkRect)){
            bottomLeft.update(x,y, l, w);
        }
        else if(bottomRight != null && bottomRight.rect.contains(checkRect)){
            bottomRight.update(x,y, l, w);
        }
        else{
            throw new Exception("Nothing to update at " + x + "," + y + ".");
        }

        
    } 



    
    
    /** 
     * Prints out the Internal Node to the stdout
     * @param tabs : the amount of tabs to be placed for all these arguments(done recursively updated with DFS)
     */
    @Override
    void dump(int tabs){
        System.out.printf("\t".repeat(tabs) + "Internal Node - %s\n", this.rect.toString());
        tabs++;
        if(topLeft != null){
            topLeft.dump(tabs);
        }
        if(topRight != null){
            topRight.dump(tabs);
        }
        if(bottomLeft != null){
            bottomLeft.dump(tabs);
        }
        if(bottomRight != null){
            bottomRight.dump(tabs);
        }
        
    }
    
    
    
    /** 
     * @param x : location to check for x
     * @param y : location to check for y
     * @return Rectangle : the rectangle object that is found at (x, y)
     * @throws Exception
     */
    @Override
    Rectangle find(float x, float y) throws Exception{
        Rectangle checkRect = new Rectangle(x, y, 10, 10);

        if(topLeft != null && topLeft.rect.contains(checkRect)){
            return topLeft.find(x, y);
        }
        else if(topRight != null && topRight.rect.contains(checkRect)){
            return topRight.find(x,y);
        }
        else if(bottomLeft != null && bottomLeft.rect.contains(checkRect)){
            return bottomLeft.find(x,y);
        }
        else if(bottomRight != null && bottomRight.rect.contains(checkRect)){
            return bottomRight.find(x,y);
        }
        else{
            throw new Exception("Nothing is at " + x + "," + y + ".");
        }
    }


    
    /** 
     * This replaces one of the LeafNodes with Internal nodes
     * @param n : node to replace one of the children with
     */
    void replaceChild(InternalNode n){
        if(topLeft.rect.contains(n.rect)){
            topLeft = n;
        }

        if(topRight.rect.contains(n.rect)){
            topRight = n;
        }

        if(bottomLeft.rect.contains(n.rect)){
            bottomLeft = n;
        }

        if(bottomRight.rect.contains(n.rect)){
            bottomRight = n;
        }
    }
}
