package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int nextX = getX();
        int nextY = getY();

        switch (direction) {
            case LEFT:
                nextX -= Model.FIELD_CELL_SIZE;
                break;
            case RIGHT:
                nextX += Model.FIELD_CELL_SIZE;
                break;
            case UP:
                nextY -= Model.FIELD_CELL_SIZE;
                break;
            case DOWN:
                nextY += Model.FIELD_CELL_SIZE;
                break;
        }

        return nextX == gameObject.getX() && nextY == gameObject.getY();
    }
}
