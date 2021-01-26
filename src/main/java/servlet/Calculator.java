package servlet;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static double calc(String str){

        String num[]=str.split("(\\+|\\-|\\*|\\/|\\.)");
        String oper[]=str.split("\\d+");
        List<String> numbers= new ArrayList<>();
        List<String> operations=new ArrayList<>();
        for(int i=0; i<num.length; i++){
            numbers.add(num[i]);
        }
        for(int i=0; i<oper.length; i++){
            operations.add(oper[i]);
        }
        for(int i=0; i<operations.size(); i++){
            if(operations.get(i).equals("")){
                operations.remove(i);
            }
        }


        List <Double> numbersDouble=new ArrayList<>();
        for(int i=0; i<numbers.size(); i++){
            numbersDouble.add(Double.parseDouble(numbers.get(i)));
        }
        showData(numbersDouble,operations, 1);

        for(int i=0; i<operations.size(); i++){
            if(operations.get(i).equals(".")){
                numbersDouble.set(i,Double.parseDouble(""+(int)(double)(numbersDouble.get(i))+"."+(int)(double)(numbersDouble.get(i+1))));
                numbersDouble.remove(i+1);
                operations.remove(i);
                i--;
            }
        }
        showData(numbersDouble,operations, 2);
        for(int i=0; i<operations.size(); i++){
            System.out.println("i:"+i);
            if(operations.get(i).equals("*")||operations.get(i).equals("/")){
                if(operations.get(i).equals("*")){
                    numbersDouble.set(i,numbersDouble.get(i)*numbersDouble.get(i+1));
                }
                if(operations.get(i).equals("/")){
                    numbersDouble.set(i,numbersDouble.get(i)/numbersDouble.get(i+1));
                }
                numbersDouble.remove(i+1);
                operations.remove(i);
                i--;
            }
        }
        showData(numbersDouble,operations, 3);
        for (int i=0; i<operations.size(); i++){
            System.out.println("size: "+operations.size());
            System.out.println("i:"+i);
            if(operations.get(i).equals("+")||operations.get(i).equals("-")){
                if(operations.get(i).equals("+")){
                    numbersDouble.set(i,numbersDouble.get(i)+numbersDouble.get(i+1));
                }else if(operations.get(i).equals("-")){
                    numbersDouble.set(i,numbersDouble.get(i)-numbersDouble.get(i+1));
                }
                numbersDouble.remove(i+1);
                operations.remove(i);
                i--;
            }
        }
        showData(numbersDouble,operations, 4);
        double result=numbersDouble.get(0);
        return result;
    }
    public static void showData(List<Double> a, List<String> b, int n ){
        System.out.println("Данныее: "+n);
        for (int i=0; i<a.size(); i++){
            System.out.println(i+": "+a.get(i) );
        }
        for(int i=0; i<b.size(); i++){
            System.out.println(i+": "+b.get(i));
        }
    }
}
