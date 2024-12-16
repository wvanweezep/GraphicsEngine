package engine.rendering;

public class Renderer {

    private final ShaderManager shaderManager;

    public Renderer() {
        shaderManager = new ShaderManager();
    }

    public ShaderManager getShaderManager() {
        return shaderManager;
    }

}
