package at.openpatientdoc.frontend.application;

import at.openpatientdoc.frontend.controller.IndexController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author fs-green
 * @date 22.12.19
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
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent> {

    private static Logger logger = Logger.getLogger(SpringbootJavaFxApplication.class);

    private final FxWeaver fxWeaver;

    @Autowired
    public PrimaryStageInitializer(FxWeaver fxWeaver) {
        logger.info("initializing FxWeaver");
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        logger.info("loading correct messages.properties file");
        URL resource = classLoader.getResource("messages.properties");

        if (resource == null) {
            throw new IllegalStateException("Konnte messages.properties File nicht laden");
        }

        try {
            ResourceBundle resourceBundle = new PropertyResourceBundle(new FileInputStream(new File(resource.getFile())));
            Stage stage = event.stage;
            Scene scene = new Scene(this.fxWeaver.loadView(IndexController.class, resourceBundle), 750, 400);
            stage.setScene(scene);
            stage.setTitle("OpenPatientDoc");
            stage.show();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
