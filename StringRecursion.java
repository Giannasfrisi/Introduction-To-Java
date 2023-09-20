public class StringRecursion{

public static void printWithSpaces(String str){
    if (str == null || str == ""){
        System.out.println();
        return;
    }

    if (str.length() == 1){
        System.out.print(str + " ");
    }

    else{
        System.out.print(str.substring(0,1) + " ");
        printWithSpaces(str.substring(1));
    }
}

public static String reflect(String str){
    if (str == null || str == ""){
        return "";
    }

    if (str.length() == 1){
        return str + str;
    }

    else{
        String rest = reflect(str.substring(1));
     //   System.out.println(str.substring(0,1) + rest + str.substring(0,1));
        return str.substring(0,1) + rest + str.substring(0,1);
    }
}

public static int numDiff(String str1, String str2){
if (str1.length() == 0){
  //  System.out.println("str1 is done");
    return str2.length();
}

if (str2.length() == 0){
   // System.out.println("str2 is done");
    return str1.length();
}

else{
    int rest = numDiff(str1.substring(1), str2.substring(1));
    if (str1.substring(0,1).equals(str2.substring(0,1))){
    return rest;
    }
    else{
        return rest + 1;
    }
}
}

public static int indexOf(char ch, String str){
if (str == "" || str == null || str.length()== 1 && ch != str.charAt(0)){
    return -1;
}

else if (str.charAt(0) == ch){
    return 0;
    }

else{
    int rest = indexOf(ch, str.substring(1));
    if (rest >= 0){
    return rest + 1;
    }

    else{
        return rest;
    }
}    
}

public static void main(String[] args){
    printWithSpaces("space");

    reflect("method");
    reflect("abc");

    numDiff("alien", "allen");
    numDiff("alien", "alone");
    numDiff("same", "same");
    numDiff("same", "sameness");
    numDiff("some", "sameness");
    numDiff("", "abc");
    numDiff("abc", "");

    indexOf('b', "Rabbit");
    indexOf('P', "Rabbit");
}

}

