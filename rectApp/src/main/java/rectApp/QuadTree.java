package rectApp;


// Rectangle
public class QuadTree {


    Node node;

    QuadTree(){
        this.node = new LeafNode(-50, -50, 100, 100);
    }

    QuadTree(int x, int y, int l, int w){
        this.node = new LeafNode(x, y, l, w);
    }

    void insert(Rectangle rectangle) throws Exception{
        node.insert(rectangle);
    }

    void delete(){
        node.delete();
    }

    void update(){
        node.update();
    } 

    void dump(){
        node.dump();
    } 

    void find(){
        node.find();
    }
}
