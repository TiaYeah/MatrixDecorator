package ru.tiayeah.matrixdecorator2;

public abstract class AMatrixDecorator implements IPrintableMatrix {
    protected IPrintableMatrix matrix;

    public AMatrixDecorator(IPrintableMatrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getRows() {
        return matrix.getRows();
    }

    @Override
    public int getCols() {
        return matrix.getCols();
    }

    public abstract int getValue(int row, int col);

    public abstract void setValue(int row, int col, int value);

    public abstract void draw(IDrawer drawer, boolean showBorder, int offsetX, int offsetY);

    @Override
    public IMatrix getComponent() {
        return matrix.getComponent();
    }

    @Override
    public void drawCell(IDrawer drawer, int i, int j, int value) {
        matrix.drawCell(drawer, i, j, value);
    }

    @Override
    public void fillCell(IDrawer drawer, int i, int j, int value) {
        matrix.fillCell(drawer, i, j, value);
    }
}
