package com.risenphoenix.vibromassager;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.risenphoenix.vibromassager.VibroMassaj;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 700;
		config.height = 850;
		new LwjglApplication(new VibroMassaj(), config);
	}
}
