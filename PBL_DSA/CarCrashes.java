package PBL_DSA;
import Queue.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarCrashes {
        public Implementing_Queue mainQueue = new Implementing_Queue();
        private String s;
        private int[] years = {2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010};
        private String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        private ArrayList<ArrayList<String>> months = new ArrayList<>();
        private ArrayList<String> jan = new ArrayList<>();
        private ArrayList<String> feb = new ArrayList<>();
        private ArrayList<String> mar = new ArrayList<>();
        private ArrayList<String> apr = new ArrayList<>();
        private ArrayList<String> may = new ArrayList<>();
        private ArrayList<String> jun = new ArrayList<>();
        private ArrayList<String> jul = new ArrayList<>();
        private ArrayList<String> aug = new ArrayList<>();
        private ArrayList<String> sep = new ArrayList<>();
        private ArrayList<String> oct = new ArrayList<>();
        private ArrayList<String> nov = new ArrayList<>();
        private ArrayList<String> dec = new ArrayList<>();
        public void creatingMainQueue() throws FileNotFoundException {
                File file  = new File("D:\\Mubashir's Programs\\Third Semester\\Data Structures and Algorithms\\DSA\\src\\PBL_DSA\\ped_crashes.csv");
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()){
                        s = sc.nextLine();
                        if(s.contains("January")){
                                jan.add(s);
                        } else if(s.contains("February")){
                                feb.add(s);
                        } else if (s.contains("March")){
                                mar.add(s);
                        } else if (s.contains("April")) {
                                apr.add(s);
                        } else if (s.contains("May")) {
                                may.add(s);
                        } else if (s.contains("June")) {
                                jun.add(s);
                        } else if (s.contains("July")) {
                                jul.add(s);
                        } else if (s.contains("August")) {
                                aug.add(s);
                        } else if (s.contains("September")) {
                                sep.add(s);
                        }else if (s.contains("October")) {
                                oct.add(s);
                        } else if (s.contains("November")) {
                                nov.add(s);
                        }else if (s.contains("December")) {
                                dec.add(s);
                        }
                }
            months.add(jan);
            months.add(feb);
            months.add(mar);
            months.add(apr);
            months.add(may);
            months.add(jun);
            months.add(jul);
            months.add(aug);
            months.add(sep);
            months.add(oct);
            months.add(nov);
            months.add(dec);
                ArrayList<String> data = new ArrayList<>();
                for(int i = 0; i < years.length; i++) {
                        for(int j = 0; j<month.length;j++) {
                                for(int k = 0; k < months.size();k++) {
                                        for (int l = 0; l < months.get(k).size(); l++) {
                                                if(months.get(k).get(l).contains(Integer.toString(years[i])) && months.get(k).get(l).contains(month[j])){
                                                        mainQueue.add(months.get(k).get(l));
                                                }
                                        }
                                }
                        }
                }
        }
}
class Main{
    public static void main(String[] args) throws FileNotFoundException {
        CarCrashes c = new CarCrashes();
        c.creatingMainQueue();
    }
}
