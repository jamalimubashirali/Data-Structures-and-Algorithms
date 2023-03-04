import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws FileNotFoundException {
            File file  = new File("D:\\Mubashir's Programs\\Third Semester\\Data Structures and Algorithms\\DSA\\src\\PBL_DSA\\ped_crashes.csv");
            Scanner sc = new Scanner(file);
            String s;
            int [] years = {2018,2017,2016,2015,2014,2013,2012,2011,2010};
            String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
            ArrayList<String> jan = new ArrayList<>();
            ArrayList<String> feb = new ArrayList<>();
            ArrayList<String> mar = new ArrayList<>();
            ArrayList<String> apr = new ArrayList<>();
            ArrayList<String> may = new ArrayList<>();
            ArrayList<String> jun = new ArrayList<>();
            ArrayList<String> jul = new ArrayList<>();
            ArrayList<String> aug = new ArrayList<>();
            ArrayList<String> sep = new ArrayList<>();
            ArrayList<String> oct = new ArrayList<>();
            ArrayList<String> nov = new ArrayList<>();
            ArrayList<String> dec = new ArrayList<>();
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
            ArrayList<ArrayList<String>> months = new ArrayList<>();
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
                                data.add(months.get(k).get(l));
                            }
                        }
                    }
                }
            }
            int i = 0;
            for (String s1: data) {
                i++;
                System.out.println(s1);
            }
            System.out.println(i);
    }
}

