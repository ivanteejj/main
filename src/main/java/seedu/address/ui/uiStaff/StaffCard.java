package seedu.address.ui.uiStaff;

import java.util.Comparator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.modelStaff.Staff;
import seedu.address.ui.UiPart;

/**
 * An UI component that displays information of a {@code Teacher}.
 */
public class StaffCard extends UiPart<Region> {

  private static final String FXML = "TeacherListCard.fxml";

  /**
   * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX. As a
   * consequence, UI elements' variable names cannot be set to such keywords or an exception will be
   * thrown by JavaFX during runtime.
   *
   * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook
   * level 4</a>
   */

  public final Staff staff;

  @FXML
  private HBox cardPane;
  @FXML
  private Label name;
  @FXML
  private Label id;
  @FXML
  private Label teacherID;
  @FXML
  private Label phone;
  @FXML
  private Label address;
  @FXML
  private Label email;
  @FXML
  private Label salary;
  @FXML
  private Label assignedCourses;
  @FXML
  private FlowPane tags;

  public StaffCard(Staff staff, int displayedIndex) {
    super(FXML);
    this.staff = staff;
    id.setText(displayedIndex + ". ");
    teacherID.setText(staff.getId().value);
    name.setText(staff.getName().fullName);
    phone.setText(staff.getPhone().value);
    address.setText(staff.getAddress().value);
    email.setText(staff.getEmail().value);
    assignedCourses.setText(staff.getAssignedCourses());
    salary.setText("Salary: " + staff.getSalary().value + "\n");
    staff.getTags().stream()
        .sorted(Comparator.comparing(tag -> tag.tagName))
        .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
  }

  @Override
  public boolean equals(Object other) {
    // short circuit if same object
    if (other == this) {
      return true;
    }

    // instanceof handles nulls
    if (!(other instanceof StaffCard)) {
      return false;
    }

    // state check
    StaffCard card = (StaffCard) other;
    return id.getText().equals(card.id.getText())
        && staff.equals(card.staff);
  }
}
