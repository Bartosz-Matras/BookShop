package pl.matrasbartosz.bookshop.model;

public enum BookType {
    HARDCOVER("Hardcover"),
    SOFTCOVER("Softcover"),
    LEATHER("Leather"),
    POCKET("Pocket");

    public final String type;

    BookType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
