import java.time.LocalDate;

/**
 * A1‑1 良种马 Thoroughbred
 */
public class A1_1_Thoroughbred {
    //私有属性
    private A1_1_Thoroughbred mother;
    private A1_1_Thoroughbred father;
    private Integer birthyear;

    public A1_1_Thoroughbred(A1_1_Thoroughbred mother, A1_1_Thoroughbred father, Integer birthyear) {
        this.mother = mother;
        this.father = father;
        this.birthyear = birthyear;
    }

    // 获取当前年龄
    public Integer getCurrentAge() {
        int curYear = LocalDate.now().getYear();
        return curYear - birthyear;
    }

    // 获取父亲
    public A1_1_Thoroughbred getFather() {
        return father;
    }

    // 获取母亲
    public A1_1_Thoroughbred getMother() {
        return mother;
    }

    // setter
    public void setMother(A1_1_Thoroughbred mother) {
        this.mother = mother;
    }
    public void setFather(A1_1_Thoroughbred father) {
        this.father = father;
    }
    public void setBirthyear(Integer birthyear) {
        this.birthyear = birthyear;
    }
}
