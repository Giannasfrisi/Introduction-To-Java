public class Problem2 {
    public static LLList scale(int factor, ArrayList vals) {
        LLList scaled = new LLList();

        for (int i = 0; i < vals.length(); i++) {
            int val = (Integer)vals.getItem(i);
            scaled.addItem(val*factor, i);
        }

        return scaled;
    }

    public static void main(String[] args) {
        Integer[] valsArray = {3, 7, 8, 2, 1, 9};
        ArrayList vals = new ArrayList(valsArray);
        LLList scaled = scale(2, vals);
        System.out.println(scaled);
    }
}