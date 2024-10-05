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
        if(this.rect.length == 0 || this.rect.width == 0){
            throw new Exception("You can not insert at this position");
        }
        if(rectangles.size() == 5){
            // Make this node an internal one insert as a leafnode rectangle
            
            


            throw new Exception("Leafnode filled");
        }
        for(Rectangle rectangle : rectangles){
            if(r.point.x == rectangle.point.x && r.point.y == rectangle.point.y){
                throw new Exception("You can not double insert at a position.");
            }
        }
        rectangles.add(r);
        
    }
    @Override
    void delete(int x, int y) throws Exception{
        boolean flag = true;
        for(int i = 0; i<rectangles.size(); i++){
            Rectangle rectangle = rectangles.get(i);
            if(rectangle.point.x == x && rectangle.point.y == y){
                rectangles.remove(i);
                flag = false;
                break;
            }
        }

        if(flag){
            throw new Exception("Nothing to delete at " + x + ", " + y + ".");
        }
    }
    @Override
    void update(int x, int y, int l, int w) throws Exception{

        boolean flag = true;
        for(int i = 0; i<rectangles.size(); i++){
            Rectangle rectangle = rectangles.get(i);
            if(rectangle.point.x == x && rectangle.point.y == y){
                rectangle.length = l;
                rectangle.width = w;
                flag = false;
                break;
            }
        }

        if (flag){
            throw new Exception("Nothing to update at " + x + ", " + y + ".");
        }
        
    } 
    @Override
    void dump(){
        System.out.printf("Leaf Node - Rectangle at %d, %d: %dx%d:\n", this.rect.point.x, this.rect.point.y, this.rect.length, this.rect.width);
        for(int i = 0; i<rectangles.size(); i++){
            Rectangle tmpRect = rectangles.get(i);
            System.out.printf("\t\tRectangle at %d, %d: %dx%d:\n", tmpRect.point.x, tmpRect.point.y, tmpRect.length, tmpRect.width);
        }
        
    } 
    @Override
    Rectangle find(int x, int y) throws Exception{
        for(Rectangle rectangle : rectangles){
            if(rectangle.point.x == x && rectangle.point.y == y){
                return rectangle;
            }
        }

        throw new Exception("Nothing is at " + x + ", " + y + ".");
        
    }
}
