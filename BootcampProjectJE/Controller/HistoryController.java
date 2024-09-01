package Controller;

import Model.BuyOrder;
import Model.SellOrder;

import java.util.ArrayList;

public class HistoryController {

    private static ArrayList<BuyOrder> ventasHechas = new ArrayList<>();
    private static ArrayList<SellOrder> comprasHechas = new ArrayList<>();

    public HistoryController(){

    }

    public static ArrayList<BuyOrder> getVentasHechas() {
        return ventasHechas;
    }

    public static ArrayList<SellOrder> getComprasHechas() {
        return comprasHechas;
    }

    public static void setVentasHechas(BuyOrder ventaHecha) {
        ventasHechas.add(ventaHecha);
    }

    public static void setComprasHechas(SellOrder compraHecha) {
        comprasHechas.add(compraHecha);
    }

    public static void showHistory(){
        System.out.println("TRANSACTIONS HISTORY: \n");

        System.out.println("PURCHASES MADE BY YOU: \n");
        HistoryController.getComprasHechas().forEach(System.out::println);

        System.out.println("\nSALES MADE BY YOU: \n");
        HistoryController.getVentasHechas().forEach(System.out::println);

    }
}
