package rectApp;

import java.io.File;
import java.util.ArrayList;
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
        catch(Exception e){

        }
        finally{
            System.out.println(commands);
        }
    }
    
}
