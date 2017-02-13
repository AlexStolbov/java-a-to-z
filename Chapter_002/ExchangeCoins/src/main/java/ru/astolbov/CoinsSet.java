package ru.astolbov;

/**
 * Created by alex on 2/13/17.
 * A set of coins of the same value
 */
public class CoinsSet {

    enum ValuesBancnotes {
        oneCent(1), fiveCents(5), tenCents(10), oneDollar(100), tenDollars(1000),
        fiftyDollars(5000);

        private int weight;
        ValuesBancnotes(int w) {
            this.weight = w;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    /**
     * The coin value in the set.
     */
    private final ValuesBancnotes valueCoin;

    /**
     * The number of coins in the set.
     */
    private int numberCoinInSet;

    /**
     * Constructor.
     * @param setValueCoin - coin.
     * @param setNumberCoinInSet - number coins in the set.
     */
    public CoinsSet(ValuesBancnotes setValueCoin, int setNumberCoinInSet) {
        this.valueCoin = setValueCoin;
        this.numberCoinInSet = setNumberCoinInSet;
    }

    /**
     * Getter valueCoin.
     * @return - The coin value in the set.
     */
    public ValuesBancnotes getValueCoin() {
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
     * Reduces the number of coins.
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
        return fits <= this.numberCoinInSet ? fits : this.numberCoinInSet;
    }

    @Override
    public String toString() {
        return String.format("Coins set{ Value coin = %d , Number coins = %d }", valueCoin.getWeight(), numberCoinInSet);
    }
}
