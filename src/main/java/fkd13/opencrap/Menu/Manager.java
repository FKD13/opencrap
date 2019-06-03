package fkd13.opencrap.Menu;

/**
 * Handles communication from menu to the gameboard
 */
public class Manager {

    private SelectableImageView selectedImageView;

    public SelectableImageView getSelectedImageView() {
        return selectedImageView;
    }

    public void setSelectedImageView(SelectableImageView selectedImageView) {
        this.selectedImageView = selectedImageView;
    }
}
