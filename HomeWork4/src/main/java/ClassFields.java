public class ClassFields {
    /**
     * Класс с переменными для работы reflection
     */
    String name;
    private byte b;
    private short sh;
    private char ch;
    private int i;
    private long L;
    private float fl;
    private double d ;
    private boolean boo;

    //Конструктор без параметров
//    public ClassFields() {}

    //Конструктор с параметрами
    public ClassFields(String name, byte b, short sh, char ch, int i, long l, float fl, double d, boolean boo) {
        this.name = name;
        this.b = b;
        this.sh = sh;
        this.ch = ch;
        this.i = i;
        this.L = l;
        this.fl = fl;
        this.d = d;
        this.boo = boo;
    }
}
