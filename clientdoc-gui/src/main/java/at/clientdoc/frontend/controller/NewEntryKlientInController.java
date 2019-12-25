package at.clientdoc.frontend.controller;

import at.clientdoc.business.klientin.KlientinBusiness;
import clientdoc.domainmodel.klientIn.Geschlecht;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
@FxmlView("newEntryKlientIn.fxml")
public class NewEntryKlientInController {

    @FXML
    private TextField txtVorname;

    @FXML
    private TextField txtNachname;

    @FXML
    public ComboBox<String> cmbGeschlecht;

    @Autowired
    private KlientinBusiness klientinBusiness;

    @FXML
    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList(
                Geschlecht.WEIBLICH.getGeschlecht(),
                Geschlecht.MAENNLICH.getGeschlecht());
        this.cmbGeschlecht.getItems().addAll(options);
    }

    @FXML
    public void triggerSave(final ActionEvent event) {
        save();
    }

    public void onEnterKeyPressed(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {
            save();
        }
    }

    private void save() {
        String selectedItem = this.cmbGeschlecht.getSelectionModel().getSelectedItem();
        this.klientinBusiness.save(this.txtVorname.getText(), this.txtNachname.getText(),
                Geschlecht.exists(selectedItem) ? Geschlecht.valueOf(selectedItem) : null);
    }
}
