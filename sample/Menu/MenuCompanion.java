package sample.Menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.Tracks.TracksCompanion;

import java.io.IOException;

public class MenuCompanion {

    public Button trackBtn;
    public Button stationBtn;
    public Button trainBtn;
    public Button bombBtn;
    public Button depotBtn;

    private Stage trackStage;
    private Manager manager;

    public MenuCompanion(Manager manager) {
        this.manager = manager;
    }

    public void initialize() {
        trackBtn.setOnAction(e -> openTrackWindow());
        bombBtn.setOnAction(e -> manager.setSelectedImageView(new SelectableImageView(new Image(getClass().getResource("/Images/dirt.png").toString()), 0, manager, null, null)));
    }

    private void openTrackWindow() {
        if (trackStage == null) {
            try {
                trackStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Tracks.fxml"));
                loader.setController(new TracksCompanion(manager));
                Scene scene = new Scene(loader.load());
                trackStage.setScene(scene);
                trackStage.setTitle("Tracks");
                trackStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
