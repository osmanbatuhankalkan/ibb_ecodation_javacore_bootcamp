package com.osmanbatuhankalkan._3_week;

import java.util.Scanner;

public class faktoriyel_SC {
    public static void main(String[] args) {
        int faktoriyelDegeri;
        Scanner input = new Scanner(System.in);

        System.out.println("Bulmak istediğiniz, Faktoriyel değerini giriniz: ");
        faktoriyelDegeri = input.nextInt();

        int faktoriyelSonuc=1;
        for (int i = 1; i <= faktoriyelDegeri; i++) {
            faktoriyelSonuc=(faktoriyelSonuc*i);
            System.out.println(i+"! "+"Faktoriyel: " + faktoriyelSonuc);

        }
    }

}
