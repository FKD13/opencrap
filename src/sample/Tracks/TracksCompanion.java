package sample.Tracks;

import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.HBox;
import sample.GameBoard.Direction;
import sample.Menu.Manager;
import sample.Menu.SelectableImageView;

import java.util.List;

public class TracksCompanion {

    public HBox hbox;

    private Manager manager;

    public TracksCompanion(Manager manager) {
        this.manager = manager;
    }

    public void initialize() {
        Image rails = new Image(getClass().getResource("/Images/rail.png").toString());

        hbox.getChildren().add(new SelectableImageView(rails, 0, manager, Direction.NORTH, Direction.SOUTH));
        hbox.getChildren().add(new SelectableImageView(rails, 90, manager, Direction.EAST, Direction.WEST));
        Image turn = new Image(getClass().getResource("/Images/rail_corner.png").toString());
        hbox.getChildren().add(new SelectableImageView(turn, 0, manager, Direction.EAST, Direction.SOUTH));
        hbox.getChildren().add(new SelectableImageView(turn, 90, manager, Direction.SOUTH, Direction.WEST));
        hbox.getChildren().add(new SelectableImageView(turn, 180, manager, Direction.WEST, Direction.NORTH));
        hbox.getChildren().add(new SelectableImageView(turn, 270, manager, Direction.NORTH, Direction.EAST));
        Image station = new Image(getClass().getResource("/Images/powered_rail.png").toString());
        hbox.getChildren().add(new SelectableImageView(station, 0, manager, Direction.NORTH, Direction.SOUTH));
        hbox.getChildren().add(new SelectableImageView(station, 90, manager, Direction.EAST, Direction.WEST));
    }
}
