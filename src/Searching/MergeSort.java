package Searching;

import Registration.Student;
import java.util.ArrayList;

public class MergeSort {

    // Name Sort ---------------------------------------------------------------
    public static void sortByName(ArrayList<Student> list) {
        mergeSortName(list, 0, list.size() - 1);
    }

    private static void mergeSortName(ArrayList<Student> list, int left,int right) 
    {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortName(list, left, mid);
            mergeSortName(list, mid + 1, right);
            mergeName(list, left, mid, right);
        }
    }

    private static void mergeName(ArrayList<Student> list, int left, int mid, int right) 
    {
        ArrayList<Student> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (list.get(i).getStudentName().compareToIgnoreCase(
                    list.get(j).getStudentName()) <= 0) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(list.get(i));
            i++;
        }
        while (j <= right) {
            temp.add(list.get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }

    }

    // Sort by Age -------------------------------------------------------------
    public static void sortByAge(ArrayList<Student> list) {
        mergeSortAge(list, 0, list.size() - 1);
    }

    private static void mergeSortAge( ArrayList<Student> list, int left, int right) 
    {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortAge(list, left, mid);
            mergeSortAge(list, mid + 1, right);
            mergeAge(list, left, mid, right);
        }

    }

    private static void mergeAge(ArrayList<Student> list, int left, int mid, int right) 
    {
        ArrayList<Student> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (list.get(i).getStudentAge() <= list.get(j).getStudentAge()) {
                temp.add(list.get(i));
                i++;

            } else {
                temp.add(list.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(list.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(list.get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }

    }
    
   
}
