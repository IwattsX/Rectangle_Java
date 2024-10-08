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
mvn package -Dmaven.test.skip.exec=true
```
3) Run the code
```
java -cp target/rectApp-1.0-SNAPSHOT.jar rectApp.App PATH/*.cmd
```

Example run:
```
java -cp target/rectApp-1.0-SNAPSHOT.jar rectApp.App PATH/Rectangle_Java/Example.cmd
```
Output:
```
Internal Node - Rectangle at -50, -50: 100x100:
        Leaf Node - Rectangle at -50, 0: 50x50:
                Rectangle at -30, 10: 5x5:
        Leaf Node - Rectangle at 0, 0: 50x50:
                Rectangle at 20, 20: 5x5:
                Rectangle at 30, 10: 5x5:
        Leaf Node - Rectangle at -50, -50: 50x50:
                Rectangle at -30, -20: 5x5:
        Leaf Node - Rectangle at 0, -50: 50x50:
                Rectangle at 20, -10: 5x5:
                Rectangle at 30, -20: 5x5:
                Rectangle at 40, -30: 5x5:
```


# Test
1) Get into the directory the app is in:
```
cd rectApp
```
2) build the package
```
mvn package -Dmaven.test.skip.exec=true
```
3) test
```
mvn test
```

**NOTE** You can run it in eclipse.
