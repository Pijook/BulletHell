package pl.pijok.bullethell;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.ScreenUtils;
import pl.pijok.bullethell.customActor.Player;

public class BulletHell extends ApplicationAdapter {
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
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		//batch.draw(img, 0, 0);
		player.draw(batch);
		batch.end();

		player.act(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
