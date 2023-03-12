package PBL_DSA;
import Queue.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import BinaryTrees.*;
public class CarCrashes2 {
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
    private AVLTree Hit_And_Run;
    private AVLTree Not_Hit_And_Run;
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
    // Step - 1 Of PBL
    public CarCrashes2() throws FileNotFoundException {
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
        creatingTwoBinaryTrees();
        solutionOfProblem1();
        solutionOfProblem2();
        solutionOfProblem3();
        solutionOfPostulate();

    }
    // Step - 2 Of PBL
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
    // Step - 3 Of PBL
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
    }
    // Step - 4 Of PBL
    public void creatingTwoBinaryTrees() {
        for (int i = 0; i < months.size(); i++) {
            int hit = 0;
            int notHit = 0;
            for (int j = 0; j < months.get(i).size(); j++) {
                if (months.get(i).get(j).contains("Hit-and-run"))
                    hit++;
                else if (months.get(i).get(j).contains("Not hit-and-run"))
                    notHit++;
            }
            if(Hit_And_Run == null && Not_Hit_And_Run == null){
                Hit_And_Run = new AVLTree(hit,month[i]);
                Not_Hit_And_Run = new AVLTree(notHit,month[i]);
            }else{
                Hit_And_Run.add(hit,month[i]);
                Not_Hit_And_Run.add(notHit,month[i]);
            }
        }
    }
    public void deadliestDay(){
        int count = 0;
        for(Implementing_Queue.Node p = tuesday.head.next; p!=tuesday.head; p = p.next){

                count++;
        }
        AVLTree deadDay = new AVLTree(count,"Tuesday");
        count = 0;
        for(Implementing_Queue.Node p = monday.head.next; p!=monday.head; p = p.next){

                count++;
        }
        deadDay.add(count,"Monday");
        count = 0;
        for(Implementing_Queue.Node p = sunday.head.next; p!=sunday.head; p = p.next){

                count++;
        }
        deadDay.add(count,"Sunday");
        count = 0;
        for(Implementing_Queue.Node p = saturday.head.next; p!=saturday.head; p = p.next){

                count++;
        }
        deadDay.add(count,"Saturday");
        count = 0;
        for(Implementing_Queue.Node p = wednesday.head.next; p!=wednesday.head; p = p.next){

                count++;
        }
        deadDay.add(count,"Wednesday");
        count = 0;
        for(Implementing_Queue.Node p = friday.head.next; p!=friday.head; p = p.next){

                count++;
        }
        deadDay.add(count,"Friday");
        count = 0;
        for(Implementing_Queue.Node p = thursday.head.next; p!=thursday.head; p = p.next){

                count++;
        }
        deadDay.add(count,"Thursday");
        System.out.println("The deadliest day in all days is ");
        deadDay.rightMostValue();
    }
    public void deadliestFriday(){
        AVLTree deadFriday = null;
        for(int i =0; i < months.size(); i++){
            int count = 0;
            for(int j = 0; j < months.get(i).size(); j++){
                if(months.get(i).get(j).contains("Friday"))
                    count++;
            }
            if(deadFriday == null){
                deadFriday = new AVLTree(count,month[i]);
            }else {
                deadFriday.add(count,month[i]);
            }
        }
        System.out.print("The deadliest friday is of ");
        deadFriday.rightMostValue();
    }
    // Solution of problem 1
    public void solutionOfProblem1(){
        System.out.println("Solution to Problem 1");
        System.out.println();
        deadliestDay();
        System.out.println();
        deadliestFriday();
    }
    // Solution of Problem 2
    public void solutionOfProblem2(){
        System.out.println();
        System.out.println("Solution of problem 2");
        System.out.println();
        AVLTree rain_Hit_And_Run = null;
        for (int i = 0; i < months.size(); i++) {
            int hit = 0;
            for (int j = 0; j < months.get(i).size(); j++) {
                if (months.get(i).get(j).contains("Rain"))
                    hit++;
            }
            if(rain_Hit_And_Run == null){
                rain_Hit_And_Run = new AVLTree(hit,month[i]);
            }else{
                rain_Hit_And_Run.add(hit,month[i]);
            }
        }
        System.out.println("Number of Rainy Day crashes in each month");
        System.out.println(rain_Hit_And_Run);
    }
    // Solution of Problem 3
    public void solutionOfProblem3(){
        System.out.println();
        System.out.println("Solution of problem 3");
        System.out.println();
        System.out.println("The lowest number of crashes in Hit-and-Run Tree");
        Hit_And_Run.leftMostValue();
        System.out.println("The highest number of crashes in Hit-and-Run Tree");
        Hit_And_Run.rightMostValue();
        System.out.println("The lowest number of crashes in Not-Hit-and-Run Tree");
        Not_Hit_And_Run.leftMostValue();
        System.out.println("The lowest number of crashes in Not-Hit-and-Run Tree");
        Not_Hit_And_Run.rightMostValue();
    }
    // Solution of Postulate
    public void solutionOfPostulate(){
        int mondayAndTuesday = 0;
        for(Implementing_Queue.Node p = tuesday.head.next; p!=tuesday.head; p = p.next){
            if(p.data.toString().contains("Dark lighted"))
                mondayAndTuesday++;
        }
        for(Implementing_Queue.Node p = monday.head.next; p!=monday.head; p = p.next){
            if(p.data.toString().contains("Dark lighted"))
                mondayAndTuesday++;
        }
        int saturdayAndSunday = 0;
        for(Implementing_Queue.Node p = sunday.head.next; p!=sunday.head; p = p.next){
            if(p.data.toString().contains("Dark lighted"))
                saturdayAndSunday++;
        }
        for(Implementing_Queue.Node p = saturday.head.next; p!=saturday.head; p = p.next){
            if(p.data.toString().contains("Dark lighted"))
                saturdayAndSunday++;
        }
        System.out.println();
        if(mondayAndTuesday < saturdayAndSunday){
            System.out.println("The postulate is true");
        }
        else{
            System.out.println("The postulate is false");
        }
    }
}
class Main2{
    public static void main(String[] args) throws FileNotFoundException {
        CarCrashes2 c = new CarCrashes2();
    }
}
