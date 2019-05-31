package fkd13.opencrap.GameBoard;

import javafx.scene.image.Image;

public class Train {

    private int x;
    private int y;
    private Controller controller;

    //private int nextX;
    //private int nextY;

    private Direction nextTile;
    private Image currentImage;
    private Image train = new Image(getClass().getResource("/Images/coal_ore.png").toString());

    public Train(int x, int y, Controller controller) {
        this.x = x;
        this.y = y;
        this.controller = controller;
    }

    public boolean findFirstMove() {
        BoardImageView boardImageView = ((BoardImageView) controller.gridpane.getChildren().get(y + x * 20));
        if (boardImageView.getDir1() != null && boardImageView.getDir2() != null) {
            nextTile = boardImageView.getDir1();
            currentImage = boardImageView.getImage();
            boardImageView.setImage(train);
            return true;
        }
        return false;
    }

    public void move() {
        BoardImageView boardImageView = (BoardImageView) controller.gridpane.getChildren().get(nextTile.getNewY(y) + nextTile.getNewX(x) * 20);
        if (boardImageView.getDir1() == nextTile.getOposite()) {
            ((BoardImageView) controller.gridpane.getChildren().get(x * 20 + y)).setImage(currentImage);
            this.x = nextTile.getNewX(x);
            this.y = nextTile.getNewY(y);
            this.nextTile = boardImageView.getDir2();
            currentImage = boardImageView.getImage();
            boardImageView.setImage(train);
        } else if (boardImageView.getDir2() == nextTile.getOposite()) {
            ((BoardImageView) controller.gridpane.getChildren().get(x * 20 + y)).setImage(currentImage);
            this.x = nextTile.getNewX(x);
            this.y = nextTile.getNewY(y);
            this.nextTile = boardImageView.getDir1();
            currentImage = boardImageView.getImage();
            boardImageView.setImage(train);
        } else {
            boardImageView = (BoardImageView) controller.gridpane.getChildren().get(y + x * 20);
            if (boardImageView.getDir2() != nextTile) {
                nextTile = boardImageView.getDir2();
            } else {
                nextTile = boardImageView.getDir1();
            }
        }
    }
}
