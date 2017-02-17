package ru.astolbov;

import java.util.ArrayList;

/**
 * Created by alex on 2/13/17.
 */
public class ATMMAster {

    /**
     * ATM.
     */
    private ATM atm;
    /**
     * Money.
     */
    private ArrayList<CoinsSet> banknotes;

    /**
     * Constructor.
     * Set the ATM and money.
     */
    public ATMMAster() {

        ArrayList<CoinsSet> exchangeCoins = new ArrayList<>();
        exchangeCoins.add(new CoinsSet(CoinsSet.ValuesBanknotes.oneCent, 1000));
        exchangeCoins.add(new CoinsSet(CoinsSet.ValuesBanknotes.fiveCents, 1000));
        exchangeCoins.add(new CoinsSet(CoinsSet.ValuesBanknotes.tenCents, 500));
        this.atm = new ATM(exchangeCoins);

        this.banknotes = new ArrayList<>();
        this.banknotes.add(new CoinsSet(CoinsSet.ValuesBanknotes.fiftyDollars, 1));
        this.banknotes.add(new CoinsSet(CoinsSet.ValuesBanknotes.tenDollars, 4));
        this.banknotes.add(new CoinsSet(CoinsSet.ValuesBanknotes.oneDollar, 7));
    }

    /**
     * Exchange money in ATM.
     */
    public void goToATM() {
        System.out.printf("For exchange: %s %s", this.banknotes, System.lineSeparator());
        this.banknotes = this.atm.exchangeBanknotesToCoins(this.banknotes);
        System.out.printf("Result exchange: %s %s", this.banknotes, System.lineSeparator());
    }

    /**
     * Main.
     * @param args - args
     */
    public static void main(String[] args) {
        ATMMAster atmMaster = new ATMMAster();
        atmMaster.goToATM();
    }
}
