package at.clientdoc.frontend.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxmlView;
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
@FxmlView("index.fxml")
public class IndexController {

    @FXML
    public AnchorPane newEntryPatient;

    @FXML
    private AnchorPane searchPatientTable;

    @FXML
    public void closeApplication(final ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void openAddNewPatient(final ActionEvent event) {
        this.searchPatientTable.setVisible(false);
        this.newEntryPatient.setVisible(true);
    }

    @FXML
    public void openSearchNewPatient(final ActionEvent event) {
        this.searchPatientTable.setVisible(true);
        this.newEntryPatient.setVisible(false);
    }
}
