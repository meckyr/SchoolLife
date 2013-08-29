package nubiceria.schoollife.scenes;

import nubiceria.schoollife.ResourceManager;
import nubiceria.schoollife.SceneManager;
import nubiceria.schoollife.SceneManager.SceneType;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.app.Activity;

public abstract class BaseScene extends Scene {
	protected Engine engine;
	protected Activity activity;
	protected ResourceManager resourceManager;
	protected VertexBufferObjectManager vbom;
	protected Camera camera;
	
	public BaseScene(){
		this.resourceManager = ResourceManager.getInstance();
		this.engine = resourceManager.engine;
		this.activity = resourceManager.activity;
		this.vbom = resourceManager.vbom;
		this.camera = resourceManager.camera;
	}
	
	public abstract void createScene();
	public abstract void onBackKeyPressed();
	public abstract SceneType getSceneType();
	public abstract void disposeScene();
}