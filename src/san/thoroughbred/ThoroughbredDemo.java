package san.thoroughbred;

/**
 * Main.png / ClassDiagram2 演示：Thoroughbred
 */
public class ThoroughbredDemo {

    public static void main(String[] args) {
        Thoroughbred t = new Thoroughbred("Mumtaz Mahal", "Nearco", 2020);
        System.out.println("母亲: " + t.getMother());
        System.out.println("父亲: " + t.getFather());
        System.out.println("出生年: " + t.getBirthyear());
        System.out.println("当前年龄: " + t.getCurrentAge());
    }
}
