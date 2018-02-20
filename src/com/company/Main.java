package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Greeting line
        System.out.println("Hello to the Attendance App");

        //User Name input
        System.out.println("Please provide your name please: ");
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();

        //Welcome message
        System.out.println("Welcome " + name + " to the Attendance App");

        //Absence list setup
        ArrayList<Integer> absence = new ArrayList<>();

        //Outputs list
        System.out.println("The elements are " + getAbsence(absence, name.length()));

        //Outputs perfect Attendance
        System.out.println("This many students had perfect attendance " + getPerfectAttendance(absence));


        //Average of all absences
        System.out.println("This is the average of all absences " + getAverage(absence));

        //Percentage of students with less than 3 absences and perfect attendance
        System.out.println("percentage of students with less than 3 absences and perfect attendance " + percentage(absence));

        //User inputs absence they are looking for
        System.out.println("What is the absence you are looking for: ");
        int specNum = keyboard.nextInt();

       //Outputs index of absence user was looking for
        System.out.println("this is the index of that number " + indexOf(absence, specNum));

        //User inputs how many times the course meets
        System.out.println("How many times does your course meet: ");
        int courseMeet = keyboard.nextInt();

        //outputs Percent of students that FE'D
        System.out.printf("Percent of the students that FE'D  " + percentofFE(absence, courseMeet));

        //Average of students who did not FE
        System.out.println(" this is the NON FE average " + averageofNonFE(absence, courseMeet));

        //User input to add number
        System.out.println("what number do you want to add ");
        int addNum = keyboard.nextInt();

        //User inputs number to add to everything greater than that
        System.out.println("what absence greater than to add to ");
        int greaterThan = keyboard.nextInt();

        //Outputs new list
        System.out.println("this is the new list " + addtoGreater(absence,addNum, greaterThan));

       //Outputs sorted list
        System.out.println("This is your sorted list " + sort(absence));

        //Outputs shuffled list
        System.out.println("This is your shuffled list " + shuffle(absence));

        //Outputs list with no duplicates
        System.out.println("This is the list with no duplicates " + unique(absence));

        //Outputs histogram
        System.out.println(Histogram(absence));

        //Outputs user sorted list
