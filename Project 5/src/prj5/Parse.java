/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Devon
 *
 */
public class Parse {
    private LinkedList<Influencer> list;

    public Parse(String fileName) throws FileNotFoundException {

        list = readInputFile(fileName);
    }


    public LinkedList<Influencer> readInputFile(String fileName)
        throws FileNotFoundException {
        list = new LinkedList<Influencer>();
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",\\s*");
            String tokens[] = new String[10];
            int tokenCount = 0;
            while (currLine.hasNext() && tokenCount < 9) {
                tokens[tokenCount++] = currLine.next();
            }
            currLine.close();
            int likes = Integer.valueOf(tokens[5]);
            int posts = Integer.valueOf(tokens[6]);
            int followers = Integer.valueOf(tokens[7]);
            int comments = Integer.valueOf(tokens[8]);
            int views = Integer.valueOf(tokens[9]);

            list.add(new Influencer(tokens[0], tokens[1], tokens[2], tokens[3],
                tokens[4], likes, posts, followers, comments, views));

        }
        return list;
    }
}
