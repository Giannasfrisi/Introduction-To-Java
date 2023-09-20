// Names: Ellis Hamilton and Gianna Sfrisi
// emails : ellisham@bu.edu gsfrisi@bu.edu
// CS Problem 5 

public class Problem5 {
    public static int[] union(int[] a1, int[] a2){
        int[] unionArray = new int[a1.length + a2.length];
        Sort.mergeSort(a1);
        Sort.mergeSort(a2);

        int i = 0;    // index into left subarray
        int j = 0;   // index into right subarray
        int k = 0;    // index into temp
        
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                boolean check = true;
                for (int l=0; l<k;l++){
                    if (a1[i] == unionArray[l]){
                        i++;
                        check = false;
                        break;
                    }
                }
                if (check==true){
                    unionArray[k] = a1[i];
                    i++; k++;
                }
            } else {
                boolean check = true;
                for (int l=0; l<k;l++){
                    if (a2[j] == unionArray[l]){
                        j++;
                        check = false;
                        break;
                    }
                }
                if (check==true){
                unionArray[k] = a2[j];
                j++; k++;
                }
            }
        }
        // if one is bigger than the other 
        while (i < a1.length) {
            boolean check = true;
                for (int l=0; l<k;l++){
                    if (a1[i] == unionArray[l]){
                        i++;
                        check = false;
                        break;
                    }
                }
            if (check==true){
            unionArray[k] = a1[i];
            i++; k++;
            }
        }
        while (j < a2.length) {
            boolean check = true;
                for (int l=0; l<k;l++){
                    if (a2[j] == unionArray[l]){
                        j++;
                        check = false;
                        break;
                    }
                }
            if (check==true){
            unionArray[k] = a2[j];
            j++; k++;
            }
        }
        
        return unionArray;

    }
    
    
}