//         System.out.println("This is your user sorted list " +userSort(absence));

        //Outputs user shuffled list
        System.out.println("This is your user shuffled list " + userShuffle(absence));

        //User inputs five names
        System.out.println("input five names ");
        String name1 = keyboard.nextLine();
        name1 = keyboard.nextLine();
        String name2 = keyboard.nextLine();
        String name3 = keyboard.nextLine();
        String name4 = keyboard.nextLine();
        String name5 = keyboard.nextLine();

        //Sets up new Name list
        ArrayList<String> nameList = new ArrayList<>();

        //Outputs list of names
        System.out.println("This is your list of names " + listOfNames(name1, name2, name3, name4, name5, nameList));

        //Outputs Shuffled name list
        System.out.println("This is your shuffled name list " + nameListShuffle(nameList));

        //Outputs new longer list
        System.out.println("This is your new list " +newNameList(nameList, absence));

        //Sets up new arraylist
        ArrayList<String> newList = newNameList(nameList,absence);

        //Outputs number of names used more than once
        System.out.println("This is how many times names where used more than once " +namesUsedOnce(newList));

        //What students had Perfect Attendance
        System.out.println("This is what students had perfect attendance " +studentsWithPerfectAttendance(nameList,absence));

        //What students FE'D
       // System.out.println("These are the students that FE'D" +whoFED(nameList,absence,courseMeet));

        //How many courses a student takes
        System.out.println("What student are you looking for ");
        String student = keyboard.nextLine();
        System.out.println(" " +student + " has this many courses " +howManyCourses(newList,student));

        //Which courses did student FE
        System.out.println("What student are you looking for ");
        String feStudent = keyboard.nextLine();
        System.out.println(" " +feStudent + " FE'd these course courses " +whatCoursesFED(newList,absence,feStudent,courseMeet));

        //The local date
        System.out.println("This is today's date " +localDate());

        //How many days have you been alive
        System.out.println("what is your birthdate in the form of day , month , year. press enter after each number is entered ");
        int day = keyboard.nextInt();
        int month = keyboard.nextInt();
        int year = keyboard.nextInt();
        System.out.println("This is how many days you have been alive " +daysAlive(day,month,year));

        //create list of dates
        System.out.println("This is your list of dates " +datesList(newList, day,month,year));

        //Create date list
        ArrayList<LocalDate> datelist = datesList(newList, day,month,year);

        //Output date Range
        System.out.println("This is the range " +dateRange(datelist));

        //Ask for specific date
        System.out.println("What date are you looking for? (Enter in the form of day , month , year. press enter after each number is entered)");
        day = keyboard.nextInt();
        month = keyboard.nextInt();
        year = keyboard.nextInt();
        LocalDate specDate = LocalDate.of(year, month, day);

        //Output the index of students at that date
        System.out.println("This is the indexes of the students at absent at that date " +specDate(datelist,newList,specDate));

        //Output students with same date
        System.out.println("These are the students with the same dates " +sameDates(datelist,newList));




    }


    public static ArrayList<Integer> getAbsence(ArrayList<Integer> absence, int length) {
        for (int i = 0; i < length; i++) {
            Random rand = new Random();
            int num = rand.nextInt(11);
            absence.add(num);

        }
        return absence;
    }

    public static int getPerfectAttendance(ArrayList<Integer> absence) {
        int count = 0;
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) == 0) {
                count++;
            }
        }
        return count;
    }

    public static double getAverage(ArrayList<Integer> absence) {
        int sum = 0;
        double avg;
        for (int i = 0; i < absence.size(); i++) {
            sum = sum + absence.get(i);
        }
        avg = (double) sum / absence.size();
        return avg;
    }

    public static int percentage(ArrayList<Integer> absence) {
        double percent;
        int count = 0;
        int lessthan = 0;
        int total;
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) == 0) {
                count++;
            } if (absence.get(i) < 3) {
                lessthan++;

            }


        }
        percent = (double) count / lessthan;
        total = (int) (percent * 100);
        return total;


    }

    public static int indexOf(ArrayList<Integer> absence, int specNum) {
        return absence.indexOf(specNum);
    }

    public static double percentofFE(ArrayList<Integer> absence, int courseMeet) {
        int count = 0;
        double percent;
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) == courseMeet) {
                count++;
            }
        }
        percent = (double) count / absence.size();
        double finalpercent = (double) (percent * 100);
        return finalpercent;
    }

    public static double averageofNonFE(ArrayList<Integer> absence, int courseMeet) {
        int sum = 0;
        double avg;
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) != courseMeet) {
                sum = sum + absence.get(i);
            }
        }
        avg = (double) sum / absence.size();
        return avg;

    }

    public static ArrayList<Integer> addtoGreater(ArrayList<Integer> absence, int addNum, int greaterThan) {
        ArrayList<Integer> newabsenceList = absence;
        for (int i = 0; i < newabsenceList.size(); i++) {
            if (newabsenceList.contains(greaterThan)) {
                if (newabsenceList.get(i) > greaterThan) {
                    int newNum = newabsenceList.get(i) + addNum;
                    newabsenceList.set(i, newNum);
                }
                if (newabsenceList.get(i) < 0) {
                    newabsenceList.set(i, 0);
                }
                if (newabsenceList.get(i) > 15) {
                    newabsenceList.set(i, 15);
                }

            }
        }
            return newabsenceList;

    }

    public static ArrayList<Integer> sort(ArrayList<Integer> absence) {
        ArrayList<Integer> sort = absence;
       Collections.sort(sort);
       return sort;
    }

    public static ArrayList<Integer> shuffle(ArrayList<Integer> absence) {
        ArrayList<Integer> shuffle = absence;
        Collections.shuffle(shuffle);
        return shuffle;
    }

    public static Set<Integer> unique(ArrayList<Integer> absence) {
        Set<Integer> UniqueAbsence = new HashSet<>();
        UniqueAbsence.addAll(absence);
        return UniqueAbsence;
    }

     public static Map<Integer, Integer> Histogram(ArrayList<Integer> absence) {
        Map<Integer, Integer> Histogram = new HashMap<>();
        for (int key : absence) {
            if (!Histogram.containsKey(key)){
                Histogram.put(key, 1);
            }
            else {
                int value = Histogram.get(key) + 1;
                Histogram.put(key, value);
            }
        }
        return Histogram;

     }

    public static ArrayList<Integer> userSort(ArrayList<Integer> absence) {
        int temp;
        ArrayList <Integer> userSort = new ArrayList<>();
        for (int i = 0; i < absence.size(); i++) {
            userSort.add(absence.get(i));
            for (int j = 1; j < absence.size(); j--) {
                userSort.add(absence.get(j));
                if (userSort.get(j) < userSort.get(i)) {
                    temp = userSort.get(i);
                    userSort.set(i, userSort.get(j));
                    userSort.set(j, temp);
                }
            }

        }
        return userSort;
    }

    public static ArrayList<Integer> userShuffle(ArrayList<Integer> absence) {
        Random ran = new Random();
        int temp;
        for (int i = 0; i < absence.size(); i++) {
            int num1 = ran.nextInt(absence.size());
            temp = absence.get(num1);
            absence.set(num1, absence.get(i));
            absence.set(i, temp);
        }
        return absence;
    }

    public static ArrayList<String> listOfNames(String name1, String name2, String name3, String name4, String name5, ArrayList<String> nameList) {
        nameList.add(name1);
        nameList.add(name2);
        nameList.add(name3);
        nameList.add(name4);
        nameList.add(name5);
        System.out.println(nameList);

        return nameList;


    }

    public static ArrayList<String> nameListShuffle(ArrayList<String> nameList) {
        Random ran = new Random();
        String temp;
        for (int i = 0; i < nameList.size(); i++) {
            int num1 = ran.nextInt(nameList.size());
            temp = nameList.get(num1);
            nameList.set(num1, nameList.get(i));
            nameList.set(i, temp);

        }
        return nameList;


    }

    public static ArrayList<String> newNameList(ArrayList<String> nameList, ArrayList<Integer> absence) {
        ArrayList<String> newNameList = new ArrayList<>();
        Random rand = new Random();
        int length = absence.size();
        for (int i = 0; i < length; i++) {
           String name = nameList.get(rand.nextInt(nameList.size()));
           newNameList.add(name);

        }
        return newNameList;
    }

    public static int namesUsedOnce(ArrayList<String> newList){

        Set<String> names = new HashSet<>();
        int count = 0;
        for (String i : newList){
            if (!names.add(i)){
                count ++;
            }
        }
            return count;
    }

    public static ArrayList<String> studentsWithPerfectAttendance(ArrayList<String> newList, ArrayList<Integer> absence){
        ArrayList<String> perfectNames = new ArrayList<>();
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) == 0){
               int num =  absence.get(i);
               perfectNames.add(newList.get(num));
            }

        }
        return perfectNames;

    }

   /* public static ArrayList<String> whoFED (ArrayList<String> newList, ArrayList<Integer> absence, int courseMeet){
        ArrayList<String> whoFe = new ArrayList<>();
        for (int i = 0; i < absence.size(); i++) {
            if (absence.get(i) > courseMeet){
                int abs = absence.get(i);
                whoFe.add(newList.get(abs));
            }
    }

    return whoFe;
        }*/

    public static int howManyCourses(ArrayList<String> newList, String student){
       int count = 0;
        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i).equals(student)){
                count ++;

            }
        }
        return count;

    }

    public static ArrayList<Integer> whatCoursesFED(ArrayList<String> newList, ArrayList<Integer> absence, String feStudent, int courseMeet){
        ArrayList<Integer> coursesFED = new ArrayList<>();
            for (int i = 0; i < newList.size(); i++) {
                if (newList.get(i).equals(feStudent)){
                    int abs = absence.get(newList.indexOf(feStudent));
                    if (abs > courseMeet){
                        coursesFED.add(absence.indexOf(abs));
                    }
                }
            }
        return coursesFED;
   }

    public static LocalDate localDate(){
        LocalDate  localDate = LocalDate.now();
        return localDate;
    }

    public static int daysAlive(int day, int month, int year){
       LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate localDate = LocalDate.now();
        int yearsAlive = (int) birthdate.toEpochDay();
        int currentDate = (int) localDate.toEpochDay();
        int daysAlive = currentDate - yearsAlive;
        return daysAlive;
    }
    public static ArrayList<LocalDate> datesList(ArrayList<String> newList, int day, int month, int year){
        Random rand = new Random();
        ArrayList<LocalDate> randDates = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        randDates.add(localDate);
        LocalDate birthdate = LocalDate.of(year, month, day);
        randDates.add(birthdate);
        for (int i = 0; i < newList.size(); i++) {
           localDate = localDate.minusDays(rand.nextInt(20));
            randDates.add(localDate);
        }

        return randDates;
    }

    public static LocalDate min(ArrayList<LocalDate> datelist){
        LocalDate min = datelist.get(0);
        for (int i = 0; i < datelist.size(); i++) {
           if (datelist.get(i).isBefore(min)) {
               min = datelist.get(i);
           }

        }
        return min;
    }

    public static LocalDate max(ArrayList<LocalDate> datelist){
        LocalDate max= datelist.get(0);
        for (int i = 0; i < datelist.size(); i++) {
            if ((datelist.get(i).isAfter(max))) {
                 max = datelist.get(i);
            }

        }
        return max;
    }

    public static int dateRange(ArrayList<LocalDate> datelist){
        LocalDate max = max(datelist);
        LocalDate min = min(datelist);

        int maximum = (int) max.toEpochDay();
        int minimum = (int) min.toEpochDay();
        int range = maximum - minimum;

        return range;
    }

    public static int specDate(ArrayList<LocalDate> datelist, ArrayList<String> newList, LocalDate specDate){
      int num = 0;
        for (int i = 0; i < datelist.size(); i++) {
            if (datelist.contains(specDate)) {
                num = datelist.indexOf(specDate);
            }
            }
            return num;
    }

    public static ArrayList<LocalDate> sameDates(ArrayList<LocalDate> datelist, ArrayList<String> newList){
      Map<LocalDate, ArrayList<String> > findSameDates = new HashMap<>();
      ArrayList<LocalDate> same = new ArrayList<>();
        for (int i = 0; i < datelist.size() ; i++) {
           if (!findSameDates.containsKey(i)) {
               LocalDate key = datelist.get(i);
               ArrayList<String> names = new ArrayList<>();
               int index = datelist.indexOf(i);
               String singleName = newList.get(index);
               names.add(singleName);
               findSameDates.put(key, names);

           }
           else{
               findSameDates.containsKey(i);
               LocalDate key = datelist.get(i);
               ArrayList<String> names = new ArrayList<>();
               names = findSameDates.get(key);
               int index = datelist.indexOf(i);
               String singleName = newList.get(index);
               names.add(singleName);
               findSameDates.put(key, names);
           }

        }

        return ;

    }

    //public static studentRecords();






}


