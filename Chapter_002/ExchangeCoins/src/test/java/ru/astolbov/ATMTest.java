package ru.astolbov;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 2/13/17.
 */
public class ATMTest {

    /**
     * Test.
     * @throws Exception - error.
     */
    @Test
    public void exchangeBanknotesToCoins() throws Exception {
        CoinsSet[] exchangeCoins = new CoinsSet[2];
        CoinsSet hundredCents = new CoinsSet(CoinsSet.ValuesBanknotes.oneCent, 100);
        exchangeCoins[0] = hundredCents;
        ATM atm = new ATM(exchangeCoins);

        CoinsSet[] banknotes = new CoinsSet[2];
        banknotes[0] = new CoinsSet(CoinsSet.ValuesBanknotes.oneDollar, 1);

        CoinsSet[] res = atm.exchangeBanknotesToCoins(banknotes);
        assertThat(res, is(hundredCents));

    }

}