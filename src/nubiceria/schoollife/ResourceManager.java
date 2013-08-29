package nubiceria.schoollife;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;

public class ResourceManager {
	private static final ResourceManager INSTANCE = new ResourceManager();

	public Engine engine;
	public BaseGameActivity activity;
	public Camera camera;
	public VertexBufferObjectManager vbom;

	// ---------------------------------------------
	// TEXTURES & TEXTURE REGIONS
	// ---------------------------------------------
	// Splash Screen
	public ITextureRegion splash_region;
	private BitmapTextureAtlas splashTextureAtlas;

	// ---------------------------------------------
	// CLASS LOGIC
	// ---------------------------------------------
	public static void prepareManager(Engine engine, BaseGameActivity activity,
			Camera camera, VertexBufferObjectManager vbom) {
		getInstance().engine = engine;
		getInstance().activity = activity;
		getInstance().camera = camera;
		getInstance().vbom = vbom;
	}

	public void loadSplashScreen() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		splashTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 480, 320, TextureOptions.BILINEAR);
		splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				splashTextureAtlas, activity, "SplashScreen.png", 0, 0);
		splashTextureAtlas.load();
	}

	public void unloadSplashScreen() {
		splashTextureAtlas.unload();
		splash_region = null;
	}

	// ---------------------------------------------
	// GETTER SETTER
	// ---------------------------------------------
	/**
	 * @return the instance
	 */
	public static ResourceManager getInstance() {
		return INSTANCE;
	}
}
