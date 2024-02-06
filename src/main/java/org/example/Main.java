package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //string object
        String s=new String("sriram");
        //litral
        String s1="sriram";
      s1=s1.replace("ri","ar");
        System.out.println(s1);
        s1.startsWith("m");


        String x=String.join("-","sriram", "sunkara");
        System.out.println(x);

        String template="hello %s, welcome to java";
        System.out.println(String.format(template,"sriram","jon"));
        System.out.println(String.format(template,"anjali"));

        int k=s1.length();
       boolean b= s1.isEmpty();
         char[] c1=s.toCharArray();
         for(char c3:c1){
             System.out.println(c3);
         }

         for(int i=0;i<c1.length;i++){
             char c=s.charAt(i);
             System.out.println(c);
         }





    }
}