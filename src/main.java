import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    static int MAX = 52;
    //Tao mang voi 1000 phan tu ngau nhien
    public static String RandomString(int n) {
        char []alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z' };
        String str = "";
        for (int i = 0; i < n; i++) {
            str = str + alphabet[(int) (Math.random() * 100 % MAX)];
        }
        return str;
    }

    //Bubble Sort
    public static void sortStrings(String[] arr){
        String temp;
        int n = 1000;
        for (int j = 0; j < n - 1; j++) {
            for (int i = j + 1; i < n; i++) {
                if (arr[j].compareTo(arr[i]) > 0){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    //Selection Sort
    public static void selectionSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (isAlphabeticallySmaller(arr[j], arr[min_idx]))
                    min_idx = j;
            String temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    // Chuc nang so sanh 2 tu cua giai thuat Selection Sort
    public static boolean isAlphabeticallySmaller(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        if (str1.compareTo(str2) < 0){
            return true;
        }
        return false;
    }

    //Insertion Sort
    public static String[] sort_sub(String array[], int f){
        String temp="";
        for(int i=0;i<f;i++){
            for(int j=i+1;j<f;j++){
                if(array[i].compareToIgnoreCase(array[j])>0){
                    temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }

    //Merge Sort
    public static String[] mergeSort(String[] list) {
        String [] sorted = new String[list.length];
        if (list.length == 1) {
            sorted = list;
        } else {
            int mid = list.length/2;
            String[] left = null;
            String[] right = null;
            if ((list.length % 2) == 0) {
                left = new String[list.length/2];
                right = new String[list.length/2];
            } else {
                left = new String[list.length/2];
                right = new String[(list.length/2)+1];
            }
            int x=0;
            int y=0;
            for ( ; x < mid; x++) {
                left[x] = list[x];
            }
            for ( ; x < list.length; x++) {
                right[y++] = list[x];
            }
            left = mergeSort(left);
            right = mergeSort(right);
            sorted = mergeArray(left,right);
        }
        return sorted;
    }
    public static String[] mergeArray(String[] left, String[] right) {
        String[] merged = new String[left.length+right.length];
        int lIndex = 0;
        int rIndex = 0;
        int mIndex = 0;
        int comp = 0;
        while (lIndex < left.length || rIndex < right.length) {
            if (lIndex == left.length) {
                merged[mIndex++] = right[rIndex++];
            } else if (rIndex == right.length) {
                merged[mIndex++] = left[lIndex++];
            } else {
                comp = left[lIndex].compareTo(right[rIndex]);
                if (comp > 0) {
                    merged[mIndex++] = right[rIndex++];
                } else if (comp < 0) {
                    merged[mIndex++] = left[lIndex++];
                } else {
                    merged[mIndex++] = left[lIndex++];
                }
            }
        }
        return merged;
    }

    //Ham main
    public static void main(String[] args) {
        //Tao mang
        String arr[] = new String[1000];
        for(int i=0; i<1000; i++){
            int min = 1;
            int max = 5;
            int n = (int)(Math.random() * (max - min + 1) + min);
            arr[i] = RandomString(n);
        }
        //Hien thi mang ban dau
        System.out.print("Mang ban dau: ");
        for(int i=0; i<1000; i++){
            if(i==999){
                System.out.println(arr[i]+ " ");
            }
            else{
                System.out.print(arr[i]+ " ");
            }
        }

        //Giai thuat Bubble Sort
        sortStrings(arr);
        System.out.print("Bubble Sort: ");
        for(int i=0; i<1000; i++){
            if(i==999){
                System.out.println(arr[i]+ " ");
            }
            else{
                System.out.print(arr[i]+ " ");
            }
        }

        //Giai thuat Selection Sort
        selectionSort(arr);
        System.out.print("Selection Sort: ");
        for(int i=0; i<1000; i++){
            if(i==999){
                System.out.println(arr[i]+ " ");
            }
            else{
                System.out.print(arr[i]+ " ");
            }
        }

        //Giai thuat Insertion Sort
        System.out.print("Insertion Sort: ");
        String sortedArray[] = sort_sub(arr, arr.length);
        for(int i=0; i<1000; i++){
            if(i==999){
                System.out.println(sortedArray[i] + " ");
            }
            else{
                System.out.print(sortedArray[i] + " ");
            }
        }

        //Giai thuat Merge Sort
        String[] mergeSortedArray = mergeSort(arr);
        System.out.print("Merge Sort: ");
        for(int i=0; i<1000; i++){
            if(i==999){
                System.out.println(mergeSortedArray[i] + " ");
            }
            else{
                System.out.print(mergeSortedArray[i] + " ");
            }
        }

        //Sap xep mang su dung Java Collections
        List<String> list = new ArrayList<>();
        for(int i=0; i<1000; i++){
            list.add(arr[i]);
        }
        Collections.sort(list);
        System.out.print("Java Collections: ");
        System.out.print(list);
    }
}
