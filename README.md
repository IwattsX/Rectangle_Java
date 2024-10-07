# Rectangle Quadtree project
Takes in 5 commands: insert, delete, update, dump, and find and does an operation on the root node of the quadtree recursively for these 5 methods.

- insert x y l w
    - insert a rectange at (x, y) with length and width

- delete x y
    - delete a rectangle at (x,y) if it exist

- update x y l w
    - update a rectange at (x, y ) to a new length and width

- dump
    - prints the entire quadtree starting from the root

- find x y
    - find a rectange at (x, y) if it exist

# Dependencies:
- maven
- Java sdk


# How to run
1) Get into the directory the app is in:
```
cd rectApp
```
2) build the package
```
mvn package
```
3) Run the code
```
java -cp target/rectApp-1.0-SNAPSHOT.jar rectApp.App PATH/*.cmd
```

# Test
1) Get into the directory the app is in:
```
cd rectApp
```
2) build the package
```
mvn package
```
3) test
```
mvn test
```

**NOTE** You can run it in eclipse.
