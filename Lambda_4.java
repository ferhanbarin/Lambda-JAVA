package lLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda_4 {

	public static void main(String[] args) {
		
		List <String> myList = new ArrayList<>(Arrays.asList("Ali", "Ali", "Aysima", "Abdurrahman", "Mehmet", "Mustafa", "Bedirhan", "Yüksel", "Süleyman"));
		
		yazdirBüyük1(myList);
	System.out.println();
		
		uzunlukSirala(myList);
	System.out.println();
	
		farkliSonHarfSirala(myList);
	System.out.println();
		
		uzunlukSiralaIlkEleman(myList);
	System.out.println();
		
		yazdirAIleBasyan(myList);
	System.out.println();
		
		AbaslaVeyaiBit(myList);
	System.out.println();
	
		siralaBüyüt(myList);
	System.out.println();
	
		isimUzunlukSirala(myList);
	System.out.println();
	
		karesiniAlSiralaSil(myList);
	System.out.println();
	
		ebikGabik(myList);
	System.out.println();
	
		sondanIkinciSiralaIlk(myList);
	System.out.println();
		
		terstenSiralaIlkYazdir(myList);
	System.out.println();
		
	}

	// 1) List'in elemanlarini büyük harfle yazdiriniz.
	public static void yazdirBüyük1(List <String> myList) {
		
		// I. YOL
		myList.stream().map(t -> t.toUpperCase()).forEach(Lambda_Methods::bosluklaYazdir); // AL? AL? AYS?MA ABDURRAHMAN MEHMET MUSTAFA BED?RHAN YÜKSEL SÜLEYMAN
		
		System.out.println();
		
		// II. YOL
		myList.stream().map(String::toUpperCase).forEach(Lambda_Methods::bosluklaYazdir); // AL? AL? AYS?MA ABDURRAHMAN MEHMET MUSTAFA BED?RHAN YÜKSEL SÜLEYMAN
		
	}
	
	// 2) Elemanlari uzunluklarina göre siralayin ve yazdirin.  -  NOTE: JAVA elemanlari varsayilan olarak artan siraya koyar.
	public static void uzunlukSirala(List <String> myList) {
		
		myList.stream().sorted(Comparator.comparing(String::length)).forEach(Lambda_Methods::bosluklaYazdir); // Ali Ali Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman 
		
		System.out.println();
		
		myList.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Lambda_Methods::bosluklaYazdir); // Abdurrahman Bedirhan Süleyman Mustafa Aysima Mehmet Yüksel Ali Ali 
	}
	
	// 3) Farkli elemanlarini son harflerine göre siralayin.
	public static void farkliSonHarfSirala(List <String> myList) {
		
		myList.stream().distinct().sorted(Comparator.comparing(t -> t.substring(t.length()-1))).forEach(Lambda_Methods::bosluklaYazdir); // Aysima Mustafa Ali Yüksel Abdurrahman Bedirhan Süleyman Mehmet 
		
	}
	
	// 4) Elemanlari uzunluklarina ve ardindan (ayni uzunlukta olanlari) ilk karakterlerine göre siralamak icin bir yöntem olusturunuz.
	public static void uzunlukSiralaIlkEleman(List <String> myList) {
		
		myList.add("Ata");
		myList.stream().sorted(Comparator.comparing(String::length).thenComparing(t -> t.charAt(0))).forEach(Lambda_Methods::bosluklaYazdir); // Ali Ali Ata Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman 
		
		System.out.println();
		
		myList.stream().sorted(Comparator.comparing(String::length).thenComparing(t -> t.substring(0, 1))).forEach(Lambda_Methods::bosluklaYazdir); // Ali Ali Ata Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman
	}
	
	// 5) Büyük harflerle, "A" ile baslayan liste ögelerini yazdirmak icin bir yöntem olusturunuz.
	public static void yazdirAIleBasyan(List <String> myList) {
		
		myList.stream().filter(t -> t.startsWith("A")).map(t -> t.toUpperCase()).forEach(Lambda_Methods::bosluklaYazdir); // ALI ALI AYSIMA ABDURRAHMAN ATA 
		
	}
	
	// 6) Küçük harflerle, "A" ile baslayan veya "i" ile biten liste ögelerini yazdirmak için bir yöntem olusturunuz.
	public static void AbaslaVeyaiBit(List <String> myList) {
		
		myList.stream().filter(t -> t.startsWith("A") || t.endsWith("i")).map(t -> t.toLowerCase()).forEach(Lambda_Methods::bosluklaYazdir); // ali ali aysima abdurrahman ata 
		
		// Method Reference ile yaparsak komutlarin icine sadece bir islem alabiliriz. Arrow (->) function'da "& ve ||" ile istedigimiz kadar islem alabiliriz.
		
	}
	
	// 7) Ogeleri uzunluklarina göre siraladiktan sonra büyük harflerle yazdirmak icin bir yöntem olusturunuz.
	public static void siralaBüyüt(List <String> myList) {
		
		myList.stream().map(String::toUpperCase).sorted(Comparator.comparing(String::length)).forEach(Lambda_Methods::bosluklaYazdir); // ALI ALI ATA AYSIMA MEHMET YÜKSEL MUSTAFA BEDIRHAN SÜLEYMAN ABDURRAHMAN 
		
	}
	
	// 8) Elemanlari uzunluklarina göre siralayin önce elemani sonra uzunlugunu yazdiriniz.  -  Ali:3  Aysima:6
	public static void isimUzunlukSirala(List <String> myList) {
		
		myList.stream().sorted(Comparator.comparing(String::length)).map(t -> t + ":" + t.length()).forEach(Lambda_Methods::bosluklaYazdir); // Ali:3 Ali:3 Ata:3 Aysima:6 Mehmet:6 Yüksel:6 Mustafa:7 Bedirhan:8 Süleyman:8 Abdurrahman:11 
		
		// Degisiklik yapmak istiyorsak "map()" kullanilir.
	}
	
	// 9) Her elemanin uzunlugunun karesini alip tekrarlilari silip, bunlarin 20'den büyük olanlarini ters sirada yazdiriniz. 
	public static void karesiniAlSiralaSil(List <String> myList) {
		
		myList.stream().map(t -> t.length()*t.length()).distinct().filter(t -> t>20).sorted(Comparator.reverseOrder()).forEach(Lambda_Methods::bosluklaYazdir); // 121 64 49 36 
		
	}
	
	// 10) Tüm elemanlarin uzunluklarinin 12'den az olup olmadigini kontrol etmek için bir method olusturunuz.
	//     Bütün elemanlarin "x" ile baslamadigini kontrol etmek için bir yöntem olusturunuz.
	//     En az 1 tane "R" ile biten eleman olup olmadigini kontrol etmek için bir metod olusturunuz. 
	public static void ebikGabik(List <String> myList) {
		
		boolean result1 = myList.stream().allMatch(t -> t.length()<12); // true
		System.out.println("Elemanlarin uzunluklari 12'den kücük mü? : " + result1);
		
	// allMatch(): Bütün elemanlarda olmasini istedigimiz seyleri yazariz sonuç boolean verir.
	// Ornegin String bir List icin ==> allMatch(t -> t.length() < 7) == elemanlarin hepsinin uzunlugu 7'den kücükse true, biri bile degilse false verir.
				
		
		boolean result2 = myList.stream().noneMatch(t -> t.startsWith("X")); // true
		System.out.println("'X' ile baslayan öge yok mu? : " + result2);
		
	// noneMatch(): Hicbir elemanda olmasin istersek kullaniriz. Elemanlarin tümünde yoksa true, bir tane elemanda bile varsa false verir. 
	// Ornegin ==> noneMatch(t-> t.startsWith("X")) == Hicbiri X ile baslamiyorsa true.
		
				
		boolean result3 = myList.stream().anyMatch(t -> t.endsWith("R")); // false
		System.out.println("En az 1 tane 'R' ile biten eleman varmi? : " + result3);
		
	// anyMatch(): En az bir elemanda olmasini istedigimiz bir özellik varsa kullaniriz, sonuc boolean verir.
	// Ornegin ==> anyMatch(t-> t.endsWith("R")) == En az bir eleman R ile bitiyorsa true, yoksa false verir.
		
	}
	
	// 11) Elemanlari sondan 2. elemanlarina göre siralayip ilk elemani yazdiriniz.
	public static void sondanIkinciSiralaIlk(List <String> myList) {
		
		System.out.println(myList.stream().sorted(Comparator.comparing(t -> t.charAt(t.length()-2))).findFirst()); // Optional[Abdurrahman]
		
		
	// findFirst(): Listedeki ilk elemani verir.(Tek eleman verecegi icin, forEach ile yazdirilmaz. Bütün soru syso'nun icine alinarak yazdirilabilir.
		
	}
	
	// 12) Elemanlari uzunluklarina göre tersten siralayip ilk elemani yazdiriniz.
	public static void terstenSiralaIlkYazdir(List <String> myList) {
		
		System.out.println(myList.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst()); // Optional[Abdurrahman]

	}
}	