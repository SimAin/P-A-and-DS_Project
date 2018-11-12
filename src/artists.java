public class artists {
    public String[] array;
    public int currentSize;
    public int maximumSize;

    public artists (int maximumSize) {
        array = new String[maximumSize];
        this.maximumSize = maximumSize;
        this.currentSize = 0;             // our stack starts empty
    }

    public void push (String value) {
        if (currentSize >= maximumSize) {
            System.out.println ("Error: Stack push has exceeded available space");
        }

        array[currentSize] = value;
        currentSize = currentSize + 1;
    }
}
