package fkd13.opencrap.Tracks;

import javafx.scene.image.Image;
import fkd13.opencrap.GameBoard.Direction;
import fkd13.opencrap.Menu.Manager;
import fkd13.opencrap.Menu.SelectableImageView;
import javafx.scene.layout.VBox;

public class TracksCompanion {

    public VBox vbox;

    private Manager manager;

    public TracksCompanion(Manager manager) {
        this.manager = manager;
    }

    @SuppressWarnings("unused")
    public void initialize() {
        Image rails = new Image(getClass().getResource("/Images/rail.png").toString());

        vbox.getChildren().add(new SelectableImageView(rails, 0, manager, Direction.NORTH, Direction.SOUTH));
        vbox.getChildren().add(new SelectableImageView(rails, 90, manager, Direction.EAST, Direction.WEST));
        Image turn = new Image(getClass().getResource("/Images/rail_corner.png").toString());
        vbox.getChildren().add(new SelectableImageView(turn, 0, manager, Direction.EAST, Direction.SOUTH));
        vbox.getChildren().add(new SelectableImageView(turn, 90, manager, Direction.SOUTH, Direction.WEST));
        vbox.getChildren().add(new SelectableImageView(turn, 180, manager, Direction.WEST, Direction.NORTH));
        vbox.getChildren().add(new SelectableImageView(turn, 270, manager, Direction.NORTH, Direction.EAST));
        Image station = new Image(getClass().getResource("/Images/powered_rail.png").toString());
        vbox.getChildren().add(new SelectableImageView(station, 0, manager, Direction.NORTH, Direction.SOUTH));
        vbox.getChildren().add(new SelectableImageView(station, 90, manager, Direction.EAST, Direction.WEST));
    }
}
