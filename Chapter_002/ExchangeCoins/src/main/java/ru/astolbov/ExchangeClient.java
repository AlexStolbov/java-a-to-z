package ru.astolbov;

/**
 * Created by alex on 2/13/17.
 */
public class ExchangeClient {

    public static void main(String[] args) {
        ATM atm = new ATM();
        CoinsSet[] banknotes = new CoinsSet[3];
        banknotes[0] = new CoinsSet(104, 1);
        banknotes[1] = new CoinsSet(5, 4);
        banknotes[2] = new CoinsSet(1, 4);
        CoinsSet[] res = atm.ExchangeBanknotesToCoins(banknotes);
        for (CoinsSet coin:res) {
            if (coin != null) {
                System.out.println(coin);
            }
        }
    }
}
