package at.openpatientdoc.frontend.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

    @FXML
    public void openAbout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("about.fxml"));
        // initializing the controller
        AboutController aboutController = new AboutController();
        fxmlLoader.setController(aboutController);

        Scene scene = new Scene(fxmlLoader.load());
        // this is the popup stage
        Stage popupStage = new Stage();
        popupStage.setTitle("About");
        popupStage.initModality(Modality.WINDOW_MODAL);
        popupStage.setScene(scene);
        popupStage.showAndWait();
    }
}
