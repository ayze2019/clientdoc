package at.clientdoc.frontend.controller;

import at.clientdoc.business.patient.PatientBusiness;
import clientdoc.domainmodel.patient.Sex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

/**
 * @author fs-green
 * @date 24.12.19
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
@Component
@FxmlView("newEntryPatient.fxml")
public class NewEntryPatientController {

    public static final String DATE_FORMAT = "dd.MM.yyyy";
    @FXML
    private TextField txtForename;

    @FXML
    private TextField txtSurename;

    @FXML
    private ComboBox<String> cmbSex;

    @FXML
    private DatePicker dpBirthdate;

    @FXML
    private TextField txtSocialInsuranceId;

    @FXML
    private TextField txtSocialInsuranceCarrier;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtPhoneNumber;

    @Autowired
    private PatientBusiness patientBusiness;

    @FXML
    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList(EnumUtils.getEnumList(Sex.class)
                .stream()
                .map(Enum::toString)
                .collect(Collectors.toList()));
        this.cmbSex.getItems().addAll(options);

        this.dpBirthdate.setConverter(new StringConverter<>() {
            String pattern = DATE_FORMAT;
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        dpBirthdate.setPromptText(DATE_FORMAT);
    }

    @FXML
    public void triggerSave(final ActionEvent event) {
        save();
    }

    private void save() {
        String selectedItem = this.cmbSex.getSelectionModel().getSelectedItem();
        this.patientBusiness.save(this.txtForename.getText(), this.txtSurename.getText(),
                Sex.exists(selectedItem) ? Sex.valueOf(selectedItem) : null);
    }
}
