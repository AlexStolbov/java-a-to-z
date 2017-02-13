package ru.astolbov;

/**
 * Created by alex on 2/13/17.
 */
public class ATM {
    private final int COIN_ONE = 1;
    private final int COIN_FIVE = 5;
    private final int COIN_TEN = 10;

    public CoinsSet[] exchangeCoinsSet;

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
                    if (values[i].getValueCoin() > values[i + 1].getValueCoin()) {
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
    public ATM() {
        exchangeCoinsSet = new CoinsSet[3];
        exchangeCoinsSet[0] = new CoinsSet(COIN_TEN, 100);
        exchangeCoinsSet[1] = new CoinsSet(COIN_FIVE, 100);
        exchangeCoinsSet[2] = new CoinsSet(COIN_ONE, 100);

        sort(exchangeCoinsSet);
    }

    /**
     * Exchange banknotes for coins.
     * @param banknotes - banknotes for exchange
     * @return - coins
     */
    public CoinsSet[] ExchangeBanknotesToCoins(CoinsSet[] banknotes) {
        int totalSumBanknotes = 0;
        CoinsSet[] resultExchange = new CoinsSet[exchangeCoinsSet.length];

        for (CoinsSet coin : banknotes) {
            if (coin != null) {
                totalSumBanknotes += coin.totalAmountSet();
            }
        }

        if (totalSumBanknotes > 0) {
            for (int i = (exchangeCoinsSet.length - 1); i >= 0; i--) {
                int fits = exchangeCoinsSet[i].numberCoinsInSumm(totalSumBanknotes);
                if (fits > 0) {
                    resultExchange[i] = new CoinsSet(exchangeCoinsSet[i].getValueCoin(), fits);
                    exchangeCoinsSet[i].reduceNumberCoinInSet(fits);
                    totalSumBanknotes -= resultExchange[i].totalAmountSet();
                }
            }
        }

        return resultExchange;
    }

}
