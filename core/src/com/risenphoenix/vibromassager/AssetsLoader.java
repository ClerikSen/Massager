package com.risenphoenix.vibromassager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Fentom on 07.05.2017.
 */

public class AssetsLoader {

    public Texture fon;
    public Texture butVverh;
    public Texture butVniz;
    //public Texture butRightOt;
    //public Texture butRight;
    //public Texture butVklot;
    public Texture butVkl;
    public BitmapFont font;


    public AssetsLoader(float width){
        fon = new Texture(Gdx.files.internal("data/fon.png"));
        fon.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        butVkl = new Texture(Gdx.files.internal("data/butVkl.png"));
        butVkl.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        butVverh = new Texture(Gdx.files.internal("data/butPlus.png"));
        butVverh.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        butVniz = new Texture(Gdx.files.internal("data/butMinimum.png"));
        butVniz.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("1.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();

        param.size = Math.round(width)*4;//Gdx.graphics.getHeight() / 12;

        //param.characters = FONT_CHARACTERS;
        font = generator.generateFont(param);

        font.getData().setScale(.25f,.25f);
        //font.getData().setScale(.25f,-.25f);
        //param.size = Gdx.graphics.getHeight() / 20;
        //levels = generator.generateFont(param);
        font.setColor(Color.BLACK);
        //levels.setColor(Color.BLACK);
        generator.dispose();


    }

    public void dispose(){
        fon.dispose();
        butVverh.dispose();
        butVniz.dispose();
        butVkl.dispose();
        font.dispose();
    }

}
