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
    public ATM(ArrayList<CoinsSet> exchangeCoins) {
        for (CoinsSet coinsSet:exchangeCoins) {
            if (coinsSet != null) {
                this.exchangeCoinsSet.add(new CoinsSet(coinsSet.getValueCoin(), coinsSet.getNumberCoinInSet()));
            }
        }
    }

    /**
     * Calculate total sum in CoinsSet array.
     * @param coinsSets - array
     * @return - sum
     */
    public int totalOfArrayCoinsSet(ArrayList<CoinsSet> coinsSets) {
        int totalSumBanknotes = 0;
        coinsSets.remove(null);
        for (CoinsSet coin : coinsSets) {
            totalSumBanknotes += coin.totalAmountSet();
        }
        return  totalSumBanknotes;
    }

    /**
     * Exchange banknotes for coins.
     * @param banknotes - banknotes for exchange
     * @return - coins
     */
    public ArrayList<CoinsSet> exchangeBanknotesToCoins(ArrayList<CoinsSet> banknotes) {

        int totalSumBanknotes = totalOfArrayCoinsSet(banknotes);
        ArrayList<CoinsSet> resultExchange;

        if (totalSumBanknotes > 0) {
            if (totalOfArrayCoinsSet(this.exchangeCoinsSet) >= totalSumBanknotes) {
                resultExchange = pickUpExchangeCoins(banknotes);
                if (totalSumBanknotes != totalOfArrayCoinsSet(resultExchange)) {
                    System.out.println("Sorry, ATM error. Call service.");
                    resultExchange = banknotes;
                }
            } else {
                System.out.println("Sorry, not enough coins for change.");
                resultExchange = banknotes;
            }
        } else {
            System.out.println("Please insert bills into the ATM.");
            resultExchange = banknotes;
        }
        return resultExchange;
    }

    /**
     * Sort by total sum of set of cents.
     * @param arrayCoinsSet - array
     */
    private void sortArrayCoinsSetBySum(ArrayList<CoinsSet> arrayCoinsSet) {
        arrayCoinsSet.sort(new Comparator<CoinsSet>() {
            @Override
            public int compare(CoinsSet o1, CoinsSet o2) {
                return -Integer.compare(o1.totalAmountSet(), o2.totalAmountSet());
            }
        });
    }

    /**
     * Sort by total value of cents in set.
     * @param arrayCoinsSet - array
     */
    private void sortArrayCoinsSetByWeight(ArrayList<CoinsSet> arrayCoinsSet) {
        arrayCoinsSet.sort(new Comparator<CoinsSet>() {
            @Override
            public int compare(CoinsSet o1, CoinsSet o2) {
                return -Integer.compare(o1.getValueCoin().getWeight(), o2.getValueCoin().getWeight());
            }
        });
    }

    /**
     * Pick up coins to exchange.
     * @param banknotes - banknotes
     * @return - coins.
     */
    private ArrayList<CoinsSet> pickUpExchangeCoins(ArrayList<CoinsSet> banknotes) {

        sortArrayCoinsSetBySum(exchangeCoinsSet);

        //Array with the % of coins in the total amount in the ATM
        int totalSumATM = totalOfArrayCoinsSet(this.exchangeCoinsSet);
        float[] percentInTotal = new float[this.exchangeCoinsSet.size()];
        for (int i = 0; i < this.exchangeCoinsSet.size(); i++) {
            percentInTotal[i] = (float) this.exchangeCoinsSet.get(i).totalAmountSet() / totalSumATM;
        }

        int totalSumBanknotes = totalOfArrayCoinsSet(banknotes);
        ArrayList<CoinsSet> resultExchange = new ArrayList<>();
        for (int i = 0; i < this.exchangeCoinsSet.size(); i++) {
            int sumForExchangeOnThisStep = Math.round(totalSumBanknotes * percentInTotal[i]);
            if ((i + 1) == this.exchangeCoinsSet.size()) {
                sumForExchangeOnThisStep = totalSumBanknotes - totalOfArrayCoinsSet(resultExchange);
            }
            int fits = this.exchangeCoinsSet.get(i).numberCoinsInSum(sumForExchangeOnThisStep);
            if (fits > 0) {
                resultExchange.add(new CoinsSet(this.exchangeCoinsSet.get(i).getValueCoin(), fits));
                this.exchangeCoinsSet.get(i).reduceNumberCoinInSet(fits);
            }
        }

        sortArrayCoinsSetByWeight(resultExchange);
        return resultExchange;
    }

}