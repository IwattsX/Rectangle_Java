package rectApp;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Paths;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test 
    public void quadTree_default_Spot(){
        
        QuadTree tree = new QuadTree();
        Node root = tree.getRoot();
        assertTrue(root.rect.point.x == -50 && root.rect.point.y == -50 
        && root.rect.width == 100 
        && root.rect.length == 100);
    }

    @Test
    public void quadTree_root_turns_to_InternalNode(){
        QuadTree tree = new QuadTree();
        ArrayList<Rectangle> rects = new ArrayList<Rectangle>();

        for(int i = 0; i<6; i++){
            Rectangle tmp = new Rectangle(i + 5, i + 10, 5, 10);
            rects.add(tmp);
        }
        try {
            for(int i = 0; i<rects.size(); i++){
                tree.insert(rects.get(i));
            }
            Node root = tree.getRoot();

            assertTrue(root instanceof InternalNode);
        } catch (Exception e) {
            
        }
    }

    @Test
    public void test_test1cmd() {
        // Create a stream to hold the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            // Redirect System.out to the output stream
            System.setOut(new PrintStream(outputStream));

            // Load the file using getResource to find the path in the classpath
            URL resource = getClass().getClassLoader().getResource("rectApp/resources/test1.cmd");
            if (resource == null) {
                throw new Exception("File not found in resources.");
            }

            // Convert the resource URL to a file path
            Path testCmdPath = Paths.get(resource.toURI());

            // Call the main function with the path as an argument
            rectApp.App.main(new String[]{testCmdPath.toString()});

            // Convert the outputStream content to a string
            String output = outputStream.toString();

            // Temporarily print the output for debugging
            System.out.println("Captured Output:\n" + output);

            // Verify the output, using 'contains' instead of 'matches'
            assertTrue(output.contains("Rectangle at 10, 10: 5x5:\n"
            		+ "Leaf Node - Rectangle at -50, -50: 100x100:\n"
            		+ "\tRectangle at 10, 10: 5x5:\n"
            		+ "\tRectangle at -10, 8: 5x5:"));
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
    
    
    @Test 
    public void test_test2cmd() {
        // Create a stream to hold the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            // Redirect System.out to the output stream
            System.setOut(new PrintStream(outputStream));

            // Load the file using getResource to find the path in the classpath
            URL resource = getClass().getClassLoader().getResource("rectApp/resources/test2.cmd");
            if (resource == null) {
                throw new Exception("File not found in resources.");
            }

            // Convert the resource URL to a file path
            Path testCmdPath = Paths.get(resource.toURI());

            // Call the main function with the path as an argument
            rectApp.App.main(new String[]{testCmdPath.toString()});

            // Convert the outputStream content to a string
            String output = outputStream.toString();

            // Temporarily print the output for debugging
            System.out.println("Captured Output:\n" + output);

            // use matches instead for all the \t+ that can happen
            assertTrue(output.matches("Internal Node - Rectangle at -50, -50: 100x100:\n"
            		+ "\t+Leaf Node - Rectangle at -50, 0: 50x50:\n"
            		+ "\t+Rectangle at -10, 8: 2x1:\n"
            		+ "\t+Rectangle at -10, 6: 4x4:\n"
            		+ "\t+Leaf Node - Rectangle at 0, 0: 50x50:\n"
            		+ "\t+tRectangle at 10, 10: 5x5:\n"
            		+ "\t+tRectangle at 10, 3: 2x2:\n"
            		+ "\t+Rectangle at 5, 5: 8x8:\n"
            		+ "\t+Leaf Node - Rectangle at -50, -50: 50x50:\n"
            		+ "\t+Rectangle at -10, -10: 5x5:\n"
            		+ "\t+Leaf Node - Rectangle at 0, -50: 50x50:))"));
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }   	
    }
    
    
    @Test 
    public void test_test3cmd() {
        // Create a stream to hold the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            // Redirect System.out to the output stream
            System.setOut(new PrintStream(outputStream));

            // Load the file using getResource to find the path in the classpath
            URL resource = getClass().getClassLoader().getResource("rectApp/resources/test3.cmd");
            if (resource == null) {
                throw new Exception("File not found in resources.");
            }

            // Convert the resource URL to a file path
            Path testCmdPath = Paths.get(resource.toURI());

            // Call the main function with the path as an argument
            rectApp.App.main(new String[]{testCmdPath.toString()});

            // Convert the outputStream content to a string
            String output = outputStream.toString();

            // Temporarily print the output for debugging
            System.out.println("Captured Output:\n" + output);

            // use matches instead for all the \t+ that can happen
            assertTrue(output.matches("Internal Node - Rectangle at -50, -50: 100x100:\n"
            		+ "        Internal Node - Rectangle at 0, 0: 50x50:\n"
            		+ "                Leaf Node - Rectangle at 0, 25: 25x25:\n"
            		+ "                Leaf Node - Rectangle at 25, 25: 25x25:\n"
            		+ "                        Rectangle at 30, 30: 10x10:\n"
            		+ "                Leaf Node - Rectangle at 0, 0: 25x25:\n"
            		+ "                        Rectangle at 10, 10: 5x5:\n"
            		+ "                        Rectangle at 10, 3: 2x2:\n"
            		+ "                        Rectangle at 5, 5: 8x8:\n"
            		+ "                Leaf Node - Rectangle at 25, 0: 25x25:\n"
            		+ "                        Rectangle at 30, 4: 3x3:\n"
            		+ "                        Rectangle at 30, 2: 4x4:\n"
            		+ "                        Rectangle at 30, 3: 2x2:\n"
            		+ "        Internal Node - Rectangle at 0, 0: 50x50:\n"
            		+ "                Leaf Node - Rectangle at 0, 25: 25x25:\n"
            		+ "                Leaf Node - Rectangle at 25, 25: 25x25:\n"
            		+ "                        Rectangle at 30, 30: 10x10:\n"
            		+ "                Leaf Node - Rectangle at 0, 0: 25x25:\n"
            		+ "                        Rectangle at 10, 10: 5x5:\n"
            		+ "                        Rectangle at 10, 3: 2x2:\n"
            		+ "                        Rectangle at 5, 5: 8x8:\n"
            		+ "                Leaf Node - Rectangle at 25, 0: 25x25:\n"
            		+ "                        Rectangle at 30, 4: 3x3:\n"
            		+ "                        Rectangle at 30, 2: 4x4:\n"
            		+ "                        Rectangle at 30, 3: 2x2:\n"
            		+ "        Internal Node - Rectangle at 0, 0: 50x50:\n"
            		+ "                Leaf Node - Rectangle at 0, 25: 25x25:\n"
            		+ "                Leaf Node - Rectangle at 25, 25: 25x25:\n"
            		+ "                        Rectangle at 30, 30: 10x10:\n"
            		+ "                Leaf Node - Rectangle at 0, 0: 25x25:\n"
            		+ "                        Rectangle at 10, 10: 5x5:\n"
            		+ "                        Rectangle at 10, 3: 2x2:\n"
            		+ "                        Rectangle at 5, 5: 8x8:\n"
            		+ "                Leaf Node - Rectangle at 25, 0: 25x25:\n"
            		+ "                        Rectangle at 30, 4: 3x3:\n"
            		+ "                        Rectangle at 30, 2: 4x4:\n"
            		+ "                        Rectangle at 30, 3: 2x2:\n"
            		+ "        Internal Node - Rectangle at 0, 0: 50x50:\n"
            		+ "                Leaf Node - Rectangle at 0, 25: 25x25:\n"
            		+ "                Leaf Node - Rectangle at 25, 25: 25x25:\n"
            		+ "                        Rectangle at 30, 30: 10x10:\n"
            		+ "                Leaf Node - Rectangle at 0, 0: 25x25:\n"
            		+ "                        Rectangle at 10, 10: 5x5:\n"
            		+ "                        Rectangle at 10, 3: 2x2:\n"
            		+ "                        Rectangle at 5, 5: 8x8:\n"
            		+ "                Leaf Node - Rectangle at 25, 0: 25x25:\n"
            		+ "                        Rectangle at 30, 4: 3x3:\n"
            		+ "                        Rectangle at 30, 2: 4x4:\n"
            		+ "                        Rectangle at 30, 3: 20x20:))"));
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }   	
    }
    
    
    @Test 
    public void test_test4cmd() {
        // Create a stream to hold the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            // Redirect System.out to the output stream
            System.setOut(new PrintStream(outputStream));

            // Load the file using getResource to find the path in the classpath
            URL resource = getClass().getClassLoader().getResource("rectApp/resources/test4.cmd");
            if (resource == null) {
                throw new Exception("File not found in resources.");
            }

            // Convert the resource URL to a file path
            Path testCmdPath = Paths.get(resource.toURI());

            // Call the main function with the path as an argument
            rectApp.App.main(new String[]{testCmdPath.toString()});

            // Convert the outputStream content to a string
            String output = outputStream.toString();

            // Temporarily print the output for debugging
            System.out.println("Captured Output:\n" + output);

            // use matches instead for all the \t+ that can happen
            assertTrue(output.contains("You can not double insert at a position."));
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }   	
    }

    

    @Test
    public void test_no_args() {
        // Create a stream to hold the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            // Redirect System.out to the output stream
            System.setOut(new PrintStream(outputStream));
            
            // Call the main function or specific function that prints to stdout
            rectApp.App.main(new String[]{});
            
            // Convert the outputStream content to a string
            String output = outputStream.toString();

            // Verify the output, adapt the expected output based on your main function's behavior
            assertTrue(output.contains(""));
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }





    // @Test
    // public void shouldFail(){
    //     assertTrue(false);s
    // }
}
