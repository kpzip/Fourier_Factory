package com.kpzip.fourier.game;

import org.lwjgl.glfw.GLFW;

import com.kpzip.fourier.renderer.Input;

public class MainLoop {
	
	//Called every tick
	public static void runLoop() {
		if(Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) {
			return;
		}
	}

}
