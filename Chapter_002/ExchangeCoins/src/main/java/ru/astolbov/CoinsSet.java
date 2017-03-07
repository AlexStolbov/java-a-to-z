package ru.astolbov;

/**
 * Created by alex on 2/13/17.
 * A set of coins of the same value
 */
public class CoinsSet {

    /**
     * The types of banknotes.
     */
    enum ValuesBanknotes {
        /**
         * Types cents.
         */
        oneCent(1, "1c"), fiveCents(5, "5c"), tenCents(10, "10c"),
        /**
         * Types dollars.
         */
        oneDollar(100, "1$"), tenDollars(1000, "10$"), fiftyDollars(5000, "50$");

        /**
         * Weight banknotes in cents.
         */
        private int weight;
        /**
         * Representation of banknotes.
         */
        private String view;

        /**
         * Set weight ant view of banknotes.
         * @param w - number cents in banknotes
         * @param s - view
         */
        ValuesBanknotes(int w, String s) {
            this.weight = w;
            this.view = s;
        }

        /**
         * Getter weight.
         * @return - weight
         */
        public int getWeight() {
            return this.weight;
        }

        @Override
        public String toString() {
            return this.view;
        }
    }

    /**
     * The coin value in the set.
     */
    private final ValuesBanknotes valueCoin;

    /**
     * The number of coins in the set.
     */
    private int numberCoinInSet;

    /**
     * Constructor.
     * @param setValueCoin - coin.
     * @param setNumberCoinInSet - number coins in the set.
     */
    public CoinsSet(ValuesBanknotes setValueCoin, int setNumberCoinInSet) {
        this.valueCoin = setValueCoin;
        this.numberCoinInSet = setNumberCoinInSet;
    }

    /**
     * Getter valueCoin.
     * @return - The coin value in the set.
     */
    public ValuesBanknotes getValueCoin() {
        return valueCoin;
    }

    /**
     *Getter numberCoinInSet.
     * @return - The number of coins in the set
     */
    public int getNumberCoinInSet() {
        return numberCoinInSet;
    }

    /**
     *  .
     * @param reduceNumber - value of reduce.
     */
    public void reduceNumberCoinInSet(int reduceNumber) {
        this.numberCoinInSet -= reduceNumber;
    }

    /**
     * The total amount set.
     * @return - total summ
     */
    public int totalAmountSet() {
        return numberCoinInSet * valueCoin.weight;
    }

    /**
     * Calculates the number of coins in total,
     * and return available number of coins.
     * @param totalSum - total.
     * @return - number of coins.
     */
    public int numberCoinsInSum(int totalSum) {
        int fits = totalSum / valueCoin.weight;
        int res = fits;
        if (fits > this.numberCoinInSet) {
            res = this.numberCoinInSet;
        }
        return  res;
    }

    @Override
    public String toString() {
        return String.format("%s x %d", valueCoin, numberCoinInSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CoinsSet coinsSet = (CoinsSet) o;

        if (valueCoin != coinsSet.valueCoin) {
            return false;
        }
        return numberCoinInSet == coinsSet.numberCoinInSet;
    }

    @Override
    public int hashCode() {
        int result;
        if (valueCoin != null) {
            result = valueCoin.hashCode();
        } else {
            result = 0;
        }
        result = 31 * result + numberCoinInSet;
        return result;
    }
}
