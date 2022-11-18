/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * @author Devon
 *
 */
public class Input {
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length > 0) {
            new Parse<Object>(args[0]);
        }
        else {
            new Parse<Object>("SampleInput1_2022.csv");
        }
    }
}
