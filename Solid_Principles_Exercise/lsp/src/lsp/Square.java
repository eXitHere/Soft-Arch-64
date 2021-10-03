package lsp;

public class Square {
    private int side;
    
    Square(int side) {
        this.side = side;
    }

    public void setWidth(int width) {
        this.setSide(width);
    }

    public int getWidth() {
        return this.side;
    }

    public void setHeight(int height) {
        this.setSide(height);
    }

    public int getHeight() {
        return this.side;
    }
    
    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return this.side;
    }
    
    public int getArea() {
        return this.side * this.side;
    }
}
