package com.SaeedKhoury.GUI;

import com.SaeedKhoury.DBCaT.Users;

public class Main {
    public static void main(String[] args)throws Exception {
        /*Scanner in = new Scanner(System.in);
        System.out.println("Enter how many row you want to insert");
        Object [] data = new Object[Skills.SKILLS_COLUM_NUMBER];
        int rowNumbers = in.nextInt();
        for (int i = 0; i < rowNumbers; i++) {
            data[0]=i+100;
            for (int j = 1; j <Skills.SKILLS_COLUM_NUMBER; j++) {
                data[j]=in.nextLine();
            }
            new Skills().insertData(data);
        }*/
        new Users().connection();
    }
}