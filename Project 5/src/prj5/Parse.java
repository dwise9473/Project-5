/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import prj5.LinkedList.Node;

/**
 * @author Devon
 * @param <E>
 *
 */
public class Parse<E> {
    private LinkedList<Influencer> listJan;
    private LinkedList<Influencer> listFeb;
    private LinkedList<Influencer> listMar;
    private LinkedList<Influencer> listApr;
    private LinkedList<Influencer> listMay;
    private LinkedList<Influencer> listJun;
    private LinkedList<Influencer> listJul;
    private LinkedList<Influencer> listAug;
    private LinkedList<Influencer> listSep;
    private LinkedList<Influencer> listOct;
    private LinkedList<Influencer> listNov;
    private LinkedList<Influencer> listDec;

    public Parse(String fileName) throws FileNotFoundException {
        listJan = new LinkedList<Influencer>();
        listFeb = new LinkedList<Influencer>();
        listMar = new LinkedList<Influencer>();
        listApr = new LinkedList<Influencer>();
        listMay = new LinkedList<Influencer>();
        listJun = new LinkedList<Influencer>();
        listJul = new LinkedList<Influencer>();
        listAug = new LinkedList<Influencer>();
        listSep = new LinkedList<Influencer>();
        listOct = new LinkedList<Influencer>();
        listNov = new LinkedList<Influencer>();
        listDec = new LinkedList<Influencer>();
        readInputFile(fileName);
        print();
    }


    public void readInputFile(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        file.nextLine();
        while (file.hasNextLine()) {
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",\\s*");
            String tokens[] = new String[10];
            int tokenCount = 0;
            while (currLine.hasNext() && tokenCount < 10) {
                tokens[tokenCount++] = currLine.next();
            }
            currLine.close();
            int likes = Integer.valueOf(tokens[5]);
            int posts = Integer.valueOf(tokens[6]);
            int followers = Integer.valueOf(tokens[7]);
            int comments = Integer.valueOf(tokens[8]);
            int views = Integer.valueOf(tokens[9]);
            if (tokens[0].equals("January")) {
                listJan.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            if (tokens[0].equals("February")) {
                listFeb.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("March")) {
                listMar.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("April")) {
                listApr.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("May")) {
                listMay.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("June")) {
                listJun.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("July")) {
                listJul.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("August")) {
                listAug.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("Spetember")) {
                listSep.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("October")) {
                listOct.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("November")) {
                listNov.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
            else if (tokens[0].equals("December")) {
                listDec.add(new Influencer(tokens[0], tokens[1], tokens[2],
                    tokens[3], tokens[4], likes, posts, followers, comments,
                    views));
            }
        }
    }


    public void print() {
        LinkedList<Influencer> tempJan = sortChannelName(listJan);
        LinkedList<Influencer> tempFeb = sortChannelName(listFeb);
        LinkedList<Influencer> tempMar = sortChannelName(listMar);
        int index = 0;
        int size = tempJan.size();
        int[] totalEngage = new int[tempJan.size()];
        while (index < tempJan.size()) {
            totalEngage[index] = tempJan.get(index).getTotalEngagement()
                + tempFeb.get(index).getTotalEngagement() + tempMar.get(index)
                    .getTotalEngagement();
            index++;
        }

        for (int i = 0; i < tempJan.size(); i++) {
            float a = (totalEngage[i]);
            float b = tempMar.get(i).getFollowers();
            float traditional = (a / b) * 100;
            DecimalFormat df = new DecimalFormat("#.#");
            System.out.println(tempJan.get(i).getChannelName());
            System.out.println("traditional : " + df.format(traditional));
            System.out.println("==========");
        }

    }


    public LinkedList<Influencer> sortChannelName(LinkedList<Influencer> list) {
        // sorts through the linked list based on channel name
        LinkedList<Influencer> tempList = list;
        LinkedList<Influencer> newList = new LinkedList<Influencer>();
        Influencer current = list.get(0);
        String name = list.get(0).getChannelName();
        int index = 0;

        if (list.size() > 1) {
            while (tempList.size() != 0) {
                for (int i = 1; i < list.size(); i++) {
                    int nextNameLength = list.get(i).getChannelName().length();
                    int minstr = Math.min(name.length(), nextNameLength);
                    for (int j = 0; j < minstr; j++) {
                        int thisChar = (int)name.charAt(j);
                        int otherChar = (int)list.get(i).getChannelName()
                            .charAt(j);

                        if (otherChar > thisChar) {
                            j = minstr;
                        }
                        else if (otherChar < thisChar) {
                            current = list.get(i);
                            name = list.get(i).getChannelName();
                            index = i;
                            j = minstr;
                        }
                    }
                }
                newList.add(current);
                tempList.remove(index);
                current = list.get(0);
                name = list.get(0).getChannelName();
            }
        }
        else {
            return list;
        }
        return newList;
    }
}
