package pl.pijok.bullethell.customActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player extends CustomActor {

    private float speed = 500f;
    private float rotationSpeed = 500f;
    public Player(Texture texture) {
        super(texture);
    }

    public void act(float delta) {

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            moveBy(0, speed * delta);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            moveBy(0, -(speed * delta));
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            System.out.println("AAA");
            moveBy(-(speed * delta), 0);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveBy(speed * delta, 0);
        }

        float radians = (float) Math.atan2(Gdx.input.getX() - getX(), Gdx.input.getY() - getY());
        System.out.println("Radians: " + radians);
        float degrees = (float) Math.toDegrees(radians);
        System.out.println("Degrees" + degrees);
        setRotation(degrees);

    }
}
