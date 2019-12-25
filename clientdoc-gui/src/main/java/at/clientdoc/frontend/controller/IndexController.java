package at.clientdoc.frontend.controller;

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
    public AnchorPane newEntryKlientIn;

    @FXML
    private AnchorPane searchKlientInTable;

    @FXML
    public void openAddNewKlientIn(final ActionEvent event) {
        this.searchKlientInTable.setVisible(false);
        this.newEntryKlientIn.setVisible(true);
    }

    @FXML
    public void openSearchNewKlientIn(final ActionEvent event) {
        this.searchKlientInTable.setVisible(true);
        this.newEntryKlientIn.setVisible(false);
    }
}
