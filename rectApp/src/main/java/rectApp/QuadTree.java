package rectApp;

import java.util.ArrayList;

public class QuadTree {
    private Node root;
    int initial_tabs = 0;
    public QuadTree() {
        this.root = new LeafNode(-50, -50, 100, 100); // Example dimensions; adjust as needed
    }

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
    
    

    public Rectangle find(int x, int y) throws Exception{
        return root.find(x, y);
    }

    public void delete(int x, int y) throws Exception {
        root.delete(x,y);
    }

    public void update(int x, int y, int l, int w) throws Exception{
        root.update(x,y,l,w);
    }

    public void dump(int tabs) {
        root.dump(tabs);
    }
}
