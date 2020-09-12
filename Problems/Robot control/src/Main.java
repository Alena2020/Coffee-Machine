class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        switch (robot.getDirection()) {
            case UP:
                if (robot.getY() > toY) {
                    robot.turnRight();
                    robot.turnRight();
                }
                break;
            case DOWN:
                if (robot.getY() < toY) {
                    robot.turnRight();
                    robot.turnRight();
                }
                break;
            case LEFT:
                if (robot.getY() < toY) {
                    robot.turnRight();
                } else if (robot.getY() > toY) {
                    robot.turnLeft();
                }
                break;
            case RIGHT:
                if (robot.getY() < toY) {
                    robot.turnLeft();
                } else if (robot.getY() > toY) {
                    robot.turnRight();
                }
        }

        int diffY = robot.getY() - toY;
        for (int i = 0; i < (diffY >= 0 ? diffY : diffY * -1); i++) {
            robot.stepForward();
        }

        switch (robot.getDirection()) {
            case UP:
                if (robot.getX() > toX) {
                    robot.turnLeft();
                } else if (robot.getX() < toX) {
                    robot.turnRight();
                }
                break;
            case DOWN:
                if (robot.getX() > toX) {
                    robot.turnRight();
                } else if (robot.getX() < toX) {
                    robot.turnLeft();
                }
                break;
            case LEFT:
                if (robot.getX() < toX) {
                    robot.turnRight();
                    robot.turnRight();
                }
                break;
            case RIGHT:
                if (robot.getX() > toX) {
                    robot.turnRight();
                    robot.turnRight();
                }
        }

        int diffX = robot.getX() - toX;
        for (int i = 0; i < (diffX >= 0 ? diffX : diffX * -1); i++) {
            robot.stepForward();
        }
    }
    }
    //Don't change code below

    enum Direction {
        UP(0, 1),
        DOWN(0, -1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public Direction turnLeft() {
            switch (this) {
                case UP:
                    return LEFT;
                case DOWN:
                    return RIGHT;
                case LEFT:
                    return DOWN;
                case RIGHT:
                    return UP;
                default:
                    throw new IllegalStateException();
            }
        }

        public Direction turnRight() {
            switch (this) {
                case UP:
                    return RIGHT;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
                case RIGHT:
                    return DOWN;
                default:
                    throw new IllegalStateException();
            }
        }

        public int dx() {
            return dx;
        }

        public int dy() {
            return dy;
        }
    }

    class Robot {
        private int x;
        private int y;
        private Direction direction;

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void turnLeft() {
            direction = direction.turnLeft();
        }

        public void turnRight() {
            direction = direction.turnRight();
        }

        public void stepForward() {
            x += direction.dx();
            y += direction.dy();
        }

        public Direction getDirection() {
            return direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }



