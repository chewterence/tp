package seedu.address.model.person.passenger;

import java.util.function.Predicate;

import seedu.address.model.person.driver.Driver;

/**
 * Tests that whether a {@code Passenger} is assigned {@code Driver} matches the status given.
 */
public class IsSpecifiedDriverPredicate implements Predicate<Passenger> {
    private final Driver driver;

    public IsSpecifiedDriverPredicate(Driver driver) {
        this.driver = driver;
    }

    @Override
    public boolean test(Passenger passenger) {

        if (passenger.getDriver().isEmpty()) {
            return false;
        }

        return passenger.getDriver().get().equals(driver);
    }
}
