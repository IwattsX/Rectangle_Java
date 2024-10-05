package rectApp;

import java.util.ArrayList;

public class QuadTree {
    private Node root;

    public QuadTree() {
        this.root = new LeafNode(-50, -50, 100, 100); // Example dimensions; adjust as needed
    }

    public void insert(Rectangle rectangle) {
        try {
            root.insert(rectangle); // Attempt to insert into the root
        } catch (Exception e) {
            // If inserting into a LeafNode fails due to capacity
            if (root instanceof LeafNode) {
                ArrayList<Rectangle> list = ((LeafNode) root).rectangles;

                // Create a new InternalNode at the root
                InternalNode newRoot = new InternalNode(root.rect.point.x, root.rect.point.y, root.rect.length, root.rect.width);

                // Insert existing rectangles into the new InternalNode
                for (Rectangle r : list) {
                    newRoot.insert(r);
                }

                // Now insert the new rectangle
                try {
                    newRoot.insert(rectangle);
                } catch (Exception ex) {
                    System.out.println("Failed to insert rectangle after upgrading to InternalNode: " + ex.getMessage());
                }

                // Set the new root
                root = newRoot;
            } else {
                System.out.println("Failed to insert rectangle: " + e.getMessage());
            }
        }
    }

    public Rectangle find(Rectangle rectangle) {
        return root.find(rectangle);
    }

    public void delete(Rectangle rectangle) {
        root.delete(rectangle);
    }

    public void update(Rectangle rectangle) {
        root.update(rectangle);
    }

    public void dump() {
        root.dump();
    }
}
