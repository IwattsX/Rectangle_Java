package rectApp;

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





    // @Test
    // public void shouldFail(){
    //     assertTrue(false);s
    // }
}
