package at.openpatientdoc.frontend.controller;

import javafx.fxml.Initializable;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author fs-green
 * @date 02.03.20
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
@FxmlView("about.fxml")
public class AboutController implements Initializable {

    @Autowired
    private Logger logger;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.logger.info("in AboutController");
    }
}
