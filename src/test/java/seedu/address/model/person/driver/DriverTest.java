package seedu.address.model.person.driver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDrivers.ALICE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.DriverBuilder;
import seedu.address.testutil.TypicalDrivers;

public class DriverTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Driver(null, null));
    }

    @Test
    public void isSameDriver() {
        // same object -> returns true
        assertTrue(ALICE.isSameDriver(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameDriver(null));

        // same name, all other attributes different -> returns true
        Driver editedAlice = new DriverBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertTrue(ALICE.isSameDriver(editedAlice));

        // different name, all other attributes same -> returns false
        editedAlice = new DriverBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.isSameDriver(editedAlice));

        // name differs in case, all other attributes same -> returns false
        Driver editedBob = new DriverBuilder(TypicalDrivers.BOB).withName(VALID_NAME_BOB.toLowerCase()).build();
        assertFalse(TypicalDrivers.BOB.isSameDriver(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
        editedBob = new DriverBuilder(TypicalDrivers.BOB).withName(nameWithTrailingSpaces).build();
        assertFalse(TypicalDrivers.BOB.isSameDriver(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Driver aliceCopy = new DriverBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different passenger -> returns false
        assertFalse(ALICE.equals(TypicalDrivers.BOB));

        // different name -> returns false
        Driver editedAlice = new DriverBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new DriverBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));
    }
}
