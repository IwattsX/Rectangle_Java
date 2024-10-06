package rectApp;

import java.util.ArrayList;

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





    // @Test
    // public void shouldFail(){
    //     assertTrue(false);s
    // }
}
