package com.osmanbatuhankalkan._1_part_javatypes;

public class _02_Variables {
//Veri değişken isimleri yazarken
    /*
     * 1) İsim, veya sıfat, zamir kullanmamız lazım.
     * 2) _ veya $ ile başlayabilirsiniz.
     * 3) Sayı ile bitebilir.
     * 4) Sayı ile başlanmaz.
     * 5)_ veya $ dışında özel simgelerle başlanmaz.
     * 6) Değişken isimleri camelCase kuralına göre yazılır.
     * */
public static void main(String[] args) {
    //Veri isimlendirmeleri;
    //1) isim veya sıfat, zamir kullanmamız lazım.
    int shcoolNumber = 25;
    System.out.println(shcoolNumber);
    shcoolNumber =34;
    System.out.println(shcoolNumber);

    //2) _ veya $ ile başlayabilirsiniz.
    int _schoolNumber = 55;
    System.out.println(_schoolNumber);
    //2) _ veya $ ile başlayabilirsiniz.
    int $schoolNumber = 66;
    System.out.println($schoolNumber);
    //3)Sayı ile bitebilir.
    int schoolNumber324 = 11;
    System.out.println(schoolNumber324);

    //YAZAMAZSINIZ
    //int schoolNumber=11; // aynı isimde yazamazsınız.
    //int 44schoolNumber=11 //sayıyla başlayamazsınız.
    //int özel simgelerle başlanmaz.
    //int ''schoolNumber =11; // özel simgeyle başlayamazsınız.
}

}
