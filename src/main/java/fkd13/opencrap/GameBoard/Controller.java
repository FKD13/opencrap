package fkd13.opencrap.GameBoard;

import fkd13.opencrap.Menu.Manager;
import fkd13.opencrap.Menu.SelectableImageView;
import fkd13.opencrap.Tracks.TracksCompanion;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

import static fkd13.opencrap.GameBoard.Controller.SidePanel.Empty;
import static fkd13.opencrap.GameBoard.Controller.SidePanel.Tracks;

public class Controller {

    // Menu
    public Button trackBtn;
    public Button stationBtn;
    public Button trainBtn;
    public Button bombBtn;
    public Button depotBtn;

    // Center: gameboard
    public GridPane gridpane;
    public Button move;

    // Right: extra pane
    public AnchorPane rightPane;
    private SidePanel openSidePanel = Empty;

    // Other stuff
    private Manager manager;
    private boolean initialized = false;
    private Train train;

    public Controller(Manager manager) {
        this.manager = manager;
    }

    @SuppressWarnings("unused")
    public void initialize() {
        // TODO we do not support making you window smaller.
        //  I have not found out why the gridpane widthproperty does not trigger on making the screen smaller
        gridpane.widthProperty().addListener((observable, oldValue, newValue) -> {
            int newMaxCol = (int) ((double) (newValue) / 32);
            int oldMaxCol = (int) ((double) (oldValue) / 32);
            if (newMaxCol > oldMaxCol) {
                for (int col = oldMaxCol; col < newMaxCol; col++) {
                    System.out.println("Adding column: " + col);
                    for (int row = 0; row < Math.max(3, gridpane.getRowCount()); row++) {
                        gridpane.add(new BoardImageView(manager, col, row), col, row);
                    }
                }
            }
        });
        gridpane.heightProperty().addListener((observable, oldValue, newValue) -> {
            int newMaxRow = (int) ((double) (newValue) / 32);
            int oldMaxRow = (int) ((double) (oldValue) / 32);
            System.out.println("Adding rows: >" + oldMaxRow);
            if (newMaxRow > oldMaxRow) {
                for (int col = 0; col < Math.max(3, gridpane.getColumnCount()); col++) {
                    for (int row = oldMaxRow; row < newMaxRow; row++) {
                        gridpane.add(new BoardImageView(manager, col, row), col, row);
                    }
                }
            }
        });

        move.setDefaultButton(true);
        move.setOnAction(e -> move());
        train = new Train(2, 2, this);

        initMenu();
    }

    public void initMenu() {
        trackBtn.setOnAction(e -> openTrackWindow());
        bombBtn.setOnAction(e -> manager.setSelectedImageView(new SelectableImageView(new Image(getClass().getResource("/Images/dirt.png").toString()), 0, manager, null, null)));
        stationBtn.setDisable(true);
        trainBtn.setDisable(true);
        depotBtn.setDisable(true);
    }

    private void openTrackWindow() {
        if (!openSidePanel.equals(Tracks)) {
            openSidePanel = Tracks;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Tracks.fxml"));
                loader.setController(new TracksCompanion(manager));
                rightPane.getChildren().add(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void move() {
        if (!initialized) {
            initialized = train.findFirstMove();
            new Thread(() -> {
                while (true) {
                    Platform.runLater(() -> train.move());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    enum SidePanel {
        Empty,
        Tracks
    }
}
