import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgretmenManager extends Veritabani {
static boolean dur =true;
    static Scanner scan = new Scanner(System.in);

    ///////////////////////////////////////////////////////////////////
    // METODLARIN YANINDAKİ "throws InterruptedException" I SİLMEYİN!!!
    // DAHA SONRA GÖRÜLECEK, PROGRAMIN DÜZGÜN ÇALIŞMASI İÇİN GEREKLİ...
    ///////////////////////////////////////////////////////////////////
    public static void ogretmenMenu() throws InterruptedException {
do {


        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "================= OGRETMEN MENU =================\n" +
                        "\n" +
                        "\t   1- Ogretmenler Listesi Yazdir\t\n" +
                        "\t   2- Soyisimden Ogretmen Bulma\n" +
                        "\t   3- Branstan Ogretmen Bulma\n" +
                        "\t   4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                        "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                        "\t   A- ANAMENU\n" +
                        "\t   Q- CIKIS\n");


        //do while döngüde kalmayı sağlar, switch veya if menülere yönlenmeyi sağlar...
        {
            


            System.out.print("Lutfen Menuden tercihinizi yapiniz:");
            String goster = scan.nextLine();
            switch (goster) {


                case "1": // Ogretmenler Listesi Yazdir.
                    ogretmenListesiYazdir();

                    break;

                case "2": // Soyisimden Ogretmen Bulma
                    soyisimdenOgretmenBulma();
                    break;
                case "3": // Branstan Ogretmen Bulma
                    branstanOgretmenBulma();
                    break;
                case "4": // Bilgilerini Girerek Ogretmen Ekleme
                    ogretmenEkleme();
                    break;
                case "5": // Kimlik No Ile Kayit Silme
                    tcNoIleOgretmenSil();
                    break;
                case "a":
                case "A": // Ana Menü Metodu Çağrılabilmeli
                    Helper.anaMenu();
                    break;
                case "q":
                case "Q": // Çıkış yapılabilmeli
                        dur=false;
                        break;
                default:
                    //   HATALI TERCİH DURUMUNDA TEKRAR SEÇİM İSTENMELİ
                    System.out.println("Lutfen gecerli tercih yapiniz:");

            }
        }
}while (dur);
        // ÇIKIŞ YAPILIRSA
        Helper.projeDurdur();
    }


    public static void tcNoIleOgretmenSil() throws InterruptedException {
        System.out.println("Silinecek ogretmen kimlik no giriniz");
        String silinecekOgretmen = scan.nextLine();

        String silinecekValue = ogretmenlerMap.get(silinecekOgretmen);
        String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);

        System.out.print(silinecekOgretmen + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //////////////////////////////////////////////////////////////////////////////
        //         //
        try {                                                                       //
            boolean sonuc = sonucValue.equals(silinecekValue);                      //
        } catch (Exception e) {                                                     //
            System.out.println("Istediginiz Tc numarasi ile ogretmen bulunamadi");  //
        }                                                                           //
        //////////////////////////////////////////////////////////////////////////////
    }

    public static void ogretmenEkleme() {

        System.out.print("Ogretmenin kimlik numarasini giriniz: ");
        String kimlikNo = scan.nextLine();
        System.out.print("Ogretmenin adini giriniz: ");
        String ad = scan.nextLine();
        System.out.print("Ogretmenin soyadini giriniz: ");
        String soyad = scan.nextLine();
        System.out.print("Ogretmenin dogum yilini giriniz: ");
        String dogumYili = scan.nextLine();
        System.out.print("Ogretmenin aldigi dersi giriniz: ");
        String brans = scan.nextLine();

        String ogretmenBilgisi = ad + ", " + soyad + ", " + dogumYili + ", " + brans;

        ogretmenlerMap.put(kimlikNo, ogretmenBilgisi);
        System.out.println("Yeni ogretmen basariyla eklendi!");
    }


    /////////////// İPUCU METODU    ////////////////////////////////////////////////
    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz Ogretmenin Bransini Giriniz:");
        String istenenBrans = scan.nextLine();

        System.out.print(istenenBrans + " Ogretmenleri Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============BRANS ILE OGRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Brans");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuarr[3])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }
    }

    public static void soyisimdenOgretmenBulma() throws InterruptedException {

        System.out.print("Aradiginiz ogretmenin soyismini Giriniz : ");
        String istenensoyisim = scan.nextLine();

        System.out.print(istenensoyisim + " Ogretmenler Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogrenciEntrySet = ogretmenlerMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============SOYISIM ILE OGRENCİ ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Branş\n" +
                        "--------------------------------------------------------------------------");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> each : ogrenciEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenensoyisim.equalsIgnoreCase(eachValuarr[1])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
                System.out.println("#####---------------------------------------------------#####");
            }
        }

    }


    public static void ogretmenListesiYazdir() throws InterruptedException {


        System.out.println(" Ogretmenler Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println("(TcNo : Isim , Soyisim ,D.Yili ,Branş)");
        System.out.println();
        for (Map.Entry<String, String> entry : ogretmenlerMap.entrySet()) {

            String anahtar = entry.getKey();
            String value = entry.getValue();
            System.out.print(anahtar + ": ");
            System.out.println(value);
            System.out.println("---------------------------");
        }
    }
}



