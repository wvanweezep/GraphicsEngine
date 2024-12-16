package engine.math;

import java.util.Objects;

public class Vector4 extends Vector3 {

    public float w;

    public Vector4(float x, float y, float z) {
        super(x, y, z);
        this.w = 1.f;
    }

    public Vector4(float x, float y, float z, float w) {
        super(x, y, z);
        this.w = w;
    }

    public Vector3 toVector3() {
        if (w == 0) throw new ArithmeticException("w cannot be 0 for division");
        return new Vector3(x / w, y / w, z / w);
    }

    @Override
    public Vector4 copy() {
        return new Vector4(x, y, z, w);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vector4 vector4 = (Vector4) o;
        return Float.compare(w, vector4.w) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), w);
    }

    @Override
    public String toString() {
        return "Vector4(" +
                x + ", "+ y + ", " + z + ", " + w +')';
    }
}
