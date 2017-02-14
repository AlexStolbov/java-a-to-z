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
    public  void whenSendSumThenReturnNumberCoins() {
        CoinsSet.ValuesBanknotes value = CoinsSet.ValuesBanknotes.fiveCents;
        int number = 30;
        int sum = 125;
        CoinsSet coinsSet = new CoinsSet(value, number);
        assertThat(coinsSet.numberCoinsInSum(sum), is((int) sum / value.getWeight()));
    }

}