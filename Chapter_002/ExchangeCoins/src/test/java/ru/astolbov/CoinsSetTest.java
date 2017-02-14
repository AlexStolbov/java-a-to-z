package ru.astolbov;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 2/13/17.
 */
public class CoinsSetTest {
    /**
     * Test getters.
     */
    @Test
    public void whenCoinsSetThenGettersWork() {
        CoinsSet.ValuesBanknotes value = CoinsSet.ValuesBanknotes.fiftyDollars;
        int number = 10;
        CoinsSet coinsSet = new CoinsSet(value, number);
        assertThat(coinsSet.getValueCoin(), is(value));
        assertThat(coinsSet.getNumberCoinInSet(), is(number));
        assertThat(coinsSet.totalAmountSet(), is(value.getWeight() * number));
    }

    /**
     * Test exchange.
     */
    @Test
    public void whenSendSumThenReturnNumberCoins() {
        CoinsSet.ValuesBanknotes value = CoinsSet.ValuesBanknotes.fiveCents;
        int number = 30;
        int sum = 125;
        CoinsSet coinsSet = new CoinsSet(value, number);
        assertThat(coinsSet.numberCoinsInSum(sum), is((int) sum / value.getWeight()));
    }

    /**
     * Test toString() of ValuesBanknotes.
     */
    @Test
    public void toStringCoinsSetValuesBanknotes() {
        CoinsSet.ValuesBanknotes value = CoinsSet.ValuesBanknotes.fiftyDollars;
        assertThat(value.toString(), is("50$"));
    }

    /**
     * Test reduce number coins in set.
     */
    @Test
    public void whenReduceCoinsSetThenTotalSumIsSmaller() {
        int number = 3;
        int reduce = 1;
        CoinsSet coinsSet = new CoinsSet(CoinsSet.ValuesBanknotes.oneDollar, number);
        coinsSet.reduceNumberCoinInSet(reduce);
        assertThat(number - reduce, is(coinsSet.getNumberCoinInSet()));
    }

    /**
     * Test numberCoinsInSum().
     */
    @Test
    public void whenSetSumThenGetNumberCoins() {
        CoinsSet.ValuesBanknotes banknotes = CoinsSet.ValuesBanknotes.oneDollar;
        CoinsSet.ValuesBanknotes cent = CoinsSet.ValuesBanknotes.oneCent;
        CoinsSet coinsSet = new CoinsSet(cent, 100);
        assertThat((int) banknotes.getWeight() / cent.getWeight(), is(coinsSet.numberCoinsInSum(banknotes.getWeight())));
    }

    /**
     * Test numberCoinsInSum() when not enough cents.
     */
    @Test
    public void whenNotEnoughCoinsThenGetMaxCoins() {
        CoinsSet.ValuesBanknotes banknotes = CoinsSet.ValuesBanknotes.oneDollar;
        CoinsSet.ValuesBanknotes cent = CoinsSet.ValuesBanknotes.oneCent;
        int maxCents = 50;
        CoinsSet coinsSet = new CoinsSet(cent, maxCents);
        assertThat(maxCents, is(coinsSet.numberCoinsInSum(banknotes.getWeight())));
    }
}