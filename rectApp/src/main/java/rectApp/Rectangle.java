package rectApp;

/** A class containing Rectangle Fields Points(x, y) and length and width */
public class Rectangle {
    public Point point;
    public float length;
    public float width;
    /**
     * Initializes a Rectangle object with a bottom left point and a length and width
     * @param x : point at x
     * @param y : point at y
     * @param l : length
     * @param w : width
     */
    Rectangle(float x, float y, float l, float w){
        this.point = new Point(x, y); // Use Point's constructor
        this.length = l;
        this.width = w;
    }

    /**
     * Tells if the rectangle can be contained within another rectangle, the point
     * @param obj : A rectangle object
     * @return : True if the rectangle can be contained else false
     */
    public boolean contains(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle other = (Rectangle) obj;


    // Check if the bottom-left corner of 'other' is within the bounds of this rectangle
    return (Float.compare(other.point.x, this.point.x) >= 0 && Float.compare(other.point.x, this.point.x + this.length) <= 0) 
        && (Float.compare(other.point.y, this.point.y) >= 0 && Float.compare(other.point.y,this.point.y + this.width) <= 0);
    }

    /**
     * A way to print this rectangle out to the stdout using System.out.println(RectangleObj.toString())
     */
    public String toString(){
        //Rectangle at 25, 0: 25x25:
        return String.format("Rectangle at (%.2f, %.2f): %.2fx%.2f:", this.point.x, this.point.y, this.length, this.width);
    }
}



