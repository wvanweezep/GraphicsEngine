package engine.math;

import java.util.Objects;

public class Vector3 {

    public float x, y, z;

    /**
     * Initialize a {@code Vector3}
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param z The z-coordinate
     */
    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Sets the coordinates of the {@code Vector3}.
     *
     * @param x The new x-coordinate
     * @param y The new y-coordinate
     * @param z The new z-coordinate
     * @return The modified {@code Vector3}, which is not a copy
     */
    public Vector3 set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    /**
     * Sets the coordinates of the {@code Vector3}.
     *
     * @param target The coordinates to copy
     * @return The modified {@code Vector3}, which is not a copy
     */
    public Vector3 set(Vector3 target) {
        this.x = target.x;
        this.y = target.y;
        this.z = target.z;
        return this;
    }

    /**
     * Subtract a {@code Vector3} from the original.
     *
     * @param v The {@code Vector3} to subtract
     * @return The modified {@code Vector3}, which is not a copy
     */
    public Vector3 sub(Vector3 v) {
        return set(x - v.x, y - v.y, z - v.z);
    }

    /**
     * Add a {@code Vector3} to the original.
     *
     * @param v The {@code Vector3} to add
     * @return The modified {@code Vector3}, which is not a copy
     */
    public Vector3 add(Vector3 v) {
        return set(x + v.x, y + v.y, z + v.z);
    }

    /**
     * Multiply a {@code Vector3} with the original.
     *
     * @param v The {@code Vector3} to use for multiplication
     * @return The modified {@code Vector3}, which is not a copy
     */
    public Vector3 mul(Vector3 v) {
        return set(x * v.x, y * v.y, z * v.z);
    }

    /**
     * Divide a {@code Vector3} from the original.
     *
     * @param v The {@code Vector3} to use for division
     * @return The modified {@code Vector3}, which is not a copy
     */
    public Vector3 div(Vector3 v) {
        return set(x / v.x, y / v.y, z / v.z);
    }

    /**
     * The dot product of a two {@code Vector3}.
     *
     * @param v The {@code Vector3} to use for dot product
     * @return The result of the dot product
     */
    public float dot(Vector3 v) {
        return x * v.x + y * v.y + z * v.z;
    }

    /**
     * The cross product of a two {@code Vector3}.
     *
     * @param v The {@code Vector3} to use for cross product
     * @return The result of the cross product
     */
    public Vector3 cross(Vector3 v) {
        return set(
                y * v.z - z * v.y,
                z * v.x - x * v.z,
                x * v.y - y * v.x
        );
    }

    /**
     * Get the magnitude of a {@code Vector3}.
     *
     * @return The magnitude of the {@code Vector3}
     */
    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Normalizes the {@code Vector3}.
     *
     * @return The modified {@code Vector3}, which is not a copy
     */
    public Vector3 normalize() {
        float mag = magnitude();
        return set(x / mag, y / mag, z / mag);
    }

    /**
     * Copies the {@code Vector3}.
     *
     * @return A copy of the {@code Vector3}
     */
    public Vector3 copy() {
        return new Vector3(x, y, z);
    }

    /**
     * Getter for a zero {@code Vector3}.
     *
     * @return {@code Vector3(0, 0, 0)}
     */
    public static Vector3 zero() {
        return new Vector3(0, 0, 0);
    }

    /**
     * Getter for a one {@code Vector3}.
     *
     * @return {@code Vector3(1, 1, 1)}
     */
    public static Vector3 one() {
        return new Vector3(1, 1, 1);
    }

    /**
     * Getter for an up {@code Vector3}.
     *
     * @return {@code Vector3(0, 1, 0)}
     */
    public static Vector3 up() {
        return new Vector3(0, 1, 0);
    }

    /**
     * Getter for a down {@code Vector3}.
     *
     * @return {@code Vector3(0, -1, 0)}
     */
    public static Vector3 down() {
        return new Vector3(0, -1, 0);
    }

    /**
     * Getter for a right {@code Vector3}.
     *
     * @return {@code Vector3(1, 0, 0)}
     */
    public static Vector3 right() {
        return new Vector3(1, 0, 0);
    }

    /**
     * Getter for a left {@code Vector3}.
     *
     * @return {@code Vector3(-1, 0, 0)}
     */
    public static Vector3 left() {
        return new Vector3(-1, 0, 0);
    }

    /**
     * Getter for a {@code Vector3}
     *
     * @return {@code Vector3(0, 0, 1)}
     */
    public static Vector3 forward() {
        return new Vector3(0, 0, 1);
    }

    /**
     * Getter for a {@code Vector3}
     *
     * @return {@code Vector3(0, 0, -1)}
     */
    public static Vector3 backward() {
        return new Vector3(0, 0, -1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3 vector3 = (Vector3) o;
        return Float.compare(x, vector3.x) == 0
                && Float.compare(y, vector3.y) == 0
                && Float.compare(z, vector3.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Vector3(" +
                x + ", "+ y + ", " + z + ')';
    }
}
