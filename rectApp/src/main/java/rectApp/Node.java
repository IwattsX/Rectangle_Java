package rectApp;


// Make an abstract Node class with five 5 abstract methods: insert, delete, update, dump, and find.
abstract class Node {
    Rectangle rect; //every Node has a rectangle it is within

    // insert X Y L W
    abstract void insert(Rectangle r) throws Exception;

    // Delete X Y
    abstract void delete(int x, int y) throws Exception;

    // Update X Y L W
    abstract void update(int x, int y, int l, int w) throws Exception;
    
    // just prints
    abstract void dump(); 

    // Find X Y
    abstract Rectangle find(int x, int y) throws Exception;
}
