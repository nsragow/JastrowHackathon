import java.lang.reflect.Array;

/**
 * Created by Aryeh on 10/28/2017.
 */
public class JastrowTwo {
    String [] myInfo;
    public JastrowTwo(){

    }

    public static void main (String [] args){
        JastrowTwo tester= new JastrowTwo();
        tester.start();
        tester.search("אבה");
    }

    private void start(){
        myInfo = splitFile();
        // myInfo =  new String[10];
        // myInfo[0]= "א";
        // myInfo[1] = "אב";
        // myInfo[2]= "אבד";
        // myInfo[3] = "אבוי";
        // myInfo[4] = "אבטוניות";
        //TAKE OUT PAGE 700


    }

    public void search(String input){
        int answer= search(input, 0, 5);
        System.out.println(answer);

    }

    private int search(String input, int low, int high){
        int mid= (high+low)/2;
        String a = myInfo[mid];
        if(low>=high){
            return low;
        }
        else if (input.compareTo(a)==0){
            return mid;
        }else if(input.compareTo(a)>0){
            low=mid+1;
            return search(input, low, high);
        }else if(input.compareTo(a)<0){
            high=mid-1;
            return search(input, low, high);
        }
        return 0;
    }

    public static String[] splitFile() throws IOException {
        String[] result = new String[1653];
        String line;
        int i = 0;
        try (
            FileInputStream fis = new FileInputStream("FILEPATH");  //Specify filepath for jastrow.txt (list of header words in hebrew)
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                for (String n : line.split(" ")) {
                    result[i] = n;
                    i++;
                }
            }
        }
        return result;
    }
}
