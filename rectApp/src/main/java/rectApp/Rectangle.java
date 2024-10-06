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

    public boolean contains(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle other = (Rectangle) obj;


    // Check if the bottom-left corner of 'other' is within the bounds of this rectangle
    return (other.point.x >= this.point.x && other.point.x <= this.point.x + this.length) 
        && (other.point.y >= this.point.y && other.point.y <= this.point.y + this.width);
    }

    public String toString(){
        //Rectangle at 25, 0: 25x25:
        return String.format("Rectangle at %d, %d: %dx%d:", this.point.x, this.point.y, this.length, this.width);
    }
}



