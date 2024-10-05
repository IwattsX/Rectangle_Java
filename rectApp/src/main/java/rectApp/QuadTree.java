package rectApp;

import java.util.ArrayList;

public class QuadTree {
    private Node root;

    public QuadTree() {
        this.root = new LeafNode(-50, -50, 100, 100); // Example dimensions; adjust as needed
    }

    public void insert(Rectangle rectangle) throws Exception{
        root.insert(rectangle);
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

    public void dump() {
        root.dump();
    }
}
