import models.regioni;

public class Main {
    public static void main(String[] args) {
        System.out.print(
                "Comandi ricerca: \n" +
                "• Lasciare vuoto per elenco regioni \n" +
                "• Inserire alcuni caratteri per trovare corrispondenze tra le regioni \n" +
                "• Inserire il nome esatto della regione per ottenere i capoluoghi di regione \n" +
                "• Inserire i nomi esatti di regione e capoluogo separati da una virgola per ottenere i comuni relativi \n"
        );

//        Scanner scanner = new Scanner(System.in);
//        String userInput = scanner.nextLine();
//        for (String obj : args) {
//            System.out.println(obj);
//        }
        regioni.cerca(args[0]);
    }
}