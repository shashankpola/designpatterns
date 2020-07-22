package com.epam.DesignPatterns.creational;

import java.io.*;

abstract class Plan{
    protected double rate;
    abstract void getR();

    public void calculateBill(int units){
        System.out.print("BILL : ");
        System.out.println(units*rate);
    }
}

class Domestic extends Plan{
    public void getR(){
        rate = 3.75;
    }
}

class Commercial extends Plan{
    public void getR(){
        rate = 7.52;
    }
}

class Institution extends Plan{
    public void getR(){
        rate = 5.56;
    }
}

class GetP{
    public Plan getPlanType(String planType){
        if(planType==null)
            return null;
        else if(planType.equalsIgnoreCase("domestic"))
            return new Domestic();
        else if(planType.equalsIgnoreCase("commercial"))
            return new Commercial();
        else if(planType.equalsIgnoreCase("institution"))
            return new Institution();
        else
            return null;
    }
}


public class Factory {
    public static void main(String args[]) throws IOException{
        GetP get = new GetP();
        System.out.println("Domestic/ Commercial/ Institution");
        System.out.println("enter the type of institution");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String planType = br.readLine();
        System.out.println("Enter number of units for bill");
        int u = Integer.parseInt(br.readLine());

        Plan p = get.getPlanType(planType);
        p.getR();
        p.calculateBill(u);
    }
}
