public class FibonacciNum {
    private int pos;
    private int value;

    /**
     * Конструктор
     *
     * @param pos Позиція числа
     * @param value Значення числа
     */
    public FibonacciNum(int pos, int value) {
        setPos(pos);
        setValue(value);
    }

    /**
     * Отримати позицію числа
     *
     * @return int
     */
    public int getPos() {
        return pos;
    }

    /**
     * Встановити позицію числа
     *
     * @param pos
     */
    public void setPos(int pos) {
        this.pos = pos;
    }

    /**
     * Отримати значення числа
     *
     * @return int
     */
    public int getValue() {
        return value;
    }

    /**
     * Встановити значення числа
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
}
