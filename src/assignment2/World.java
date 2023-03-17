package assignment2;

public class World {
    private Caterpillar caterpillar;
    private Position foodPos;
    private Region map;
    private ActionQueue actionList;
    private TargetQueue foodList;
    private GameState gameState;

    public World (TargetQueue food, ActionQueue action) {
        this.actionList = action;
        this.foodList = food;
        this.map = new Region(0,0,15,15);
        this.caterpillar = new Caterpillar();
        this.foodPos = this.foodList.dequeue();
        this.gameState = GameState.MOVE;
    }

    public void step() {
        Direction direction;
        Position head = new Position(caterpillar.getHead());
        if (actionList.isEmpty()) {
            this.gameState = GameState.NO_MORE_ACTION;
            return;
        } else {
            direction = actionList.dequeue();
        }
        if (this.gameState != GameState.MOVE && this.gameState != GameState.EAT) {
            return;
        }
        if (direction.equals(Direction.EAST)) {
            head.moveEast();
        } else if (direction.equals(Direction.WEST)) {
            head.moveWest();
        } else if (direction.equals(Direction.SOUTH)) {
            head.moveSouth();
        } else if (direction.equals(Direction.NORTH)) {
            head.moveNorth();
        }
        if (!(map.contains(head))) {
            this.gameState = GameState.WALL_COLLISION;
            return;
        }
        if (this.caterpillar.selfCollision(head)) {
            this.gameState = GameState.SELF_COLLISION;

        }else if (head.equals(foodPos)) {
            if (this.foodList.isEmpty()) {
                this.gameState = GameState.DONE;
            } else {
                this.foodPos = foodList.dequeue();
                this.gameState = GameState.EAT;
                this.caterpillar.eat(head);
            }
        }else {
            this.caterpillar.move(head);             //unsure about this line
            this.gameState = GameState.MOVE;
        }
    }
    public GameState getState() {
        return this.gameState;
    }
    public Caterpillar getCaterpillar() {
        return this.caterpillar;
    }
    public Position getFood() {
        return this.foodPos;
    }
    public boolean isRunning() {
        if (this.gameState == GameState.MOVE || this.gameState == GameState.EAT) {
            return true;
        }
        return false;
    }
}
