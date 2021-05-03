package com.kpzip.fourier.renderer;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.*;

// Class to create the window with LWJGL. 
public class Window {
	
	// Window handle.
	private long window;
	
	public void run() {
		System.out.println("Hello LWJGL " + Version.getVersion() + "!");

		init();
		loop();

		// Free the window callbacks and destroy the window.
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);

		// Terminate GLFW and free the error callback.
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
	
	private void init() {
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if ( !glfwInit() ) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}

		// Configure GLFW
		glfwDefaultWindowHints(); // Optional, the current window hints are already the default.
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // The window will stay hidden after creation.
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // The window will be resizable.

		// Create the window.
		window = glfwCreateWindow(300, 300, "Fourier_Factory", NULL, NULL);
		if ( window == NULL ) {
			throw new RuntimeException("Failed to create the GLFW window");
		}

		// Setup a key callback. It will be called every time a key is pressed, repeated or released.
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop.
		});

		// Get the thread stack and push a new frame.
		try ( MemoryStack stack = stackPush() ) {
			IntBuffer pWidth = stack.mallocInt(1); // int*
			IntBuffer pHeight = stack.mallocInt(1); // int*

			// Get the window size passed to glfwCreateWindow.
			glfwGetWindowSize(window, pWidth, pHeight);

			// Get the resolution of the primary monitor.
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			// Center the window.
			glfwSetWindowPos(
				window,
				(vidmode.width() - pWidth.get(0)) / 2,
				(vidmode.height() - pHeight.get(0)) / 2
			);
		} // The stack frame is popped automatically.

		// Make the OpenGL context current.
		glfwMakeContextCurrent(window);
		// Enable v-sync.
		glfwSwapInterval(1);

		// Make the window visible.
		glfwShowWindow(window);
	}
	
	private void loop() {
		// DO NOT DELETE
		GL.createCapabilities();

		// Set the clear color.
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

		// Run the rendering loop until the user has attempted to close
		// the window or has pressed the escape key.
		while ( !glfwWindowShouldClose(window) ) {
			
			// Clear the framebuffer.
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			// Swap the color buffers.
			glfwSwapBuffers(window); 

			// Poll for window events. The key callback above will only be
			// invoked during this call.
			glfwPollEvents();
		}
	}

}
