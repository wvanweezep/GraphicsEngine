package engine.rendering;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.lwjgl.opengl.GL20.*;

public class Shader {

    private String name;
    private int programId;

    public Shader(String name, String vertexPath, String fragmentPath) {
        this.name = name;
        int vertexShader = compileShader(loadSource(vertexPath), GL_VERTEX_SHADER);
        int fragmentShader = compileShader(loadSource(fragmentPath), GL_FRAGMENT_SHADER);

        programId = glCreateProgram();
        glAttachShader(programId, vertexShader);
        glAttachShader(programId, fragmentShader);
        glLinkProgram(programId);

        if (glGetProgrami(programId, GL_LINK_STATUS) == 0) {
            throw new RuntimeException("Error linking shader program: " + glGetProgramInfoLog(programId));
        }

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);
    }

    private String loadSource(String path){
        try {
            return new String(Files.readAllBytes(Path.of(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int compileShader(String source, int type) {
        int shaderId = glCreateShader(type);
        glShaderSource(shaderId, source);
        glCompileShader(shaderId);

        if (glGetShaderi(shaderId, GL_COMPILE_STATUS) == 0) {
            throw new RuntimeException("Error compiling shader: " + glGetShaderInfoLog(shaderId));
        }

        return shaderId;
    }

    public String getName() {
        return name;
    }

    public void use() {
        glUseProgram(programId);
    }

    public void clean() {
        glDeleteProgram(programId);
    }

}
