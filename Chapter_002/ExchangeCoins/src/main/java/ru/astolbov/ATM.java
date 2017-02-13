package ru.astolbov;

/**
 * Created by alex on 2/13/17.
 */
public class ATM {
     /**
     * A set of coins in ATM for exchange.
     */
    private CoinsSet[] exchangeCoinsSet;

    /**
     * Sort coins set in ATM.
     * @param values an array which is sorted
     */
    private void sort(CoinsSet[] values) {
        boolean nextStep;
        CoinsSet change;
        int lengthArray = values.length;
        if (lengthArray > 0) {
            do {
                nextStep = false;
                for (int i = 0; i < (lengthArray - 1); i++) {
                    if (values[i].getValueCoin().getWeight() > values[i + 1].getValueCoin().getWeight()) {
                        change = values[i];
                        values[i] = values[i + 1];
                        values[i + 1] = change;
                        nextStep = true;
                    }
                }
            } while (nextStep);
        }
    }

    /**
     * Constructor.
     * Fills the ATM with coins.
     */
    public ATM(CoinsSet[] exchangeCoins) {
        this.exchangeCoinsSet = exchangeCoins.clone();
        sort(this.exchangeCoinsSet);
    }

    /**
     * Exchange banknotes for coins.
     * @param banknotes - banknotes for exchange
     * @return - coins
     */
    public CoinsSet[] exchangeBanknotesToCoins(CoinsSet[] banknotes) {
        int totalSumBanknotes = 0;
        CoinsSet[] resultExchange = new CoinsSet[this.exchangeCoinsSet.length];

        for (CoinsSet coin : banknotes) {
            if (coin != null) {
                totalSumBanknotes += coin.totalAmountSet();
            }
        }

        if (totalSumBanknotes > 0) {
            int totalSumCoins = 0;
            int restSumBanknotes = totalSumBanknotes;
            int addSum = 0;
            for (int i = (this.exchangeCoinsSet.length - 1); i >= 0; i--) {
                int fits = this.exchangeCoinsSet[i].numberCoinsInSum(restSumBanknotes);
                if (fits > 0) {
                    resultExchange[i] = new CoinsSet(this.exchangeCoinsSet[i].getValueCoin(), fits);
                    addSum = resultExchange[i].totalAmountSet();
                    restSumBanknotes -= addSum;
                    totalSumCoins += addSum;
                }
            }
            if (totalSumCoins > totalSumBanknotes) {
                for (CoinsSet coins:resultExchange) {
                    this.exchangeCoinsSet[i].reduceNumberCoinInSet(fits);
                }
            } else {
                resultExchange = banknotes;
            }
        } else {
            resultExchange = banknotes;
        }

        return resultExchange;
    }

}
