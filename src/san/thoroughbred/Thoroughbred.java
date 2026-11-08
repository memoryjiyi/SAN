package san.thoroughbred;

import java.util.Objects;

/**
 * UML Main.png / ClassDiagram2: Thoroughbred（纯种马）
 * 属性：mother: String、father: String、birthyear: Integer
 * 方法：getCurrentAge(): Integer、getFather(): String、getMother(): String
 */
public class Thoroughbred {

    private final String mother;
    private final String father;
    private final Integer birthyear;

    public Thoroughbred(String mother, String father, Integer birthyear) {
        this.mother = Objects.requireNonNull(mother, "mother");
        this.father = Objects.requireNonNull(father, "father");
        if (birthyear == null || birthyear <= 0) {
            throw new IllegalArgumentException("birthyear must be a positive year");
        }
        this.birthyear = birthyear;
    }

    /** 当前年龄 = 当前年份 - 出生年份 */
    public Integer getCurrentAge() {
        return java.time.Year.now().getValue() - birthyear;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public Integer getBirthyear() {
        return birthyear;
    }
}
