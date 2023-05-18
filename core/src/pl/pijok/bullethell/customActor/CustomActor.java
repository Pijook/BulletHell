package pl.pijok.bullethell.customActor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class CustomActor extends Sprite {

    public CustomActor(Texture texture) {
        super(texture);
    }

    public void moveBy(float x, float y) {
        System.out.println(getX());
        setPosition(getX() + x, getY() + y);
    }

}
