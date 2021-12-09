package code;

import java.util.HashMap;
import java.util.Map;  

public class Converter {
    public Converter(){}

    /**
     * Build a map to convert characters to integer
     * @return conversion_table
     */
   public Map<Character,Integer> getConversionTable(){
    Map<Character, Integer> conversion_table = new HashMap<Character, Integer>();
    char[] key_list = "ABCDEFGHJKLMNPRSTUVWXYZ".toCharArray();
    int [] value_list = {1,2,3,4,5,6,7,8,1,2,3,4,5,7,9,2,3,4,5,6,7,8,9};

    for(int i = 0; i< key_list.length; i++){
        conversion_table.put(key_list[i], value_list[i]);
    }

    return conversion_table;
   }


   /**
    * Convert a chararacter from the input string to an int value
    using the conversion table
    * @param input_char
    * @return
    */
   public int convert(char input_char){
    Map<Character, Integer> conversion_table = getConversionTable();
       int res = 0;
       if(Character.isDigit(input_char)){
           res = Character.getNumericValue(input_char);
       }else{
           if(conversion_table.containsKey(Character.toUpperCase(input_char))){
               res = conversion_table.get(Character.toUpperCase(input_char));
           }
       }
       return res;
   }    
}
