package at.openpatientdoc.frontend.controller;

import at.openpatientdoc.business.patient.PatientBusiness;
import openpatientdoc.domainmodel.patient.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@FxmlView("searchPatient.fxml")
public class PatientSearchController {

    @FXML
    public Label lblVorname;

    @FXML
    private TextField txtVorname;

    @FXML
    public Label lblNachname;

    @FXML
    private TextField txtNachname;

    @FXML
    private TableView<Patient> tableView;

    @Autowired
    private PatientBusiness patientBusiness;

    @FXML
    public void triggerSearch(final ActionEvent event) {
        search();
    }

    public void onEnterKeyPressed(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {
            search();
        }
    }

    private void search() {
        this.tableView.setVisible(true);
        ObservableList<Patient> data = FXCollections.observableList(
                this.patientBusiness.geData(this.txtVorname.getText(), this.txtNachname.getText()));
        this.tableView.setItems(data);
    }
}
