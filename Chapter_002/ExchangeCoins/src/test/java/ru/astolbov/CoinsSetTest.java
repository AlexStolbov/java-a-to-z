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

    /**
     * Test equals different reference in one object.
     */
    @Test
    public void whenSameObjectThenEqualsTrue() {
        CoinsSet c1 = new CoinsSet(CoinsSet.ValuesBanknotes.fiftyDollars, 1);
        CoinsSet c2 = c1;
        assertThat(c1.equals(c2), is(true));
    }

    /**
     * Test equals with null.
     */
    @Test
    public void whenNullThenEqualsFalse() {
        CoinsSet c1 = new CoinsSet(CoinsSet.ValuesBanknotes.fiftyDollars, 1);
        CoinsSet c2 = null;
        assertThat(c1.equals(c2), is(false));
    }

    /**
     * Test equals with other class.
     */
    @Test
    public void whenOtherClassThenEqualsFalse() {
        CoinsSet c1 = new CoinsSet(CoinsSet.ValuesBanknotes.fiftyDollars, 1);
        Integer c2 = new Integer(2);
        assertThat(c1.equals(c2), is(false));
    }

    /**
     * Test equals with different number coin.
     */
    @Test
    public void whenDifferentNumberCoinThenEqualsFalse() {
        CoinsSet c1 = new CoinsSet(CoinsSet.ValuesBanknotes.fiftyDollars, 1);
        CoinsSet c2 = new CoinsSet(CoinsSet.ValuesBanknotes.fiftyDollars, 2);
        assertThat(c1.equals(c2), is(false));
    }

    /**
     * Test equals with different value coin.
     */
    @Test
    public void whenDifferentValueCoinThenEqualsFalse() {
        CoinsSet c1 = new CoinsSet(CoinsSet.ValuesBanknotes.fiftyDollars, 2);
        CoinsSet c2 = new CoinsSet(CoinsSet.ValuesBanknotes.tenDollars, 2);
        assertThat(c1.equals(c2), is(false));
    }

    /**
     * Test equals with all is equally.
     */
    @Test
    public void whenAllEquallyThenEqualsTrue() {
        CoinsSet.ValuesBanknotes vb = CoinsSet.ValuesBanknotes.fiftyDollars;
        int n = 5;
        CoinsSet c1 = new CoinsSet(vb, n);
        CoinsSet c2 = new CoinsSet(vb, n);
        assertThat(c1.equals(c2), is(true));
    }
}