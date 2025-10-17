import java.io.*;
public class CricketRunsScored extends Cricket{
    public CricketRunsScored(String Batsman, String Stadium, int RunsScored) {
        super(Batsman, Stadium, RunsScored);
    }

    public String printReport(){
        System.out.println("BATSMAN RUNS SCORED REPORT");
        System.out.println("**********************************");
        System.out.println("CRICKET PLAYER: "+getBatsman());
        System.out.println("STADIUM: "+getStadium());
        System.out.println("TOTAL RUNS SCORED: "+getRunsScored());
        return getBatsman()+getStadium()+getRunsScored();
    }

    String fileName ="user_input.txt";

    public void savetothefile(){
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write("BATSMAN RUNS SCORED REPORT\n"+"**********************************\n"+
                    "CRICKET PLAYER: "+getBatsman()+"\n"+
                    "STADIUM: "+getStadium()+"\n"+"TOTAL RUNS SCORED: "+getRunsScored()+"\n");
        } catch (Exception e) {
            System.out.println("Error writing to file:" + e.getMessage());
        }
    }

    //the purpose of this method is to read from the data given and to display it in the file
    public void readfromfile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("user_input.txt"))){

            String read;
            while ((read=reader.readLine())!=null){
                System.out.println(read);
            }
            System.out.println("\nData has been read successfully from user_input.txt\n");
        } catch (IOException e) {
            System.out.println("Error reading from file:" + e.getMessage());
        }
    }
}