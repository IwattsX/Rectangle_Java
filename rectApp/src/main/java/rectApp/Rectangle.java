package rectApp;


public class Rectangle {
    public Point point;
    public int length;
    public int width;
    Rectangle(int x, int y, int l, int w){
        this.point = new Point(x, y); // Use Point's constructor
        this.length = l;
        this.width = w;
    }
}



