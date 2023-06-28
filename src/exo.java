import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This example shows two mehod implementation that remove a string from a list of strings
 * One method uses traditional Java 7 features and other uses basic modern Java features.
 */

public class exo {
    public static void main(String[] args) {

        String[] nameArray = {
                "Barbara", "James", "Mary", "John", "Robert", "Michael", "Linda", "James", "Mary"
        };

        //Remove "Robert" from the list created from newArray.
        List<String> l1 = zap7(List.of(nameArray), "Robert");

        //Remove "Robert" from the list created from newArray.
        List<String> l2 = zapModern(List.of(nameArray), "Robert");
        
        //Check to ensure the zap*() methods work
        if(l1.contains("Robert") || l2.contains("Robert")){
            System.out.println("Test failed");
        }else{
            System.out.println("Test succeeded");
        }
            
        }

    /**
     * Remove any string matching {@code omit} from the list of string using modern Java features.
     */
    private static List<String> zapModern(List<String> lines, String omit) {

        return lines.stream()
                .filter(s->(!s.equals(omit)))
                .collect(Collectors.toList());
    }

    /**
     * Remove any string matching {@code omit} from the list of string using basic Java 7 features.
     */
    static List<String> zap7(List<String> lines, String omit){
        
        List<String> ans = new ArrayList<>();

        for (String name:lines) {
            if(!name.equals(omit)){
                ans.add(name);
            }
        }
        
        return ans;
    }
}