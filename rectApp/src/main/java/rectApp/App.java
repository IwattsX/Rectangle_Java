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
        System.out.printf("The commands being ran are %s\n",commands);


        for(int i =0; i<commands.size(); i++){
            try{
                if(commands.get(i).startsWith("insert")){
                    String[] insertInput = parse_InsertInput(commands.get(i));
                    System.out.println("Insert command being instantiated");

                    System.out.println(Arrays.toString(insertInput));
                    
                }    
            }
            catch(Exception e){
                System.out.println(e);
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
        in.close();
        
        if(counter < 5){
            throw new Exception("Cannot parse the input " + cmd);
        }

        return res;
    }
    
}

/**
 * Insert X Y L W
Insert a rectangle into the quadtree as the specified X and Y coordinates with the specified length and
width. If there is already a rectangle at the specified position, your program should terminate, and you
should print a message saying, “You can not double insert at a position.”
 */