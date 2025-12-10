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

        if(month < 0 || month > MONTHS){ //girilen ay geçerlimi onu kontrol et.

            return "INLAVID_MONTH";
        }
        int maxP = Integer.MIN_VALUE; //max kar değeri ilk basta en kucuk sec
        String mostName = ""; //ürün ismi

        for (int i= 0; i<COMMS; i++){
            int total=  0; //ürünün toplam karını 0 kabul et.

            for(int j =0; j<DAYS; j++){
                total = total + data[month][i][j]; //ürünün bir ayda toplam karını hesapla.
            }
            if (total > maxP){
                maxP = total;
                mostName = commodities[i];
            }

        }
        return mostName + " " + maxP;

    }

    public static int totalProfitOnDay(int month, int day) {
        if (month < 0 || month>= MONTHS || day<1 || day>DAYS){
            return -99999; //gün veya ay geçerli değilse bu değer donmelı.
        }
        int day_index = day - 1;
        int total = 0;

        for (int i = 0; i<COMMS; i++){ //5 ürününde o gundekı karlarını topluyor.

            total = total + data[month][i][day_index];
        }
        return total; //o gündeki totalprofiti döndürecek.

    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
        if (from<1 || from>DAYS || to<1 || to>DAYS || from>to){
            return -99999; //gün aralıgı hatalıysa veya baslangıc bıtısten buyukse hata dondur.
        }

        int comm_index = -1;
        for (int i=0; i<COMMS; i++){
            if(commodities[i].equals(commodity)){
                comm_index = i;
                break;
            }
        }
        if (comm_index == -1){ //ürün yoksa hata dondur.
            return -99999;
        }
        int total = 0;

        for ( int i=  0; i<MONTHS; i++){
            for (int j =from-1; j<to; j++){
                total = total + data[i][comm_index][j]; //tüm ayları gezıyoruz ve o ay ıcında ıstenen gun aralıgını topluyoruz.
            }
        }
        return total;

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