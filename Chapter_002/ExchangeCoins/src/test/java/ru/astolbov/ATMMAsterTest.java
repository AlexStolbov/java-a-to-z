package ru.astolbov;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by alex on 2/18/17.
 */
public class ATMMAsterTest {

    /**
     * Stub.
     */
    @Test
    public void stub() {
        ATMMAster atmMaster = new ATMMAster();
        atmMaster.goToATM();

        assertThat(true, is(true));
    }

}