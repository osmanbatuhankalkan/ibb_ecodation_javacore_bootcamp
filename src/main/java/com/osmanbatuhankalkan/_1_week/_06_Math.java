package com.osmanbatuhankalkan._1_week;

public class _06_Math {
    public static void main(String[] args) {
        System.out.println("En küçük: "+Math.min(-300,10));
        System.out.println("En küçük: "+Math.max(-300,10));

        System.out.println("En küçük: "+Math.abs(7));//abs Mutlak değer olara karşımıza gelir.

        System.out.println("Karekök: "+Math.sqrt(-32));
        System.out.println("Karekök: "+Math.sqrt(32));
        System.out.println("Karekök: "+Math.sqrt(+32));
        System.out.println("Karekök: "+Math.sqrt(Math.abs(-32)));

        System.out.println("Üslü: "+Math.pow(2,5));//üslü ifadeler

        System.out.println("üst Yuvarla: "+Math.floor(2.5));//üste yuvarlar

        System.out.println("Alta Yuvarla: "+Math.ceil(2.1));
        System.out.println("Alta Yuvarla: "+Math.ceil(2.0000002));

        System.out.println("Ortalama Yuvarla: "+Math.round(3.6));
        System.out.println("Ortalama Yuvarla: "+Math.round(8.6));

        System.out.println("PI sayısı: "+Math.PI);
        System.out.println("E sayısı: "+Math.E);

        System.out.println("Trigonometrik sinüs: "+Math.sin(1));
        System.out.println("Trigonometrik sinüs: "+Math.asin(1));
    }
}
