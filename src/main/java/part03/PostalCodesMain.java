package part03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This part of the exercise is tested manually through the user interface, not
 * with unit tests.
 *
 * Test the functionality of your solution by running the `main` method, giving
 * inputs and checking the outputs.
 */

public class PostalCodesMain {

    /**
     * Implement your logic in this method. You can also add your own methods and
     * classes if needed.
     *
     * Your program should handle displaying postal codes and postal district names
     * in both directions. For example, if the user enters "00100", the program
     * should print "Helsinki". If the user enters "Helsinki" as their input, the
     * program should print "00100" along with all other postal codes for
     * Helsinki in ascending order.
     *
     * The program should not handle partial matches. For example, if the user
     * enters "001", the program should not display any results. However, the
     * program should be case-insensitive. For example, the program should display
     * "00100" whether the user enters "helsinki" or "HELSINKI".
     */
    public static void main(String[] args) {
        /*
         * This map contains data that is read from the JSON file. You don't need to
         * inspect the file handling in this exercise, but you can if you want to.
         *
         * The keys in the map are postal codes and the values are postal district
         * names.
         */
        
        Map<String, String> postalCodes = PostalCodesReader.readPostalCodes();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input postal code or district (e.g., 00100 or Helsinki): ");
        String answer = scanner.nextLine(); // answer may be a postal code or a postal district name

        if (postalCodes.containsKey(answer)) {
            System.out.print(postalCodes.get(answer));
        } else {
            List<String> postalcode = new ArrayList<>();
                for (Map.Entry<String, String> string : postalCodes.entrySet()) {
                    if (string.getValue().equalsIgnoreCase(answer)) {
                        postalcode.add(string.getKey());
                    }
                }
                for (int i = 0; i < postalcode.size(); i++) {
                    for (int j = i + 1; j < postalcode.size(); j++) {
                        if (postalcode.get(i).compareTo(postalcode.get(j)) > 0) {
                            String valiaikainenPostinumero = postalcode.get(i);
                            postalcode.set(i, postalcode.get(j));
                            postalcode.set(j, valiaikainenPostinumero);
                        }
                        
                    }

                    
                }
                
                System.out.print(postalcode);
        }


        scanner.close();
    }
}
