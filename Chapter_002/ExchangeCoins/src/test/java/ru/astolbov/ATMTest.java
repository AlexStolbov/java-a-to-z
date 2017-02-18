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
     * Test exchange 1$ to 100c.
     * @throws Exception - error.
     */
    @Test
    public void whenExchangeOneDollarThenReturnHundredCents() throws Exception {
        ArrayList<CoinsSet> exchangeCoins = new ArrayList<>();
        exchangeCoins.add(new CoinsSet(CoinsSet.ValuesBanknotes.oneCent, 100));
        exchangeCoins.add(null);
        ATM atm = new ATM(exchangeCoins);
        exchangeCoins.remove(null);

        ArrayList<CoinsSet> banknotes = new ArrayList<>();
        banknotes.add(new CoinsSet(CoinsSet.ValuesBanknotes.oneDollar, 1));

        ArrayList<CoinsSet> res = atm.exchangeBanknotesToCoins(banknotes);
        assertThat(res, is(exchangeCoins));

    }

    /**
     * Test exchange zero sum.
     */
    @Test
    public void whenSumForExchangeIsZeroThenReturnSameBanknotes() {
        ArrayList<CoinsSet> exchangeCoins = new ArrayList<>();
        exchangeCoins.add(new CoinsSet(CoinsSet.ValuesBanknotes.oneCent, 1000));
        ATM atm = new ATM(exchangeCoins);

        ArrayList<CoinsSet> banknotes = new ArrayList<>();
        banknotes.add(new CoinsSet(CoinsSet.ValuesBanknotes.oneDollar, 0));

        ArrayList<CoinsSet> res = atm.exchangeBanknotesToCoins(banknotes);
        assertThat(res, is(banknotes));
    }

    /**
     * Test when not enough money in ATM.
     */
    @Test
    public void whenNotEnoughMoneyInATMThenReturnSameBanknotes() {
        ArrayList<CoinsSet> exchangeCoins = new ArrayList<>();
        exchangeCoins.add(new CoinsSet(CoinsSet.ValuesBanknotes.oneCent, 0));
        ATM atm = new ATM(exchangeCoins);

        ArrayList<CoinsSet> banknotes = new ArrayList<>();
        banknotes.add(new CoinsSet(CoinsSet.ValuesBanknotes.oneDollar, 1));

        ArrayList<CoinsSet> res = atm.exchangeBanknotesToCoins(banknotes);
        assertThat(res, is(banknotes));
    }
}