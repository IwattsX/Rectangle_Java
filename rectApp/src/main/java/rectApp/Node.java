package rectApp;


// Make an abstract Node class with five 5 abstract methods: insert, delete, update, dump, and find.
abstract class Node {
    Rectangle rect; //every Node has a rectangle it is within
    abstract void insert(Rectangle r) throws Exception;
    abstract void delete();
    abstract void update(); 
    abstract void dump(); 
    abstract void find();
}
