package Controller;

import Model.BuyOrder;
import Model.SellOrder;
import View.HistoryView;

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

        HistoryView view = new HistoryView();
        view.showHistory();


    }
}
