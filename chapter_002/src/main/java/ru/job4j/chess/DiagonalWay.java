package ru.job4j.chess;

/**
 * class Figure DiagonalWay implements FigureWay.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class DiagonalWay implements FigureWay {

    /**
     * Метод проверяющий правильность хода фигуры.
     * @return - список клеток ходов.
     */
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] currentCourse = new Cell[7];
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            int count = 1;
            if ((source.x - dest.x) <= -1 && (source.y - dest.y) <= -1) {
                for (int i = source.x + 1, j = source.y + 1; count <= Math.abs(dest.x - source.x); i++, j++) {
                    currentCourse[count - 1] = new Cell(i, j);
                    count++;
                }
            } else if ((source.x - dest.x) <= -1 && (source.y - dest.y) >= 1) {
                for (int i = source.x + 1, j = source.y - 1; count <= Math.abs(dest.x - source.x); i++, j--) {
                    currentCourse[count - 1] = new Cell(i, j);
                    count++;
                }
            } else if ((source.x - dest.x) >= 1 && (source.y - dest.y) >= 1) {
                for (int i = source.x - 1, j = source.y - 1; count <= Math.abs(dest.x - source.x); i--, j--) {
                    currentCourse[count - 1] = new Cell(i, j);
                    count++;
                }
            } else if ((source.x - dest.x) >= 1 && (source.y - dest.y) <= -1) {
                for (int i = source.x - 1, j = source.y + 1; count <= Math.abs(dest.x - source.x); i--, j++) {
                    currentCourse[count - 1] = new Cell(i, j);
                    count++;
                }
            }
        } else {
            throw new ImpossibleMoveException();
        }
        return currentCourse;
    }

}
