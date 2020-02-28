package at.clientdoc.frontend.controller;

import at.clientdoc.business.patient.PatientBusiness;
import clientdoc.domainmodel.patient.Sex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @FXML
    private TextField txtForename;

    @FXML
    private TextField txtSurename;

    @FXML
    public ComboBox<String> cmbSex;

    @Autowired
    private PatientBusiness patientBusiness;

    @FXML
    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList(EnumUtils.getEnumList(Sex.class)
                .stream()
                .map(Enum::toString)
                .collect(Collectors.toList()));
        this.cmbSex.getItems().addAll(options);
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
