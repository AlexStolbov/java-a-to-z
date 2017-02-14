package ru.astolbov;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by alex on 2/13/17.
 */
public class ATM {
     /**
     * A set of coins in ATM for exchange.
     */
    private ArrayList<CoinsSet> exchangeCoinsSet = new ArrayList<>();

    /**
     * Constructor.
     * Fills the ATM with coins.
     * @param exchangeCoins - coins set
     */
    public ATM(CoinsSet[] exchangeCoins) {
        for (CoinsSet coinsSet:exchangeCoins) {
            if (coinsSet != null) {
                this.exchangeCoinsSet.add(coinsSet);
            }
        }
        this.exchangeCoinsSet.sort(new Comparator<CoinsSet>() {
            @Override
            public int compare(CoinsSet o1, CoinsSet o2) {
                return - new Integer(o1.getValueCoin().getWeight()).compareTo(new Integer(o2.getValueCoin().getWeight()));
            }
        });
    }

    /**
     * Exchange banknotes for coins.
     * @param banknotes - banknotes for exchange
     * @return - coins
     */
    public CoinsSet[] exchangeBanknotesToCoins(CoinsSet[] banknotes) {

        int totalSumBanknotes = 0;
        for (CoinsSet coin : banknotes) {
            if (coin != null) {
                totalSumBanknotes += coin.totalAmountSet();
            }
        }

        CoinsSet[] resultExchange = new CoinsSet[this.exchangeCoinsSet.size()];
        if (totalSumBanknotes > 0) {
            int[] reduce = new int[this.exchangeCoinsSet.size()];
            for (int i = 0; i < this.exchangeCoinsSet.size(); i++) {
                int fits = this.exchangeCoinsSet.get(i).numberCoinsInSum(totalSumBanknotes);
                if (fits > 0) {
                    resultExchange[i] = new CoinsSet(this.exchangeCoinsSet.get(i).getValueCoin(), fits);
                    totalSumBanknotes -= resultExchange[i].totalAmountSet();
                    reduce[i] = fits;
                }
                if (totalSumBanknotes == 0) {
                    break;
                }
            }
            if (totalSumBanknotes == 0) {
                for (int i = 0; i < reduce.length; i++) {
                    this.exchangeCoinsSet.get(i).reduceNumberCoinInSet(reduce[i]);
                }
                System.out.println("Take the coins.");
            } else {
                resultExchange = banknotes;
                System.out.println("Sorry, not enough coins for change.");
            }
        } else {
            System.out.println("Please insert bills into the ATM.");
            resultExchange = banknotes;
        }

        return resultExchange;
    }

}