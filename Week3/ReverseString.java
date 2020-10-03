
import java.util.*;

public class ReverseString {


    public String reverse(String s){

        s=s.trim();
        int count=0;
        String output="";


        if(s.length()==0){

            return "";
        }

        else
        {
            int i=s.length()-1;

            while(i!=0) {
                count++;
                if (s.charAt(i) == ' ') {
                    if(s.charAt(i+1)==' ')  {
                        i--;
                        count=0;
                        continue;
                    }
                    output = output + s.substring(i + 1, i + count) + " ";
                    count = 0;

                }
                i--;

            }
            output = output = output + s.substring(i, i + count + 1) + " ";
        }

        return output.trim();
    }




    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter String to reverse");
        String inputString=sc.nextLine();
        ReverseString obj=new ReverseString();
        String outputString=obj.reverse(inputString);
        System.out.println(outputString);



    }
}