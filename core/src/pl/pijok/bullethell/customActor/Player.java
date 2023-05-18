package pl.pijok.bullethell.customActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import pl.pijok.bullethell.BulletHell;
import pl.pijok.bullethell.Controllers;

public class Player extends CustomActor {

    private float speed = 500f;
    private float rotationSpeed = 500f;
    public Player(Texture texture) {
        super(texture);
    }

    @Override
    public void act(float delta) {

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            moveBy(0, speed * delta);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            moveBy(0, -(speed * delta));
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveBy(-(speed * delta), 0);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveBy(speed * delta, 0);
        }

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            BulletHell.bullets.add(new Bullet(Controllers.getTexturesManager().getTexture("bullet"), getRotation(), 50, getX() + 16 - 4, getY() + 16 - 4));
        }

        float xInput = Gdx.input.getX();
        float yInput = (Gdx.graphics.getHeight() - Gdx.input.getY());

        float angle = MathUtils.radiansToDegrees * MathUtils.atan2(yInput - getY(), xInput - getX());

        if(angle < 0){
            angle += 360;
        }

        setRotation(angle);
    }

}
