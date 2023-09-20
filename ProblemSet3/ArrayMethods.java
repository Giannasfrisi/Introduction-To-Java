import java.util.*;

public class ArrayMethods {

        public static final String[] DAY_NAMES = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        public static int getDayNum(String day){
            int index = -1;
            for (int i = 0; i < 7 ;i++){
                if ((day.equalsIgnoreCase(DAY_NAMES[i]) == true)){
                    index = i;
                 } 
                }
                return index;
            }

        public static void swapNeighbors(int[] values){
            if (values == null){
                throw new IllegalArgumentException();
            }

            for (int i = 0; i < values.length ; i++){
                if (i < values.length - 1){
                    if (i % 2 ==0){
                        int first = values[i];
                        int second = values[i+1];
                        values[i] = second;
                        values[i+ 1] = first;
                    }
                }
            }
        }

        public static int[] copyWithCeiling(int[] values, int ceiling){
            if (values == null){
                throw new IllegalArgumentException();
            }

            int [] newArray = new int[values.length];
            for (int i = 0; i < values.length; i++){
                if (values[i] > ceiling){
                    newArray[i] = ceiling;
            }   else{
                    newArray[i] = values[i];
            }
            }
            return newArray;
        }

        public static int mostOccur(int[] arr){
            if (arr == null || arr.length == 0){
                throw new IllegalArgumentException();
            }

            int mostValue = arr[0];
            int amount = 1;
            for (int i = 0; i < arr.length - 2; i++){
                int count = 1;
                while (arr[i] == arr[i + 1]){
                    count = count + 1;
                    i = i + 1;
                }
                if (amount < count){
                    mostValue = arr[i];
                    amount = count;
                }
            }
            return mostValue;
        }

        public static int find(int[] arr1, int[] arr2){
            if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0){
                throw new IllegalArgumentException();
            }
            int index = -1;  
            for (int i = 0; i < arr2.length; i++){
                    int count = 0;
                    if (arr1[0] == arr2[i]){
                        int possibleIndex = i;
                        for (int j = 0; j < arr1.length; j++)
                            while (j < arr1.length && i < arr2.length && arr1[j] == arr2[i]){
                                count = count + 1;
                                j = j + 1;
                                i = i + 1;         
                            }
                            if (count == arr1.length){
                                index = possibleIndex;
                                break;
                            }         
                    }     
            }
            return index;   
        }
    

        public static void main(String [] args) {
                System.out.println(getDayNum("Sunday"));
                System.out.println(getDayNum("Wednesday"));

                int[] a1 = {0, 2, 4, 6, 8, 10};
                swapNeighbors(a1);
                System.out.println(Arrays.toString(a1));
                int[] a2 = {1, 2, 3, 4, 5, 6, 7};
                swapNeighbors(a2);
                System.out.println(Arrays.toString(a2));

                int[] a3 = {2, 5, 6, 3, 7, 4, 1};
                int[] a4 = ArrayMethods.copyWithCeiling(a3, 4);
                System.out.println(Arrays.toString(a4));

                int[] arr = {1, 2, 3, 3, 8, 8, 8, 8, 11, 11, 11, 11, 14, 19, 19};
                System.out.println(mostOccur(arr));

                int[] list1 = {1, 3, 6};
                int[] list2 = {1, 3, 5, 8, 12, 1, 3, 17, 1, 3, 6, 9, 1, 3, 6};
                System.out.println(find(list1, list2));
    }

}
