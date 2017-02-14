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
        for (CoinsSet coin : banknotes) {
            if (coin != null) {
                totalSumBanknotes += coin.totalAmountSet();
            }
        }

        CoinsSet[] resultExchange = new CoinsSet[this.exchangeCoinsSet.length];
        if (totalSumBanknotes > 0) {
            int[] reduce = new int[this.exchangeCoinsSet.length];
            for (int i = (this.exchangeCoinsSet.length - 1); i >= 0; i--) {
                int fits = this.exchangeCoinsSet[i].numberCoinsInSum(totalSumBanknotes);
                if (fits > 0) {
                    resultExchange[i] = new CoinsSet(this.exchangeCoinsSet[i].getValueCoin(), fits);
                    totalSumBanknotes -= resultExchange[i].totalAmountSet();
                    reduce[i] = fits;
                }
                if (totalSumBanknotes == 0 ) {
                    break;
                }
            }
            if (totalSumBanknotes == 0) {
                for (int i = 0; i < reduce.length; i++) {
                    this.exchangeCoinsSet[i].reduceNumberCoinInSet(reduce[i]);
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
