package com.kpzip.fourier.renderer;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import com.kpzip.fourier.util.Logger;
import com.kpzip.fourier.util.LoggerType;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.*;

// Class to create the window / render it in GLFW
public class Window {
	private int          width, height;
	private int          frames;
	private static long time;
	private long         window;
	private String       title;
	private Thread       app;
	public  Input        input;
	
	
	public Window(int width, int height, String title) {
		this.width  = width;
		this.height = height;
		this.title  = title;
	}

	public void run() {
		create();
		while (!shouldClose()) {
			update();
			render();
			if(input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) {
				return;
			}
		}
		destroy();
	}
	
	public void destroy() {
		input.destroy();
		glfwWindowShouldClose(window);
		glfwDestroyWindow(window);
		glfwTerminate();
	}

	private void create() {
		if (!glfwInit()) {
			Logger.log(LoggerType.ERROR, "GLFW was unable to initialize!");
			return;
		}
		
		input = new Input();

		window = glfwCreateWindow(width, height, title, 0, 0);

		if (window == 0) {
			Logger.log(LoggerType.ERROR, "Unable to create Window");
			return;
		}
		
		Logger.log(LoggerType.INFO, "Window was created!");

		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);
		glfwMakeContextCurrent(window);
		
		glfwSetKeyCallback(window, input.getKeyboardCallback());
		glfwSetCursorPosCallback(window, input.getMouseMovementCallback());
		glfwSetMouseButtonCallback(window, input.getMouseButtonsCallback());
		
		glfwShowWindow(window);
		
		// lock frames to refresh rate (hZ)
		glfwSwapInterval(1);
		
		time = System.currentTimeMillis();
	}

	private void update() {
		glfwPollEvents();
		
		// fps counter
		frames++;
		if (System.currentTimeMillis() > time + 1000) {
			glfwSetWindowTitle(window, title + " - FPS: " + frames);
			time   = System.currentTimeMillis();
			frames = 0;
		}
	}

	private void swapBuffers() {
		glfwSwapBuffers(window);
	}

	private void render() {
		swapBuffers();
	}

	private boolean shouldClose() {
		return glfwWindowShouldClose(window);
	}
}
