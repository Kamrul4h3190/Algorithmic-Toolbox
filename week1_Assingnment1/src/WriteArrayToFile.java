import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteArrayToFile {

    public static void main(String[] args) throws IOException {
        //int[] intArr = {1,2,3,4,5};
        //String fileName= "C:\\Users\\Arpit\\Desktop\\TxtFiles\\temp.txt";
        String fileName= "F:\\DSA_UCSD_SPEC\\course1\\course1_starters\\week1_Assingnment1\\src\\dataset.txt";
        write(fileName);
    }
    public static void write (String filename) throws IOException {
        BufferedWriter ow = null;
        ow = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < 2*Math.pow(10,5); i++) {

            ow.write(i+1+"");
            ow.newLine();
        }
        ow.flush();
        ow.close();
    }
}