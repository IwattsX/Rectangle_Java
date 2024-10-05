package rectApp;


// Make an abstract Node class with five 5 abstract methods: insert, delete, update, dump, and find.
abstract class Node {
    Rectangle rect; //every Node has a rectangle it is within
    abstract void insert(Rectangle r) throws Exception;
    abstract void delete(Rectangle rectangle);
    abstract void update(Rectangle rectangle); 
    abstract void dump(); 
    abstract Rectangle find(Rectangle rectangle);
}
