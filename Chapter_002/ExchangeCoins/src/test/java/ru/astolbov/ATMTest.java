package ru.astolbov;

import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<CoinsSet> exchangeCoins = new ArrayList<>();
        CoinsSet hundredCents = new CoinsSet(CoinsSet.ValuesBanknotes.oneCent, 100);
        exchangeCoins.add(hundredCents);
        ATM atm = new ATM(exchangeCoins);

        ArrayList<CoinsSet> banknotes = new ArrayList<>();
        banknotes.add(new CoinsSet(CoinsSet.ValuesBanknotes.oneDollar, 1));

        ArrayList<CoinsSet>res = atm.exchangeBanknotesToCoins(banknotes);
        assertThat(res, is(hundredCents));

    }

}