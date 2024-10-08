package rectApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/** Contains the main method driver code */
public class App {
    
    /** 
     * Driver code
     * @param args : String[] arguments ran in command line
     */
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
        // System.out.printf("The commands being ran are \n%s\n",commands);


        for(int i =0; i<commands.size(); i++){
            try{
                String cmd = commands.get(i).toLowerCase();

                if(cmd.startsWith("insert")){
                    String[] insertInput = parse_InsertInput(cmd);

                    float x, y, l, w;
                    x = Float.parseFloat(insertInput[1]);
                    y = Float.parseFloat(insertInput[2]);

                    l = Float.parseFloat(insertInput[3]);
                    w = Float.parseFloat(insertInput[4]);


                    Rectangle rectangle = new Rectangle(x, y, l, w);
                    tree.insert(rectangle);

                }
                else if(cmd.startsWith("find")){

                    String[] findInput = parse_FindInput(cmd);
                    float x, y;

                    x = Float.parseFloat(findInput[1]);
                    y = Float.parseFloat(findInput[2]);



                    Rectangle res = tree.find(x,y);

                    System.out.println(res.toString());

                }
                else if(cmd.startsWith("delete")){
                    String[] deleteInput = parse_DeleteInput(cmd);

                    float x, y;

                    x = Float.parseFloat(deleteInput[1]);
                    y = Float.parseFloat(deleteInput[2]);

                    tree.delete(x,y);
                }   
                else if(cmd.startsWith("update")){
                    String[] updateInput = parse_UpdateInput(cmd);
                    
                    float x, y, l, w;

                    x = Float.parseFloat(updateInput[1]);
                    y = Float.parseFloat(updateInput[2]);
                    l = Float.parseFloat(updateInput[3]);
                    w = Float.parseFloat(updateInput[4]);

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
     * Format it parses is "Insert X Y L W;"
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
     * Format it parses is "find X Y;"
     * @param cmd
     * @return String[] A string that contains ["find", "x", "y"]
     * @throws Exception if that command is invalid
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
     * Format it parses is "delete X Y;"
     * @param cmd
     * @return String[] : A string[] that contains ["delete", "X", "Y"]
     * @throws Exception if that command is invalid
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
     * Format it parses is "update X Y L W;"
     * @param cmd
     * @return String[] : String[] that contains ["update", "X", "Y", "L" , "W"]
     * @throws Exception if that command is invalid
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