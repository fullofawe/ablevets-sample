import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] defaultInput = {7, 6, 5, 4, 3};
        int[] input = {};
        int arrayElement;
        for (int i = 0; i < args.length; i++) {
            if (args.length > 0) {
                try {
                    arrayElement = Integer.parseInt(args[i]);
                    input = addElement(input, arrayElement);
                } catch (NumberFormatException e) {
                    System.err.println("Argument" + args[i] + " must be an integer.");
                    System.exit(1);
                }
            }
        }
        System.out.println("input is: " + Arrays.toString(input));

        if (input.length < 3) {
            System.out.println("using default input");
            System.out.println(Arrays.toString(defaultInput));
            int result = smallestThreeSum(defaultInput);
            System.out.println(result);
        }
        else {
            System.out.println(Arrays.toString(input));
            int result = smallestThreeSum(input);
            System.out.println(result);
        }
    }

    private static int[] addElement(int[] input, int added) {
        int[] result = Arrays.copyOf(input, input.length +1);
        result[input.length] = added;
        return result;
    }

    private static int smallestThreeSum(int[] input){
        // return sum  of three smallest integers in array
        int x1=0,x2=0,x3=0;
        if (input[0]<input[1]) {
            x1=input[0];
            x2=input[1];}
        else {x1=input[1];
            x2=input[0];}
        x3=input[2];

        for(int i=2; i<input.length; i++){
            if (input[i]<x3) {x3=input[i];}
            if(input[i]<x2){
                if(input[i]<x1){
                    x3=x2;
                    x2=x1;
                    x1=input[i];
                }
                else{
                    x3=x2;
                    x2=input[i];
                }
            }
        }
        return (x1 + x2 + x3);
    }

}
