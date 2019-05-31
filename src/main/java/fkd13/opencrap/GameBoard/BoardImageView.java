package fkd13.opencrap.GameBoard;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import fkd13.opencrap.Menu.Manager;
import fkd13.opencrap.Menu.SelectableImageView;

import java.lang.annotation.Target;

public class BoardImageView extends ImageView {

    private int x;
    private int y;

    private Manager manager;
    private Direction dir1;
    private Direction dir2;

    public BoardImageView(Manager manager, int x, int y) {
        this.manager = manager;
        setImage(new Image(getClass().getResource("/Images/dirt.png").toString()));
        setFitHeight(32);
        setFitWidth(32);
        this.x = x;
        this.y = y;
        setOnMouseClicked(this::handle);
    }

    private void handle(MouseEvent event) {
        SelectableImageView selectableImageView = manager.getSelectedImageView();
        if (selectableImageView != null) {
            setImage(selectableImageView.getImage());
            setRotate(selectableImageView.getRotate());
            dir1 = selectableImageView.getDir1();
            dir2 = selectableImageView.getDir2();
        }
    }

    public Direction getDir1() {
        return dir1;
    }

    public Direction getDir2() {
        return dir2;
    }
}
