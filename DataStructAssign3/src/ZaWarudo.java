import java.io.*;
import java.util.*;
public class ZaWarudo {

    public static void main(String[] args) throws FileNotFoundException {

        UnbalancedTreeMap tool = new UnbalancedTreeMap();

        TreeMap<String, Integer> tree = new TreeMap<String, Integer>();


        long totalTime = 0;
        long startTime = 0;

        System.out.println("Scenario 1: ");

        try {

            String word = "";
            for (int i = 1; i <= 77; i++) {
                String filefolder = "C:\\Users\\garci\\IdeaProjects\\dataAssign3\\src\\HCAndersen Tales\\";
                String filePath = i + ".okpuncs";
                String path = filefolder + filePath;

                File data = new File(path);

                Scanner scanner = new Scanner(data);

                while (scanner.hasNext()) {

                    startTime = System.nanoTime();
                    word = scanner.next();

                    tool.put(word, (1+tool.get(word)));


                }

                long endTime = System.nanoTime();
                totalTime = endTime - startTime;
                System.out.println("The " + i + "th story " + "has a runtime of: " + totalTime);

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //this null guess this KeySet() is not define only returns null.
        System.out.println(tool.keySet());

        System.out.println("Scenario 2: ");
        long totalTime2 = 0;
        long startTime2 = 0;
        try {
            String word;
            for (int i = 1; i <= 77; i++) {
                String filefolder = "C:\\Users\\garci\\IdeaProjects\\dataAssign3\\src\\HCAndersen Tales\\";
                String filePath = i + ".okpuncs";
                String path = filefolder + filePath;

                File data = new File(path);

                Scanner scanner = new Scanner(data);

                while (scanner.hasNext()) {

                    startTime2 = System.nanoTime();
                    word = scanner.next();

                    tree.put(word, (tree.get(word)));


                }

                long endTime2 = System.nanoTime();
                totalTime2 = endTime2 - startTime2;
                System.out.println("The " + i + "th story " + "has a runtime of: " + totalTime2);

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Prints the inOrder Tranverse
        System.out.println(tree.keySet());


    }
}