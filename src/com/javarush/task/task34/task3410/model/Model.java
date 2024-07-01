package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.File;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(new File("res/levels.txt").toPath());


    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        currentLevel = level;
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) {
            return; // Exit method if there's a wall collision
        }

        if (checkBoxCollisionAndMoveIfAvailable(direction)) {
            return; // Exit method if there's a box collision
        }

        int dx = 0, dy = 0;
        switch (direction) {
            case LEFT:
                dx = -FIELD_CELL_SIZE;
                break;
            case RIGHT:
                dx = FIELD_CELL_SIZE;
                break;
            case UP:
                dy = -FIELD_CELL_SIZE;
                break;
            case DOWN:
                dy = FIELD_CELL_SIZE;
                break;
        }

        player.move(dx, dy); // Move the player

        checkCompletion(); // Check if the level is completed after moving
    }


    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        for (Box box : gameObjects.getBoxes()) {
            if (gameObjects.getPlayer().isCollision(box, direction)) {
                for (Box item : gameObjects.getBoxes()) {
                    if (!box.equals(item)) {
                        if (box.isCollision(item, direction)) {
                            return true;
                        }
                    }
                    if (checkWallCollision(box, direction)) {
                        return true;
                    }
                }
                int dx = direction == Direction.LEFT ? -FIELD_CELL_SIZE : (direction == Direction.RIGHT ? FIELD_CELL_SIZE : 0);
                int dy = direction == Direction.UP ? -FIELD_CELL_SIZE : (direction == Direction.DOWN ? FIELD_CELL_SIZE : 0);
                box.move(dx, dy);
            }
        }
        return false;
    }

    public void checkCompletion() {
        boolean allBoxesOnHomes = true;
        for (Home home : gameObjects.getHomes()) {
            boolean boxOnHome = false;
            for (Box box : gameObjects.getBoxes()) {
                if (box.getX() == home.getX() && box.getY() == home.getY()) {
                    boxOnHome = true;
                    break;
                }
            }
            if (!boxOnHome) {
                allBoxesOnHomes = false;
                break;
            }
        }
        if (allBoxesOnHomes) {
            eventListener.levelCompleted(currentLevel);
        }
    }



}
