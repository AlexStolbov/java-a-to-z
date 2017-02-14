package ru.astolbov;

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
    private CoinsSet[] banknotes;

    /**
     * Constructor.
     * Set the ATM and money.
     */
    public ATMMAster() {

        CoinsSet[] exchangeCoins = new CoinsSet[3];
        exchangeCoins[0] = new CoinsSet(CoinsSet.ValuesBanknotes.oneCent, 1000);
        exchangeCoins[1] = new CoinsSet(CoinsSet.ValuesBanknotes.fiveCents, 200);
        exchangeCoins[2] = new CoinsSet(CoinsSet.ValuesBanknotes.tenCents, 1000);
        this.atm = new ATM(exchangeCoins);

        this.banknotes = new CoinsSet[3];
        this.banknotes[0] = new CoinsSet(CoinsSet.ValuesBanknotes.fiftyDollars, 1);
        this.banknotes[1] = new CoinsSet(CoinsSet.ValuesBanknotes.tenDollars, 2);
        this.banknotes[2] = new CoinsSet(CoinsSet.ValuesBanknotes.oneDollar, 8);
    }

    /**
     * Exchange money in ATM.
     */
    public void goToATM() {
        this.banknotes = this.atm.exchangeBanknotesToCoins(banknotes);
    }

    @Override
    public String toString() {
        String res = "";
        for (CoinsSet coin:banknotes) {
            if (coin != null) {
                res += coin.toString().concat(System.lineSeparator());
            }
        }
        return res;
    }

    /**
     * Main.
     * @param args - args
     */
    public static void main(String[] args) {
        ATMMAster atmMaster = new ATMMAster();
        atmMaster.goToATM();
        System.out.println(atmMaster);
    }
}
