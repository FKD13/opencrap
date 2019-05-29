package sample.Menu;

import javafx.scene.image.ImageView;

public class Manager {

    private SelectableImageView selectedImageView;

    public SelectableImageView getSelectedImageView() {
        return selectedImageView;
    }

    public void setSelectedImageView(SelectableImageView selectedImageView) {
        this.selectedImageView = selectedImageView;
    }
}
