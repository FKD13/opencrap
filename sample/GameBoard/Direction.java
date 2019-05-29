package sample.GameBoard;

public enum Direction {

    NORTH {
        @Override
        public Direction getOposite() {
            return Direction.SOUTH;
        }

        @Override
        public int getNewX(int x) {
            return x - 1;
        }

        @Override
        public int getNewY(int y) {
            return y;
        }
    },

    EAST {
        @Override
        public Direction getOposite() {
            return Direction.WEST;
        }

        @Override
        public int getNewX(int x) {
            return x;
        }

        @Override
        public int getNewY(int y) {
            return y + 1;
        }
    },

    SOUTH {
        @Override
        public Direction getOposite() {
            return Direction.NORTH;
        }

        @Override
        public int getNewX(int x) {
            return x + 1;
        }

        @Override
        public int getNewY(int y) {
            return y;
        }
    },

    WEST {
        @Override
        public Direction getOposite() {
            return Direction.EAST;
        }

        @Override
        public int getNewX(int x) {
            return x;
        }

        @Override
        public int getNewY(int y) {
            return y - 1;
        }
    };

    public abstract Direction getOposite();

    public abstract int getNewX(int x);
    public abstract int getNewY(int y);
}
