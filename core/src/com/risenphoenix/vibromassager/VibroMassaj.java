package com.risenphoenix.vibromassager;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.risenphoenix.vibromassager.AssetsLoader;
import com.risenphoenix.vibromassager.ButtonThree;
import com.risenphoenix.vibromassager.InputHeandler;



public class VibroMassaj extends ApplicationAdapter {
	private SpriteBatch batch;
	private AssetsLoader load;
	private Viewport viewport;
	private Camera camera;
	private OrthographicCamera cam;
	private float mashtab_x,mashtab_y;
	private ButtonThree but;
	private float f_x,f_y,f_xS,f_yS,f_xR,f_yR,width,height,widthS,heightS,widthF;
	private float f_xF,f_yF;
	private ShapeRenderer shapeRenderer;


	public boolean onVibro(){
		if(but!=null)
			return but.getVibroStatus();
		else
			return false;
	}

	public int getInd(){
		return but.getInd();
	}

	@Override
	public void create () {
		batch = new SpriteBatch();


		mashtab_x = (float)Gdx.graphics.getWidth()/1200.0f;
		mashtab_y = (float)Gdx.graphics.getHeight()/1550.0f;
		float picSm = 37.79f;

		f_xS = 15.0f*picSm*mashtab_x;
		//f_yS = 24.84f*picSm*mashtab_y;
		//f_yS = Gdx.graphics.getHeight()-119-24.84f*picSm*mashtab_y;

		f_x = 15.0f*picSm*mashtab_x;
		//f_y = 27.56f*picSm*mashtab_y;
		//f_y = Gdx.graphics.getHeight()-75-27.56f*picSm*mashtab_y;



		//f_yF = Gdx.graphics.getHeight()-75-869.0f*mashtab_y;

		//f_xR = 18.29f*picSm*mashtab_x;
		//f_yR = Gdx.graphics.getHeight()-63-16.29f*picSm*mashtab_y;

		widthS = 1.98f*picSm*mashtab_x;
		heightS = 2.57f*picSm*mashtab_y;
		width = 1.98f*picSm*mashtab_x;
		height = 1.61f*picSm*mashtab_y;

		widthF = 2*widthS/3;
		f_xF = 571.0f*mashtab_x+widthF/6;
		f_yS = Gdx.graphics.getHeight()-heightS-24.84f*picSm*mashtab_y;
		f_y = Gdx.graphics.getHeight()-height-27.56f*picSm*mashtab_y;
		f_yF = Gdx.graphics.getHeight()-widthF/6-869.0f*mashtab_y;
		load = new AssetsLoader(widthF);

		System.out.println("fx "+f_x);
		System.out.println("fy "+f_y);
		System.out.println("fxS "+f_xS);
		System.out.println("fyS "+f_yS);
		System.out.println("width "+width);
		System.out.println("height "+height);
		System.out.println("widthS "+widthS);
		System.out.println("heightS "+heightS);
		but = new ButtonThree(f_x,f_y,f_xS,f_yS,width,height,widthS,heightS);

		Gdx.input.setInputProcessor(new InputHeandler(but));
		//camera = new PerspectiveCamera();
		//viewport = new StretchViewport(1920, 1080, camera);
		cam = new OrthographicCamera();
		cam.setToOrtho(true,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		//img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(load.fon, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		int statusVkl = but.getStatusVkl();
		if(statusVkl==0){
			//batch.draw(load.butVkl,f_x,f_y,width,height);
		}else if(statusVkl==1){
			batch.draw(load.butVkl,f_x,f_y,width,height);
		}

		int statusStrelka = but.getStatusStrelka();
		if(statusStrelka==0){
			//batch.draw(load.butVverh,f_xS,f_yS,widthS,heightS);
		}else if(statusStrelka==1){
			batch.draw(load.butVniz,f_xS,f_yS,widthS,heightS);
		}else if(statusStrelka==2){
			batch.draw(load.butVverh,f_xS,f_yS,widthS,heightS);
		}
		if(but.getInd()<10) {
			load.font.setColor(new Color(255.0f,255.0f,255.0f,255.0f));
			load.font.draw(batch, "0" + but.getInd(),f_xF,f_yF);
		}else{
			load.font.draw(batch, "" + but.getInd(),f_xF,f_yF);
		}
		batch.end();

	}

	@Override
	public void dispose () {
		batch.dispose();
		load.dispose();
		shapeRenderer.dispose();
		//img.dispose();
	}
	//@Override
	//public void resize(int width, int height) {
	//	viewport.update(width, height);
	//}
}
