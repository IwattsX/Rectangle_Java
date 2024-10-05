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
        // Implement logic to insert into the appropriate child
        // Check which quadrant the rectangle should go into
        // if (topLeft == null) {
        //     topLeft = new LeafNode(rect.point.x - (rect.length / 2), rect.point.y - (rect.width / 2), rect.length / 2, rect.width / 2);
        // }
        // if (topRight == null) {
        //     topRight = new LeafNode(rect.point.x + (rect.length / 2), rect.point.y - (rect.width / 2), rect.length / 2, rect.width / 2);
        // }
        // if (bottomLeft == null) {
        //     bottomLeft = new LeafNode(rect.point.x - (rect.length / 2), rect.point.y + (rect.width / 2), rect.length / 2, rect.width / 2);
        // }
        // if (bottomRight == null) {
        //     bottomRight = new LeafNode(rect.point.x + (rect.length / 2), rect.point.y + (rect.width / 2), rect.length / 2, rect.width / 2);
        // }


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
    void delete(Rectangle rectangle){
        
    }
    @Override
    void update(Rectangle rectangle){
        
    } 
    @Override
    void dump(){
        System.out.printf("Internal Node - Rectangle at %d, %d: %dx%d\n", this.rect.point.x, this.rect.point.y, this.rect.length, this.rect.width);
        if(topLeft != null){
            System.out.print("\t");
            topLeft.dump();
        }
        if(topRight != null){
            System.out.print("\t");
            topRight.dump();
        }
        if(bottomLeft != null){
            System.out.print("\t");
            bottomLeft.dump();
        }
        if(bottomRight != null){
            System.out.print("\t");
            bottomRight.dump();
        }
        
    } 
    @Override
    Rectangle find(Rectangle rectangle){
        return new Rectangle(0, 0, 0, 0);
    }
}
