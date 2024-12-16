package engine.rendering;

import java.util.ArrayList;
import java.util.List;

public class ShaderManager {

    private final List<Shader> shaders;

    public ShaderManager() {
        shaders = new ArrayList<>();
        shaders.add(new Shader("default",
                "./resources/vert.glsl",
                "./resources/frag.glsl"));
    }

    private boolean validated(String name) {
        return shaders.stream().anyMatch(s -> s.getName().equals(name));
    }

    public Shader getShader(String name) {
        return shaders.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(getShader("default"));
    }

    public void addShader(Shader shader) {
        if (!validated(shader.getName()))
            throw new RuntimeException("Shader already exists with name: " + shader.getName());
        shaders.add(shader);
    }

    public boolean removeShader(String name) {
        for (Shader shader : shaders.stream().filter(s -> s.getName().equals(name)).toList())
            shader.clean();
        return shaders.removeIf(s -> s.getName().equals(name));
    }

    public void clean() {
        for (Shader shader : shaders) shader.clean();
    }

}
