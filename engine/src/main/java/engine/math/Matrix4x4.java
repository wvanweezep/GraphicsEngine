package engine.math;

import java.util.Arrays;
import java.util.Objects;

public class Matrix4x4 {

    private float[][] matrix;

    // Constructor to create a 4x4 matrix
    public Matrix4x4() {
        matrix = new float[4][4];
        setIdentity();
    }

    // Set the matrix to an identity matrix
    public void setIdentity() {
        matrix[0][0] = 1.f; matrix[0][1] = 0.f; matrix[0][2] = 0.f; matrix[0][3] = 0.f;
        matrix[1][0] = 0.f; matrix[1][1] = 1.f; matrix[1][2] = 0.f; matrix[1][3] = 0.f;
        matrix[2][0] = 0.f; matrix[2][1] = 0.f; matrix[2][2] = 1.f; matrix[2][3] = 0.f;
        matrix[3][0] = 0.f; matrix[3][1] = 0.f; matrix[3][2] = 0.f; matrix[3][3] = 1.f;
    }

    // Translation matrix
    public Matrix4x4 translate(float dx, float dy, float dz) {
        matrix[0][3] = dx;
        matrix[1][3] = dy;
        matrix[2][3] = dz;
        return this;
    }

    // Scaling matrix
    public Matrix4x4 scaling(float sx, float sy, float sz) {
        matrix[0][0] = sx;
        matrix[1][1] = sy;
        matrix[2][2] = sz;
        return this;
    }

    // Rotation around X-axis (angle in radians)
    public Matrix4x4 rotationX(float angle) {
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        matrix[1][1] = cos;
        matrix[1][2] = -sin;
        matrix[2][1] = sin;
        matrix[2][2] = cos;
        return this;
    }

    // Rotation around Y-axis (angle in radians)
    public Matrix4x4 rotationY(float angle) {
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        matrix[0][0] = cos;
        matrix[0][2] = sin;
        matrix[2][0] = -sin;
        matrix[2][2] = cos;
        return this;
    }

    // Rotation around Z-axis (angle in radians)
    public Matrix4x4 rotationZ(float angle) {
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        matrix[0][0] = cos;
        matrix[0][1] = -sin;
        matrix[1][0] = sin;
        matrix[1][1] = cos;
        return this;
    }

    // Matrix multiplication (this * other)
    public Matrix4x4 multiply(Matrix4x4 other) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = matrix[i][0] * other.matrix[0][j] +
                        matrix[i][1] * other.matrix[1][j] +
                        matrix[i][2] * other.matrix[2][j] +
                        matrix[i][3] * other.matrix[3][j];
            }
        }
        return this;
    }

    // Apply transformation matrix to a vector (multiply matrix by vector)
    public Vector4 apply(Vector4 vector) {
        float x = matrix[0][0] * vector.x + matrix[0][1] * vector.y
                + matrix[0][2] * vector.z + matrix[0][3] * vector.w;
        float y = matrix[1][0] * vector.x + matrix[1][1] * vector.y
                + matrix[1][2] * vector.z + matrix[1][3] * vector.w;
        float z = matrix[2][0] * vector.x + matrix[2][1] * vector.y
                + matrix[2][2] * vector.z + matrix[2][3] * vector.w;
        float w = matrix[3][0] * vector.x + matrix[3][1] * vector.y
                + matrix[3][2] * vector.z + matrix[3][3] * vector.w;
        return new Vector4(x, y, z, w);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix4x4 matrix4x4 = (Matrix4x4) o;
        return Objects.deepEquals(matrix, matrix4x4.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Matrix4x4{");
        for (float[] row : matrix) {
            out.append("\n");
            for (float val : row) out.append(val).append("  ");
        } out.append('}');
        return out.toString();
    }
}
