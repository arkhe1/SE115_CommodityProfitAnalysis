import java.util.*;
import java.io.*;
public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
            "July","August","September","October","November","December"};
    public static int [][][] data = new int[MONTHS][COMMS][DAYS];


    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {
        //tüm ayları dolaş.
        for (int i = 0; i < MONTHS;i++){
            //dosyanın ismini olusturuyoruz. Data_Files/Juanuary.txt gibi.
            String path = "Data_Files/" + months[i] + ".txt";
            File f = new File(path);

            //Dosya yoksa hata verme, diğer aya geç.
            if (!f.exists()){
                continue;
            }

            //dosya okuma.
            try{
                Scanner sc = new Scanner(f);

                while(sc.hasNextLine()){
                    String line = sc.nextLine().trim();

                    //boş satırları geç.
                    if(line.length() == 0){
                        continue;
                    }
                    String[] items = line.split(",");

                    //eksik bilgi varsa geç atla.
                    if (items.length<3){
                        continue;

                    }

                    //1- günü al (dosyada 1-dizi-0 ondan -1 yazarız.)
                    int day =  Integer.parseInt(items[0].trim())-1;

                    //2- ürünü al
                    String name = items[1].trim();
                    int c_index = -1;

                    for(int j=0; j<COMMS; j++){
                        if ( commodities[j].equals(name)){
                            c_index = j;
                            break;
                        }
                    }

                    //3- karı al.
                    int profit = Integer.parseInt(items[2].trim());

                    if (day>=0 && day < DAYS && c_index != -1){
                        data[i][c_index][day] = profit;
                    }
                }
                sc.close();
            } catch (Exception e) {
                //okumada hata olursa boş dur.
            }
        }

    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========

    public static String mostProfitableCommodityInMonth(int month) {
        return "DUMMY";
    }

    public static int totalProfitOnDay(int month, int day) {
        return 1234;
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
        return 1234;
    }

    public static int bestDayOfMonth(int month) {
        return 1234;
    }

    public static String bestMonthForCommodity(String comm) {
        return "DUMMY";
    }

    public static int consecutiveLossDays(String comm) {
        return 1234;
    }

    public static int daysAboveThreshold(String comm, int threshold) {
        return 1234;
    }

    public static int biggestDailySwing(int month) {
        return 1234;
    }

    public static String compareTwoCommodities(String c1, String c2) {
        return "DUMMY is better by 1234";
    }

    public static String bestWeekOfMonth(int month) {
        return "DUMMY";
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}