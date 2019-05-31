package fkd13.opencrap.Menu;

import fkd13.opencrap.GameBoard.Direction;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SelectableImageView extends ImageView {

    private Manager manager;
    private Direction dir1;
    private Direction dir2;

    public SelectableImageView(Image image, double rotation, Manager manager, Direction dir1, Direction dir2) {
        setFitHeight(48);
        setFitWidth(48);

        setImage(image);
        setRotate(rotation);
        setOnMouseClicked(this::handle);
        this.manager = manager;
        this.dir1 = dir1;
        this.dir2 = dir2;
    }

    private void handle(MouseEvent event) {
        manager.setSelectedImageView(this);
    }

    public Direction getDir1() {
        return dir1;
    }

    public Direction getDir2() {
        return dir2;
    }
}
