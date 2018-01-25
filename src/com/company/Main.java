package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance App");
        System.out.println("Please provide your name please: ");
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();
        System.out.println("Welcome " + name + " to the Attendance App");
        ArrayList<Integer> absence = new ArrayList<>();
        System.out.println("The elements are " + GetAbsence(absence, name));
        int count = 0;
        System.out.println("This many students had perfect attendance " + GetPerfectAttendance(absence, count));
        int sum = 0;
        double avg = 0;
        int lessthan = 0;
        double percent = 0;
        int total = 0;
        System.out.println("This is the average of all absences " + GetAverage(absence, sum, avg));
        System.out.println("percentage of students with less than 3 absences and perfect attendance " + Percentage(absence, count, lessthan, percent, total));
        System.out.println("What is the absence you are looking for: ");
        int Specnum = keyboard.nextInt();
        System.out.println("this is the index of that number " + IndexOf(absence, Specnum));
        System.out.println("How many times does your course meet: ");
        int Coursemeet = keyboard.nextInt();
        System.out.printf("these are the students that FE'D" + PercentofFE(absence, Coursemeet, percent, count));
        System.out.println("this is the NON FE average " + AverageofNonFE(absence, sum, avg, Coursemeet));
        System.out.println("what number do you want to add ");
        int Addnum = keyboard.nextInt();
        System.out.println("what absence greater than to add to ");
        int Greaterthan = keyboard.nextInt();
        System.out.println("this is the new list " + AddtoGreater(absence, Addnum, Greaterthan));
        System.out.println("This is your sorted list " + Sort(absence));
        System.out.println("This is your shuffled list " + Shuffle(absence));
        System.out.println("This is the list with no duplicates " + Unique(absence));
        System.out.println(Histogram(absence));

    }

    public static ArrayList<Integer> GetAbsence(ArrayList<Integer> absence, String name) {
        for (int i = 0; i < name.length(); i++) {
            Random rand = new Random();
            int num = rand.nextInt(11);
            absence.add(num);

        }
        return absence;
    }

    public static int GetPerfectAttendance(ArrayList<Integer> absence, int count) {
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) == 0) {
                count++;
            } else {
            }

        }
        return count;
    }

    public static double GetAverage(ArrayList<Integer> absence, int sum, double avg) {
        for (int i = 0; i < absence.size(); i++) {
            sum = sum + absence.get(i);
        }
        avg = (double) sum / absence.size();
        return avg;
    }

    public static int Percentage(ArrayList<Integer> absence, int count, int lessthan, double percent, int total) {
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) == 0) {
                count++;
            } else if (absence.get(i) < 3) {
                lessthan++;

            }


        }
        percent = (double) count / lessthan;
        total = (int) (percent * 100);
        return total;


    }

    public static int IndexOf(ArrayList<Integer> absence, int Specnum) {
        int Specab = absence.indexOf(Specnum);
        return Specab;

    }

    public static double PercentofFE(ArrayList<Integer> absence, int Coursemeet, double percent, int count) {
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) == Coursemeet) {
                count++;
            }
        }

        percent = (double) count / absence.size();
        percent = (percent * 100.0);
        return percent;


    }

    public static double AverageofNonFE(ArrayList<Integer> absence, int sum, double avg, int Coursemeet) {
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) != Coursemeet) {
                sum = sum + absence.get(i);
            }
        }
        avg = (double) sum / absence.size();
        return avg;

    }

    public static ArrayList<Integer> AddtoGreater(ArrayList<Integer> absence, int Addnum, int Greaterthan) {
        for (int i = 0; i < absence.size(); i++) {
            if (absence.size() > Greaterthan) {
                int Newnum = absence.get(i) + Addnum;
                absence.set(i, Newnum);
            }
        }
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) < 0) {
                absence.set(i, 0);
            } else if (absence.get(i) > 15) {
                absence.set(i, 15);
            }

        }
        return absence;
    }

    public static ArrayList<Integer> Sort(ArrayList<Integer> absence) {
        Collections.sort(absence);
        return absence;
    }

    public static ArrayList<Integer> Shuffle(ArrayList<Integer> absence) {
        Collections.shuffle(absence);
        return absence;
    }

    public static Set<Integer> Unique(ArrayList<Integer> absence) {
        Set<Integer> UniqueAbsence = new HashSet<>();
        UniqueAbsence.addAll(absence);
        return UniqueAbsence;
    }

    public static int Histogram(ArrayList<Integer> absence) {
        for (int i = 0; i < absence.size(); i++) {
            i = Collections.frequency(absence, i);
        }

        for (int count = 0; count < absence.size(); count++) {
            System.out.print((count + 1) + "\t|");

            for (int h = 0; h < absence.get(count); h++)
                System.out.print("#");

            System.out.println();
        }
        return Histogram(absence);
    }
}

