public abstract class Cricket implements ICricket {
    public String Batsman;
    public String Stadium;
    public int RunsScored;

    public Cricket(String Batsman,  String Stadium, int RunsScored){
        this.Batsman=Batsman;
        this.Stadium= Stadium;
        this.RunsScored=RunsScored;

    }

    public String getBatsman() {
        return Batsman;
    }

    public String getStadium() {
        return Stadium;
    }

    public int getRunsScored() {
        return RunsScored;
    }
}