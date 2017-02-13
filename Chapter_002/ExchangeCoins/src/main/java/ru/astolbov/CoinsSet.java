package ru.astolbov;

/**
 * Created by alex on 2/13/17.
 * A set of coins of the same value
 */
public class CoinsSet {
    /**
     * The coin value in the set.
     */
    private final int valueCoin;

    /**
     * The number of coins in the set.
     */
    private int numberCoinInSet;

    public CoinsSet(int valueCoin, int numberCoinInSet) {
        this.valueCoin = valueCoin;
        this.numberCoinInSet = numberCoinInSet;
    }

    /**
     * Getter valueCoin.
     * @return - The coin value in the set.
     */
    public int getValueCoin() {
        return valueCoin;
    }

    /**
     *Getter numberCoinInSet
     * @return - The number of coins in the set
     */
    public int getNumberCoinInSet() {
        return numberCoinInSet;
    }

    /**
     * Setter numberCoinInSet
     * @param newNumber - number of coins in the set
     */
    public void setNumberCoinInSet(int newNumber) {
        this.numberCoinInSet = newNumber;
    }

    /**
     * Reduces the number of coins.
     * @param reduceNumber - value of reduce.
     */
    public void reduceNumberCoinInSet(int reduceNumber) {
        this.numberCoinInSet -= reduceNumber;
    }

    /**
     * The total amount set
     * @return - total summ
     */
    public int totalAmountSet() {
        return numberCoinInSet * valueCoin;
    }

    /**
     * Calculates the number of coins in total.
     * @param totalSum - total.
     * @return - number of coins.
     */
    public int numberCoinsInSumm(int totalSum) {
        return totalSum / valueCoin;
    }

    @Override
    public String toString() {
        return "CoinsSet{" +
                "valueCoin=" + valueCoin +
                ", numberCoinInSet=" + numberCoinInSet +
                '}';
    }
}
