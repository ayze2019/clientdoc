package at.clientdoc.frontend.application;

import at.clientdoc.frontend.FxWeaverSpringBootStarterSampleApplication;
import clientdoc.exception.ClientdocBusinessException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.*;

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
public class SpringbootJavaFxApplication extends Application {

    public static final String H2_VERSION = "h2-1.4.199.jar";
    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        // initialize spring context
        this.context = new SpringApplicationBuilder()
                .sources(FxWeaverSpringBootStarterSampleApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));

        // initialize H2 database
//        initH2();
    }

    @Override
    public void start(Stage primaryStage) {
        Thread.setDefaultUncaughtExceptionHandler(SpringbootJavaFxApplication::showError);
        this.context.publishEvent(new StageReadyEvent(primaryStage));
    }

    @Override
    public void stop() {
        this.context.close();
        Platform.exit();
    }

    private static void showError(Thread t, Throwable e) {
        System.err.println("***Default exception handler***");
        if (Platform.isFxApplicationThread()) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText(ExceptionUtils.getRootCause(e).getMessage());

            alert.showAndWait();
        } else {
            e.printStackTrace();
        }
    }

    private void initH2() {
        String stringToJarFile = System.getProperty("user.home") + File.separator + H2_VERSION;
        File file = FileUtils.getFile(stringToJarFile);

        if (!file.exists()) {
            copyH2JarFileToUserHome(stringToJarFile);
        }

        ProcessBuilder pb = new ProcessBuilder("java", "-jar", stringToJarFile);
        try {
            Process p = pb.start();
        } catch (IOException e) {
            throw new ClientdocBusinessException(e);
        }
    }

    private void copyH2JarFileToUserHome(String stringToJarFile) {
        int readBytes;
        byte[] buffer = new byte[4096];
        InputStream stream = this.getClass().getResourceAsStream("/" + H2_VERSION);
        OutputStream readStream;
        try {
            readStream = new FileOutputStream(stringToJarFile);
            while ((readBytes = stream.read(buffer)) > 0) {
                readStream.write(buffer, 0, readBytes);
            }
        } catch (IOException e) {
            throw new ClientdocBusinessException(e);
        }
    }
}
