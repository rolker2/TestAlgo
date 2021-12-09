package code;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAccess {
    public FileAccess(){}

    /**
     * Get input string from input file
     * @param input_path
     * @param target_line
     * @return
     */
    public String inputReader(String input_path, int target_line){
        String result="";
        try{
            result = Files.readAllLines(Paths.get(input_path)).get(target_line);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Write result on output file
     * @param output_path
     * @param content
     */
    public void outputWriter(String output_path, String content){
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(new FileWriter(output_path,true));
            writer.println("Texte valide : " +content);
        }catch(IOException exc){
            exc.printStackTrace();
        }
        finally{
            if(writer != null){
                writer.close();
            }
        }
    }
}
