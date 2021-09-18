package lLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda_6_University {

	public static void main(String[] args) {
		
		Lambda_University mathDepartment = new Lambda_University("Digital", "Math", 97, 128);
		Lambda_University literatureDepartment = new Lambda_University("IIBF", "Economy", 98, 134);
		Lambda_University foreignLanguageDepartment = new Lambda_University("EnglishLanguage", "English", 95, 142);
		Lambda_University sportDepartment = new Lambda_University("Sports", "Basketball", 93, 154);
		
		List <Lambda_University> uniList = new ArrayList<>(Arrays.asList(mathDepartment, literatureDepartment, foreignLanguageDepartment, sportDepartment));
		
		
		// 1) Tüm ortalama puanlarin (91)'den büyük olup olmadigini kontrol etmek icin bir yöntem olusturunuz.
		System.out.println(uniList.stream().allMatch(t -> t.getScore() > 91)); // true
		
		
		// 2) Ders adlarindan en az birinin "Matematik" kelimesini icerip icermedigini kontrol etmek icin bir yöntem olusturunuz.
		System.out.println(uniList.stream().anyMatch(t -> t.getDepartment().equals("Math"))); // true
		
		
		// 3) Ortalama puani en yüksek olan kursu yazdirmak icin bir yöntem olusturunuz.
		System.out.println(uniList.stream().sorted(Comparator.comparing(Lambda_University::getScore).reversed()).findFirst()); // Optional[Lambda_University_6 [faculty=IIBF, department=Economy, score=98, studentNo=134]]
		
		
		// 4) Not ortalamasina göre artan siralama yapip ilk elemani atla ve List olarak yazdiriniz.
		System.out.println(uniList.stream().sorted(Comparator.comparing(Lambda_University::getScore)).skip(1).collect(Collectors.toList()));
		

	}

}