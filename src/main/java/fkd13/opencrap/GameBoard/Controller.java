package fkd13.opencrap.GameBoard;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import fkd13.opencrap.Menu.Manager;

public class Controller {

    public GridPane gridpane;
    public Button move;

    private Manager manager;
    private boolean initialized = false;
    private Train train;

    public Controller(Manager manager) {
        this.manager = manager;
    }

    public void initialize() {
        for (int i = 0; i < 20; i++) {
            gridpane.addRow(i);
            gridpane.addColumn(i);
        }

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                gridpane.add(new BoardImageView(manager, x, y), y, x);
            }
        }
        move.setDefaultButton(true);
        move.setOnAction(e -> move());
        train = new Train(2, 2, this);
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
}
