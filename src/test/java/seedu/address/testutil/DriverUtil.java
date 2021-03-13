package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_COMMUTER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DriveCommand;
import seedu.address.model.human.driver.Driver;

/**
 * A utility class for Driver.
 */
public class DriverUtil {
    /**
     * Returns an add command string for adding the {@code }.
     */
    public static String getDriveCommand(Driver driver, Set<Index> indices) {
        return DriveCommand.COMMAND_WORD + " " + getDriverDetails(driver) + getCommuterDetails(indices);
    }

    public static String getDriverDetails(Driver person) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + person.getName().fullName + " ");
        sb.append(PREFIX_PHONE + person.getPhone().value + " ");
        return sb.toString();
    }

    public static String getCommuterDetails(Set<Index> indices) {
        StringBuilder sb = new StringBuilder();
        for (Index idx : indices) {
            sb.append(PREFIX_COMMUTER + String.valueOf(idx.getOneBased()) + " ");
        }
        return sb.toString();
    }
}
