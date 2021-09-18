package lLambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Lambda_7_LambdaFile {

	public static void main(String[] args) {
		
		// Functional Programming kullanarak bir dosya nasil okunur?
		
		try {
			Files.lines(Paths.get("C:\\Users\\ferha\\eclipse-workspace\\LambdaJAVA\\src\\lLambda\\LambdaFile")).forEach(t -> System.out.print(t));
			
		} catch (IOException e) {
			System.out.println(e);
			
		}
		
		// T�m karakterleri b�y�k harfe d�n�st�r�n ve okuyun.
		
		try {
            Files.lines(Paths.get("C:\\Users\\ferha\\eclipse-workspace\\LambdaJAVA\\src\\lLambda\\LambdaFile")).map(String::toUpperCase).forEach(t->System.out.println(t));
            
        } catch (IOException e) {
            System.out.println(e);
        }
		
		// Metindeki farkli kelimeleri yazdirin.
		
		try {
            Files.lines(Paths.get("C:\\Users\\ferha\\eclipse-workspace\\LambdaJAVA\\src\\lLambda\\LambdaFile")).map(t->t.split(" ")).flatMap(Arrays::stream).map(t->t.replaceAll("\\W","")).distinct().forEach(System.out::println);
                    
        } catch (IOException e) {
            System.out.println(e);
        }
		
        // Metinde "e" iceren t�m kelimeleri yazdirin. (Sayisinida yazdirabilirsiniz.)


        try {
            Files.lines(Paths.get("C:\\Users\\ferha\\eclipse-workspace\\LambdaJAVA\\src\\lLambda\\LambdaFile")).map(t->t.split(" ")).flatMap(Arrays::stream).filter(t->t.contains("e")).forEach(System.out::println);
                    
        } catch (IOException e) {
            System.out.println(e);
        }

	}

}