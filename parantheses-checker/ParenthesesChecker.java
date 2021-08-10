import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * class for the checking file's all opening parentheses('{') are matching
 * with closing ones('}')
 *
 * problem solved with using stack
 *
 * @author mustafa arinmis
 * @since 16.12.2020
 *
 */
public class ParenthesesChecker {

    public static void main(String[] args) throws FileNotFoundException{
        if (args.length != 1) {
            System.out.println("java ParenthesesChecker <FileName>"); 
        }
        File file = new File(args[0]); //read file directory from console
        if(!file.exists())
            throw new FileNotFoundException(file + " was not found");
        
        if (isMatched(file))
            System.out.println("Great code, all parentheses were matched");
        else
            System.out.println("Error: mismatching is founded");

    }

    public static boolean isMatched(File file) {
        Stack<String> stack = new Stack<>(); // all opening parentheses represented by 0

        try(Scanner input = new Scanner(file)) {

            while (input.hasNext()) {
                String word = input.next();
                if(word.contains("{")) {
                    for(int i=0; i<charCount('{', word); i++){
                     stack.push("{"); // push "{"
                    }
             }

                if(word.contains("}")) {
                     for(int i=0; i<charCount('}', word); i++){
                        if(!stack.isEmpty())
                         stack.pop(); // if there is matching  "{", pop the "}"
                        else
                            return false; // if there is "}" without "{" there must be mismatching
                }
            }
        }

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        if(!stack.isEmpty())
            return false; // there are mismatched "{"
        else{
            return true;
        }
     }

     public static int charCount(char chr, String target) {
        // return how many times given char appeared in the target string
         int counter = 0;
         for(char letter : target.toCharArray()) {
             if(chr == letter)
                 counter++;
         }
         return counter;
     }

}
