package PBL_DSA;
import Queue.*;
import LinkedList_And_Types.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarCrashes {
    static class Node {
        Object data;
        Node pre;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = this;
            this.pre = this;
        }
    }
        private Implementing_Queue mainQueue = new Implementing_Queue();
        private Implementing_Queue snowQueue = new Implementing_Queue();
        private Implementing_Queue clearQueue = new Implementing_Queue();
        private Implementing_Queue rainQueue = new Implementing_Queue();
        private Implementing_Queue monday = new Implementing_Queue();
        private Implementing_Queue tuesday = new Implementing_Queue();
        private Implementing_Queue wednesday = new Implementing_Queue();
        private Implementing_Queue thursday = new Implementing_Queue();
        private Implementing_Queue friday = new Implementing_Queue();
        private Implementing_Queue saturday = new Implementing_Queue();
        private Implementing_Queue sunday = new Implementing_Queue();
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
        public CarCrashes() throws FileNotFoundException {
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
                creatingThreeSubQueues();
                creatingSevenDayQueues();
        }
        public void creatingThreeSubQueues(){
            for (Implementing_Queue.Node p = mainQueue.head.next; p!= mainQueue.head; p = p.next){
                if(p.data.toString().contains("Clear"))
                    clearQueue.add(p.data);
                if(p.data.toString().contains("Rain"))
                    rainQueue.add(p.data);
                if(p.data.toString().contains("Snow"))
                    snowQueue.add(p.data);
            }
        }
        public void creatingSevenDayQueues(){
            for (Implementing_Queue.Node p = mainQueue.head.next; p!= mainQueue.head; p = p.next){
                if(p.data.toString().contains("Monday"))
                    monday.add(p.data);
                if(p.data.toString().contains("Tuesday"))
                    tuesday.add(p.data);
                if(p.data.toString().contains("Wednesday"))
                    wednesday.add(p.data);
                if(p.data.toString().contains("Thursday"))
                    thursday.add(p.data);
                if(p.data.toString().contains("Friday"))
                    friday.add(p.data);
                if(p.data.toString().contains("Saturday"))
                    saturday.add(p.data);
                if(p.data.toString().contains("Sunday"))
                    sunday.add(p.data);
            }
            monday.print();
        }
}
class Main{
    public static void main(String[] args) throws FileNotFoundException {
        CarCrashes c = new CarCrashes();
    }
}
