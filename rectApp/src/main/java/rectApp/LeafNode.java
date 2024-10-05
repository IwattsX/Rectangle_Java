package rectApp;

import java.util.ArrayList;

public class LeafNode extends Node {
    ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

    LeafNode(){
        //default values for leaf node
        this.rect = new Rectangle(-50, -50, 100, 100);

    }

    LeafNode(int x, int y, int l, int w){
        this.rect = new Rectangle(x, y, l, w);
    }


    @Override
    void insert(Rectangle r) throws Exception{
        if(rectangles.size() == 5){
            // Make this node an internal one insert as a leafnode rectangle
            
            return;
        }

        rectangles.add(r);
        
    }
    @Override
    void delete(){
        
    }
    @Override
    void update(){
        
    } 
    @Override
    void dump(){
        System.out.printf("Leaf Node - Rectangle at %d, %d: %dx%d:\n", this.rect.point.x, this.rect.point.y, this.rect.length, this.rect.width);
        for(int i = 0; i<rectangles.size(); i++){
            Rectangle tmpRect = rectangles.get(i);
            System.out.printf("\tRectangle at %d, %d: %dx%d:\n", tmpRect.point.x, tmpRect.point.y, tmpRect.length, tmpRect.width);
        }
        
    } 
    @Override
    void find(){
        
    }
}
