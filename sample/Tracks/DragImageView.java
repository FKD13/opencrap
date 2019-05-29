package sample.Tracks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class DragImageView extends ImageView {

    public DragImageView(double rotation) {
        super();
        setFitHeight(32);
        setFitWidth(32);
        setImage(new Image(getClass().getResource("/Images/rail.png").toString()));
        setRotate(rotation);
        setOnDragDetected(this::handle);
    }

    public void handle(MouseEvent event) {
        System.out.println("here!");
        Dragboard db = this.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString("" + getRotate());
        db.setContent(clipboardContent);
        System.out.println("consume");
        event.consume();
    }
}
