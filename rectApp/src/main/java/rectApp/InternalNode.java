package rectApp;

public class InternalNode extends Node {

    Node topLeft;
    Node topRight;
    Node bottomLeft;
    Node bottomRight;
    

    InternalNode(){
        //default values for leaf node
        this.rect = new Rectangle(-50, -50, 100, 100);
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    InternalNode(int x, int y, int l, int w){
        this.rect = new Rectangle(x, y, l, w);
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    @Override
    void insert(Rectangle r) throws Exception {
        // Ensure children are initialized
        if (topLeft == null) {
            topLeft = new LeafNode(rect.point.x, rect.point.y + (rect.width / 2), rect.length / 2, rect.width / 2, this);
        }
        if (topRight == null) {
            topRight = new LeafNode(rect.point.x + (rect.length / 2), rect.point.y + (rect.width / 2), rect.length / 2, rect.width / 2, this);
        }
        if (bottomLeft == null) {
            bottomLeft = new LeafNode(rect.point.x, rect.point.y, rect.length / 2, rect.width / 2, this);
        }
        if (bottomRight == null) {
            bottomRight = new LeafNode(rect.point.x + (rect.length / 2), rect.point.y, rect.length / 2, rect.width / 2, this);
        }
    
        // Insert the rectangle into the appropriate child node
        if (topLeft.rect.contains(r)) {
            topLeft.insert(r);
        } else if (topRight.rect.contains(r)) {
            topRight.insert(r);
        } else if (bottomLeft.rect.contains(r)) {
            bottomLeft.insert(r);
        } else if (bottomRight.rect.contains(r)) {
            bottomRight.insert(r);
        } else {
            throw new Exception("Rectangle does not fit in any quadrant.");
        }
    }
    
    @Override
    void delete(int x, int y) throws Exception{
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
    @Override
    void update(int x, int y, int l, int w) throws Exception{
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
    @Override
    void dump(int tabs){
        System.out.printf("\t".repeat(tabs) + "Internal Node - Rectangle at %d, %d: %dx%d\n", this.rect.point.x, this.rect.point.y, this.rect.length, this.rect.width);
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
    @Override
    Rectangle find(int x, int y) throws Exception{
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
