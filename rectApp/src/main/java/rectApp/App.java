package rectApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// give this an absolute filepath

public class App {
    public static void main(String[] args) {
        ArrayList<String> commands = new ArrayList<String>();
        QuadTree tree = new QuadTree();


        try{
            for(int i = 0; i<args.length; i++){
                Scanner in = new Scanner(new File(args[i]));
                
                while(in.hasNextLine()){
                    commands.add(in.nextLine());
                }
                in.close(); 
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }        
        System.out.printf("The commands being ran are \n%s\n",commands);


        for(int i =0; i<commands.size(); i++){
            try{
                String cmd = commands.get(i).toLowerCase();

                if(cmd.startsWith("insert")){
                    String[] insertInput = parse_InsertInput(cmd);

                    int x, y, l, w;
                    x = Integer.valueOf(insertInput[1]);
                    y = Integer.valueOf(insertInput[2]);

                    l = Integer.valueOf(insertInput[3]);
                    w = Integer.valueOf(insertInput[4]);


                    Rectangle rectangle = new Rectangle(x, y, l, w);
                    tree.insert(rectangle);
                    // Add an insert handler here
                }
                else if(cmd.startsWith("find")){

                    String[] findInput = parse_FindInput(cmd);
                    int x, y;

                    x = Integer.valueOf(findInput[1]);
                    y = Integer.valueOf(findInput[2]);

                    System.out.println(Arrays.toString(findInput));
                    //Add a handler

                    Rectangle res = tree.find(x,y);

                    System.out.printf("Rectangle at %d, %d: %dx%d:\n", res.point.x, res.point.y, res.length, res.width);

                }
                else if(cmd.startsWith("delete")){
                    String[] deleteInput = parse_DeleteInput(cmd);

                    int x, y;

                    x = Integer.valueOf(deleteInput[1]);
                    y = Integer.valueOf(deleteInput[2]);

                    System.out.println(Arrays.toString(deleteInput));
                    //Add a handler

                    tree.delete(x,y);
                }   
                else if(cmd.startsWith("update")){
                    String[] updateInput = parse_UpdateInput(cmd);
                    
                    int x, y, l, w;

                    x = Integer.valueOf(updateInput[1]);
                    y = Integer.valueOf(updateInput[2]);
                    l = Integer.valueOf(updateInput[3]);
                    w = Integer.valueOf(updateInput[4]);

                    System.out.println(Arrays.toString(updateInput));
                    //Add a handler

                    tree.update(x,y,l,w);

                }

                else if(cmd.startsWith("dump;")){
                    tree.dump(0);
                }

                else{
                    throw new Exception("Invalid command");
                }

            }
            catch(Exception e){
                System.out.println(e.getMessage());
                return;
            }
            
        }
        
        
    }
    
    
    /** 
     * parses an input that contains "insert" in it
     * Format it parses is "Insert X Y L W"
     * @param cmd
     * @return String[]
     * @throws Exception 
     */
    private static String[] parse_InsertInput(String cmd) throws Exception{
        Scanner in = new Scanner(cmd);
        String[] res = new String[5];
        int counter = 0;
        while(in.hasNext() && counter < res.length){
            String tmp = in.next();
            if(tmp.contains(";")){
                res[counter] = tmp.substring(0, tmp.length() - 1);
            }
            else{
                res[counter] = tmp;
            }
            counter++;
        }

        
        if(counter < 5 || in.hasNext()){
            in.close();
            throw new Exception("Cannot parse the input " + cmd);
        }
        in.close();

        return res;
    }
   
    /** 
     * parses an input that contains "find" in it
     * Format it parses is "find X Y"
     * @param cmd
     * @return String[]
     * @throws Exception 
     */
    private static String[] parse_FindInput(String cmd) throws Exception{
        Scanner in = new Scanner(cmd);
        String[] res = new String[3];

        int counter = 0;
        while(in.hasNext() && counter < res.length){
            String tmp = in.next();
            if(tmp.contains(";")){
                res[counter] = tmp.substring(0, tmp.length() - 1);
            }
            else{
                res[counter] = tmp;
            }
            counter++;
        }

        
        if(counter < 3 || in.hasNext()){
            in.close();
            throw new Exception("Cannot parse the input " + cmd);
            
        }
        in.close();

        return res;
    }


        /** 
     * parses an input that contains "delete" in it
     * Format it parses is "delete X Y"
     * @param cmd
     * @return String[]
     * @throws Exception 
     */
    private static String[] parse_DeleteInput(String cmd) throws Exception{
        Scanner in = new Scanner(cmd);
        String[] res = new String[3];

        int counter = 0;
        while(in.hasNext() && counter < res.length){
            String tmp = in.next();
            if(tmp.contains(";")){
                res[counter] = tmp.substring(0, tmp.length() - 1);
            }
            else{
                res[counter] = tmp;
            }
            counter++;
        }

        
        if(counter < 3 || in.hasNext()){
            in.close();
            throw new Exception("Cannot parse the input " + cmd);
            
        }
        in.close();

        return res;
    }

        /** 
     * parses an input that contains "update" in it
     * Format it parses is "update X Y L W"
     * @param cmd
     * @return String[]
     * @throws Exception 
     */
    private static String[] parse_UpdateInput(String cmd) throws Exception{
        Scanner in = new Scanner(cmd);
        String[] res = new String[5];

        int counter = 0;
        while(in.hasNext() && counter < res.length){
            String tmp = in.next();
            if(tmp.contains(";")){
                res[counter] = tmp.substring(0, tmp.length() - 1);
            }
            else{
                res[counter] = tmp;
            }
            counter++;
        }

        
        if(counter < 5 || in.hasNext()){
            in.close();
            throw new Exception("Cannot parse the input " + cmd);
            
        }
        in.close();

        return res;
    }
}

/**
 * Insert X Y L W
Insert a rectangle into the quadtree as the specified X and Y coordinates with the specified length and
width. If there is already a rectangle at the specified position, your program should terminate, and you
should print a message saying, “You can not double insert at a position.”
 */