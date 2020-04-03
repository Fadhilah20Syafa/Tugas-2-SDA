package list;

public class Data {
    private String name;
    private int freq;
    private String title[] = new String[100];
    // private ArrayList<String> title = new ArrayList<>();

    public Data(String name,String title) {
        this.name = name;
        this.freq = 1;
        this.title[0] = title;
    }

    public String getName() {
        return this.name;
    }

    public void setTitle(String title){
        this.title[freq] = title;
    }
    public String getTitle(int i) {
        return this.title[i];
    }

    public int getFreq() {
        return this.freq;
    }

    public void addFreq() {
        this.freq++;
    }
}