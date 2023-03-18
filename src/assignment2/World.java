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
        Position headPos = new Position(caterpillar.getHead());
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
            headPos.moveEast();
        } else if (direction.equals(Direction.WEST)) {
            headPos.moveWest();
        } else if (direction.equals(Direction.SOUTH)) {
            headPos.moveSouth();
        } else if (direction.equals(Direction.NORTH)) {
            headPos.moveNorth();
        }
        if (!(map.contains(headPos))) {
            this.gameState = GameState.WALL_COLLISION;
            return;
        }
        if (this.caterpillar.selfCollision(headPos)) {
            this.gameState = GameState.SELF_COLLISION;

        }else if (headPos.equals(foodPos)) {
            if (this.foodList.isEmpty()) {
                this.caterpillar.eat(foodPos);
                this.gameState = GameState.DONE;
            } else {
                this.foodPos = foodList.dequeue();
                this.gameState = GameState.EAT;
                this.caterpillar.eat(headPos);
            }
        }else {
            this.caterpillar.move(headPos);             //unsure about this line
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
