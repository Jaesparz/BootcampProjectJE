package View;

import Controller.HistoryController;

public class HistoryView {

    public void showHistory(){
        System.out.println("TRANSACTIONS HISTORY: \n");

        System.out.println("PURCHASES MADE BY YOU: \n");
        HistoryController.getComprasHechas().forEach(System.out::println);

        System.out.println("\nSALES MADE BY YOU: \n");
        HistoryController.getVentasHechas().forEach(System.out::println);

    }
}
