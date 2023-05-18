package pl.pijok.bullethell;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.ScreenUtils;
import pl.pijok.bullethell.customActor.Bullet;
import pl.pijok.bullethell.customActor.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BulletHell extends ApplicationAdapter {

	public static List<Bullet> bullets = new ArrayList<>();
	SpriteBatch batch;
	Texture img;

	Player player;
	
	@Override
	public void create () {
		Controllers.getTexturesManager().load();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		player = new Player(Controllers.getTexturesManager().getTexture("player_alpha"));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		//batch.draw(img, 0, 0);
		player.draw(batch);
		bullets.forEach(e -> {
			e.draw(batch);
		});
		batch.end();

		player.act(Gdx.graphics.getDeltaTime());
		bullets.forEach(e -> e.act(Gdx.graphics.getDeltaTime()));
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
