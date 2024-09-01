package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class OrderBook {

    private static ArrayList<SellOrder> sellordersBitcoin = new ArrayList<>();
    private static ArrayList<SellOrder> sellordersEthereum = new ArrayList<>();
    private static ArrayList<BuyOrder> buyordersBitcoin = new ArrayList<>();
    private static ArrayList<BuyOrder> buyordersEthereum = new ArrayList<>();

    public OrderBook() {
        sellordersBitcoin = new ArrayList<>();
        sellordersEthereum = new ArrayList<>();
        buyordersBitcoin = new ArrayList<>();
        buyordersEthereum = new ArrayList<>();
    }

    static String dataSellOrdersBitcoin = "Files/SellOrdersBitcoin";
    static String dataSellOrdersEthereum = "Files/SellOrdersEthereum";
    static String dataBuyOrdersBitcoin = "Files/BuyOrdersBitcoin";
    static String dataBuyOrdersEthereum = "Files/BuyOrdersEthereum";

    public static ArrayList<SellOrder> getSellOrdersBitcoin() {
    try(BufferedReader br = new BufferedReader(new FileReader(dataSellOrdersBitcoin))) {

        String line = null;
        while ((line = br.readLine()) != null) {
            String[] Data = line.split(",");
            BigDecimal amountValue = new BigDecimal(Data[1]);
            BigDecimal sellValue = new BigDecimal(Data[2]);
            SellOrder sellOrder = new SellOrder(Data[0], amountValue,sellValue);

            sellordersBitcoin.add(sellOrder);
        }
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    return sellordersBitcoin;
}
    public static ArrayList<SellOrder> getSellOrdersEthereum() {
        try(BufferedReader br = new BufferedReader(new FileReader(dataSellOrdersEthereum))) {

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] Data = line.split(",");
                BigDecimal amountValue = new BigDecimal(Data[1]);
                BigDecimal sellValue = new BigDecimal(Data[2]);
                SellOrder sellOrder = new SellOrder(Data[0], amountValue,sellValue);

                sellordersEthereum.add(sellOrder);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return sellordersEthereum;
    }

    public static ArrayList<BuyOrder> getBuyOrdersBitcoin() {
        try(BufferedReader br = new BufferedReader(new FileReader(dataBuyOrdersBitcoin))) {

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] Data = line.split(",");
                BigDecimal amountValue = new BigDecimal(Data[1]);
                BigDecimal sellValue = new BigDecimal(Data[2]);
                BuyOrder buyOrder = new BuyOrder(Data[0], amountValue,sellValue);

                buyordersBitcoin.add(buyOrder);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return buyordersBitcoin;
    }

    public static ArrayList<BuyOrder> getBuyOrdersEthereum() {
        try(BufferedReader br = new BufferedReader(new FileReader(dataBuyOrdersEthereum))) {

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] Data = line.split(",");
                BigDecimal amountValue = new BigDecimal(Data[1]);
                BigDecimal sellValue = new BigDecimal(Data[2]);
                BuyOrder buyOrder = new BuyOrder(Data[0], amountValue,sellValue);

                buyordersEthereum.add(buyOrder);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return buyordersEthereum;
    }

    public static ArrayList<BuyOrder> getBuyordersBitcoin() {
        return buyordersBitcoin;
    }

    public static ArrayList<BuyOrder> getBuyordersEthereum() {
        return buyordersEthereum;
    }

    public static ArrayList<SellOrder> getSellordersEthereum() {
        return sellordersEthereum;
    }

    public static ArrayList<SellOrder> getSellordersBitcoin() {
        return sellordersBitcoin;
    }



}




