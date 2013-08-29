package nubiceria.schoollife;

import nubiceria.schoollife.scenes.BaseScene;
import nubiceria.schoollife.scenes.SplashScene;

import org.andengine.engine.Engine;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

public class SceneManager {
	private BaseScene splashScene;

	private static final SceneManager INSTANCE = new SceneManager();

	private SceneType currentSceneType = SceneType.SCENE_SPLASH;

	private BaseScene currentScene;

	private Engine engine = ResourceManager.getInstance().engine;

	public enum SceneType {
		SCENE_SPLASH, SCENE_MENU, SCENE_LOADING, SCENE_MAINGAME,
	}

	// ---------------------------------------------
	// CLASS LOGIC
	// ---------------------------------------------
	public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback) {
		ResourceManager.getInstance().loadSplashScreen();
		splashScene = new SplashScene();
		splashScene.createScene();
		currentScene = splashScene;
		currentSceneType = splashScene.getSceneType();
		pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
	}

	public void disposeSplashScene() {
		ResourceManager.getInstance().unloadSplashScreen();
		splashScene.disposeScene();
		splashScene = null;
	}

	// ---------------------------------------------
	// GETTER SETTER
	// ---------------------------------------------
	public void setScene(BaseScene scene) {
		currentScene = scene;
		currentSceneType = scene.getSceneType();
		engine.setScene(currentScene);
	}

	public void setScene(SceneType sceneType) {

	}

	/**
	 * @return the currentSceneType
	 */
	public SceneType getCurrentSceneType() {
		return currentSceneType;
	}

	/**
	 * @return the currentScene
	 */
	public BaseScene getCurrentScene() {
		return currentScene;
	}

	/**
	 * @return the instance
	 */
	public static SceneManager getInstance() {
		return INSTANCE;
	}
}
