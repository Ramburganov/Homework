public class MyArrayDataException extends Exception {
    private int row;
    private int col;

    public MyArrayDataException(String message, int row, int col) {
        super(message);
        this.row = row;
        this.col = col;
    }

    public String getDetails() {
        return "Ошибка в ячейке: [" + row + "][" + col + "]";
    }
}
