import java.util.*;

public class OgrenciManager extends Veritabani {
static boolean dur=true;
    static Scanner scan = new Scanner(System.in);

    public static void ogrenciMenu() throws InterruptedException {
        //do while döngüde kalmayı sağlar, switch veya if menülere yönlenmeyi sağlar...
        {
            do {


                System.out.println(
                        "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                                "================== OGRENCI MENU =================\n" +
                                "\t   1- Ogrenci Listesi Yazdir\n" +
                                "\t   2- Soyisimden Ogrenci Bulma\n" +
                                "\t   3- Sinif ve Sube Ile Ogrenci Bulma\n" +
                                "\t   4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                                "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                                "\t   A- ANAMENU\n" +
                                "\t   Q- CIKIS");

                System.out.print("Lutfen Menuden tercihinizi yapiniz:");
                String goster = scan.nextLine();

                switch (goster) {

                    case "1":
                        ogrenciListeYazdir();
                        break;
                    case "2": // Soyisimden Ogrenci Bulma
                        soyisimdenOgrenciBulma();
                        break;
                    case "3": // Sinif ve Sube Ile Ogrenci Bulma
                        sinifVeSubeIleOgrenciBulma();
                        break;
                    case "4": // Bilgilerini Girerek Ogrenci Ekleme
                        ogrenciEkle();
                        break;
                    case "5":
                        tcNoIleOgrenciSilme();
                        break;
                    case "A":
                    case "a":
                        Helper.anaMenu();
                        break;
                    case "Q":
                    case "q":
                        Helper.projeDurdur();
                        dur =false;
                        break;

                    default:
                        //   HATALI TERCİH DURUMUNDA TEKRAR SEÇİM İSTENMELİ
                        System.out.println("Lutfen gecerli tercih yapiniz:");
                }

            } while (dur);
            // ÇIKIŞ YAPILIRSA
            Helper.projeDurdur();
        }

    }

    private static void tcNoIleOgrenciSilme() throws InterruptedException {
        System.out.println("Silinecek ogrenci kimlik no giriniz");
        String silinecekOgrenci = scan.nextLine();

        String silinecekValue = ogrenciMap.get(silinecekOgrenci);
        String sonucValue = ogrenciMap.remove(silinecekOgrenci);

        System.out.print(silinecekOgrenci + "Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        // Bu scope u önemsemeyin, sadece programın çalışmaya devam etmesi için gerekli... Daha sonra görülecek.
        //////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz TC numarasi ile ogrenci bulunamadi");
        }/////////////////////////////////////////////////////////////////////////////////////////////////

    }

    private static void ogrenciEkle() {

        System.out.print("Öğrencinin tc Kimlik numarasını giriniz ->");
        String tcNo = scan.nextLine();
        System.out.print("Öğrenci ismini giriniz ->");
        String isim = scan.nextLine();
        System.out.print("öğrenci soyismini giriniz ->");
        String soyad = scan.nextLine();
        System.out.print("Öğrencinin doğum yılını giriniz ->");
        String dYili = scan.nextLine();
        System.out.print("öğrenci numarası giriniz ->");
        String numara = scan.nextLine();
        System.out.print("Öğrenci sınıfı giriniz->");
        String sinif = scan.nextLine();
        System.out.print("Öğrenci şubesi giriniz->");
        String sube = scan.nextLine();

        ogrenciMap.put(tcNo, (isim + "," + soyad + "," + dYili + "," + numara + "," + sinif + "," + sube));
        System.out.println("Öğrenci eklendi...");


    }

    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {
        System.out.print("Sınıf ve şube bilgisi girin (örn: 12 A): ");
        String sinifVeSube = scan.nextLine();


        System.out.print( sinifVeSube  + " Ogrenciler  Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }


        List<String>ogrenciListesi =new ArrayList<>();

        for (Map.Entry<String, String> entry : ogrenciMap.entrySet()) {
            String ogrenciBilgisi = entry.getValue();
            String[] ogrenciBilgileri = ogrenciBilgisi.split(", ");
            String sınıfVeŞube = ogrenciBilgileri[4] + " " + ogrenciBilgileri[5];

            if (sınıfVeŞube.equals(sinifVeSube)) {
               ogrenciListesi.add(ogrenciBilgisi);

            }
        }

            if (!ogrenciListesi.isEmpty()) {
                System.out.println("Bulunan Öğrenci Bilgileri:");
                for (String ogrenciBilgisi : ogrenciListesi) {
                    String[] ogrenciBilgileri = ogrenciBilgisi.split(", ");
                    String ad = ogrenciBilgileri[0];
                    String soyad = ogrenciBilgileri[1];
                    int dogumYili = Integer.parseInt(ogrenciBilgileri[2]);
                    int numarasi = Integer.parseInt(ogrenciBilgileri[3]);
                    int sinif = Integer.parseInt(ogrenciBilgileri[4]);
                    char sube = ogrenciBilgileri[5].charAt(0);


                    System.out.println("Ad : " + ad + ", Soyad : " + soyad + ", Doğum Yılı : " + dogumYili + ", Notlar : " + numarasi + ",Sınıf VE Şubesi : " + sinif + ", " + sube);
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                }
                }else{
                    System.out.println("Öğrenci bulunamadı.");
            }

                }


    private static void soyisimdenOgrenciBulma() throws InterruptedException {

        System.out.print("Aradiginiz Ogrencinin soyismini Giriniz : ");
        String istenensoyisim = scan.nextLine();

        System.out.print(istenensoyisim  + " Ogrenciler  Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogrenciMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============SOYISIM ILE OGRENCİ ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Numarası , Sınıfı , Şubesi\n"+
                "--------------------------------------------------------------------------");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenensoyisim.equalsIgnoreCase(eachValuarr[1])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
                System.out.println("#####---------------------------------------------------#####");
            }
        }

    }

    private static void ogrenciListeYazdir() throws InterruptedException {
        System.out.println( " Ogrenciler  Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println(" TcNo : Isim , Soyisim , D.Yili , Numarası , Sınıfı , Şubesi");
        System.out.println();
        for (Map.Entry<String, String> entry : ogrenciMap.entrySet()) {
            String anahtar = entry.getKey();
            String value = entry.getValue();
            System.out.print(anahtar + ": ");
            System.out.println(value);
            System.out.println("---------------------------------------------------");
        }

    }
}
