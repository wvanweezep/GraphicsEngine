package engine.core;

import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Engine {

    private Window window;

    public void run() {
        init();
        loop();
        exit();
    }

    private void init() {
        if (!glfwInit()) { throw new IllegalStateException("Failed to initialize GLFW"); }
        window = new Window(1920, 1080, "Engine");
        window.activate();
    }

    private void loop() {
        GL.createCapabilities();
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        while (!glfwWindowShouldClose(window.getWindow())) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            //TODO: Render here...

            glfwSwapBuffers(window.getWindow());
            glfwPollEvents();
        }
    }

    private void exit(){
        window.close();
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}
