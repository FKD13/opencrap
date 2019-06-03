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
        int columns = controller.gridpane.getColumnCount();
        BoardImageView boardImageView = ((BoardImageView) controller.gridpane.getChildren().get(y*columns + x));
        System.out.println(boardImageView);
        System.out.println(boardImageView.getDir1());
        System.out.println(boardImageView.getDir2());
        if (boardImageView.getDir1() != null && boardImageView.getDir2() != null) {
            nextTile = boardImageView.getDir1();
            currentImage = boardImageView.getImage();
            boardImageView.setImage(train);
            return true;
        }
        return false;
    }

    public void move() {
        int columns = controller.gridpane.getColumnCount();
        System.out.println(String.format("  : y=%d - x=%d", nextTile.getNewY(y), nextTile.getNewX(x)));

        BoardImageView boardImageView = (BoardImageView) controller.gridpane.getChildren().get((nextTile.getNewY(y) * columns) + nextTile.getNewX(x));
        if (boardImageView.getDir1() == nextTile.getOposite()) {
            ((BoardImageView) controller.gridpane.getChildren().get(y*columns + x)).setImage(currentImage);
            this.x = nextTile.getNewX(x);
            this.y = nextTile.getNewY(y);
            this.nextTile = boardImageView.getDir2();
            currentImage = boardImageView.getImage();
            boardImageView.setImage(train);
        } else if (boardImageView.getDir2() == nextTile.getOposite()) {
            ((BoardImageView) controller.gridpane.getChildren().get(y * columns + x)).setImage(currentImage);
            this.x = nextTile.getNewX(x);
            this.y = nextTile.getNewY(y);
            this.nextTile = boardImageView.getDir1();
            currentImage = boardImageView.getImage();
            boardImageView.setImage(train);
        } else {
            boardImageView = (BoardImageView) controller.gridpane.getChildren().get(y * columns + x);
            if (boardImageView.getDir2() != nextTile) {
                nextTile = boardImageView.getDir2();
            } else {
                nextTile = boardImageView.getDir1();
            }
        }
    }
}
