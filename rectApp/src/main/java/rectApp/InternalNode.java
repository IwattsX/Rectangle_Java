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
    void insert(Rectangle r) throws Exception{
            
    }
    @Override
    void delete(){
        
    }
    @Override
    void update(){
        
    } 
    @Override
    void dump(){
        System.out.printf("Internal Node - Rectangle at %d, %d: %dx%d\n", this.rect.point.x, this.rect.point.y, this.rect.length, this.rect.width);
        
    } 
    @Override
    void find(){
        
    }
}
