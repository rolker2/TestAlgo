package code;

class Validator{
    private static Converter converter = new Converter();

    /**
     * Print table element
     * @param title
     * @param tab
     */
    public static void printTab(String title,int [] tab){
         // Lines just to print results on console
         int tab_length = tab.length;
         for(int i = 0; i<tab_length; i++){
            if(i == 0){
                System.out.print(title+ " : " +tab[0] + " ");
            }else if( i == tab_length - 1){
                System.out.println(tab[tab_length - 1]+ " ");
            }else{
                System.out.print(tab[i]+ " ");
            }
           
        }
    }

    /**
     * Convert the input string in parameter to an array of int
     * step: 1
     * @param input
     * @return table of int from conversion
     */
    public static int[] convertInput(String input){
        char[] initial = input.toCharArray();
        int [] result = new int[initial.length];
        for(int i = 0; i<initial.length; i++){
            result[i] = converter.convert(initial[i]);
        }
        return result;
    }

    /**
     * Multiply the converted table to the weight table
     * step:2
     * @param converted
     * @return the weighted table of the converted input.
     */
    public static int[] multiplyToLength(int[] converted){
        int[] character_length = {8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2};
        int[] weighted  = new int[converted.length];

        for(int i = 0; i < converted.length; i++){
            weighted [i] = converted[i] * character_length[i];
        }
        return weighted ;
    }

    /**
     * Get the sum of all table content
     * step:3
     * @param tab
     * @return the sum of tab content in param
     */
    public static int tabSummer(int [] tab){
        int res = 0;
        for(int i = 0; i<tab.length; i++){
            res += tab[i];
        }
        return res;
    }

    /**
     * Verify if the input string is valid or not
     * step 5
     * @param input
     * @param modulo_value
     * @return a boolean value meaning the validy of the input.
     */
    public static boolean validator(String input, int modulo_value){
        boolean string_valid = false;
        System.out.println(input.charAt(8));
        if(modulo_value == Character.getNumericValue(input.charAt(8))){
            string_valid = true;
        }else if(modulo_value == 10 && (Character.toUpperCase(input.charAt(8)) == 'X' )){
            string_valid = true;
        }else{
            string_valid = false;
        }
        return string_valid;
    }
  
    public static void main(String[] args) {
        FileAccess file_access = new FileAccess();
    
        String input_string = file_access.inputReader("test.txt",0);
        System.out.println("initial :" +input_string);
        int [] converted = convertInput(input_string);
       
        printTab("Conversion",converted);
        int [] weighted_table = multiplyToLength(converted);

        printTab("poids",weighted_table);


        int weighted_sum = tabSummer(weighted_table);

        // Calculate the modulo 11 of the weighted_sum <=> step: 4
        int modulo_sum = weighted_sum % 11;

        System.out.println("Somme pondéré :" +weighted_sum);
        System.out.println("Modulo :" +modulo_sum);

        //Step 5: Validation
        if(validator(input_string, modulo_sum) == true){
            file_access.outputWriter("result.txt", " OUI");
        }else{
            file_access.outputWriter("result.txt", " NON");
        }

    }
}
