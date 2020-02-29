package at.openpatientdoc.frontend.controller;

import at.openpatientdoc.business.greeter.Greeter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fs-green
 * @date 21.12.19
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
@FxmlView("hello_world.fxml")
public class HelloWorldController {

    @FXML
    private Label lblMessage;

    @FXML
    private TextField txtName;

    @Autowired
    private Greeter greeter;

    public void updateMessage() {
        String greeting = this.greeter.greet(this.txtName.getText());
        this.lblMessage.setText(greeting);
    }
}
