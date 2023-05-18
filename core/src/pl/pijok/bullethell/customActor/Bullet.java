package pl.pijok.bullethell.customActor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Bullet extends CustomActor {

    private final float speed;
    private float angle;
    private final double moveByX;
    private final double moveByY;

    public Bullet(Texture texture, float angle, float speed, float x, float y) {
        super(texture);
        this.angle = angle;
        this.speed = speed;
        setPosition(x, y);
        setRotation(angle);

        moveByX = Math.sin(angle) * -speed;
        moveByY = Math.cos(angle) * speed;

        System.out.println(angle);
        this.angle = (float) Math.toRadians(angle);
    }

    @Override
    public void act(float delta) {
        moveForward(10);
    }

    public void moveForward(double distance) {
        double newX = getX() + distance * Math.cos(angle);
        double newY = getY() + distance * Math.sin(angle);
        setPosition((float) newX, (float) newY);
    }
}
