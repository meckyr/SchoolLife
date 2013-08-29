package nubiceria.schoollife;

import nubiceria.schoollife.SceneManager.SceneType;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;

public class SplashScene extends BaseScene {
	private Sprite splash;

	@Override
	public void createScene() {
		setBackground(new Background(Color.CYAN));
		splash = new Sprite(0, 0, resourceManager.splash_region, vbom);
		attachChild(splash);
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_SPLASH;
	}

	@Override
	public void disposeScene() {
		splash.detachSelf();
		splash.dispose();
		this.detachSelf();
		this.dispose();
	}
}
