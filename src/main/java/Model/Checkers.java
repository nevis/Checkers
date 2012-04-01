package Model;

public class Checkers {
    private int checkersField [] [] = new int[8][8];
    private int chip;
    private int enemyChip;
    private boolean turn = false;
    private int firstRow, firstColumn;
    private boolean firstTurn = false;
    private Model model;
    private int killRow, killColumn;
    
    public Checkers(Model model) {
       this.model = model;
    }

    public void refreshCheckersBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    setOnChip(i, j);
                } else if ((i + j) % 2 == 0) {
                    checkersField [i][j] = -1;
                }
            }
        }
    }
    private void setOnChip(int i, int j) {
        //if (chip == 1) {
            if ((i * 8 + j) < 24) checkersField [i][j] = 2;
            else if ((i * 8 + j) > 39) checkersField [i][j] = 1;
            else checkersField [i][j] = 0;
        /*} else if (chip == 2){
            if ((i * 8 + j) < 24) checkersField [i][j] = 1;
            else if ((i * 8 + j) > 39) checkersField [i][j] = 2;
            else checkersField [i][j] = 0;
        }*/
    }
    public int getCheckersBoardValueAt(int i, int j) {
        return checkersField[i][j];
    }
    public void setCheckersBoardValue(int x, int y, int value) {
        checkersField[x][y] = value;

    }
    public void setChip(int chip) {
        this.chip = chip;
        if (chip == 1) enemyChip = 2;
        else enemyChip = 1;
    }
    public int getChip() {
        return chip;
    }
    public int getEnemyChip() {
        return enemyChip;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    public boolean getTurn() {
        return turn;
    }
    public void clientTurn(int row, int column) {
        if (!firstTurn) {
            firstTurn = isSelected(row, column);
        } else {
            if (secondTurn(row, column)) {
                checkersField[row][column] = chip;
                checkersField[firstRow][firstColumn] = 0;
                firstTurn = false;
                model.getClient().sendMessage("@turn;" + firstRow + ";" + firstColumn + ";"
                        + row + ";" + column + ";");
                turn = false;
            } else if (killTurn(row, column)) {
                checkersField[row][column] = chip;
                checkersField[firstRow][firstColumn] = 0;
                checkersField[firstRow + killRow][firstColumn + killColumn] = 0;
                model.getClient().sendMessage("@kill;" + firstRow + ";" + firstColumn + ";"
                        + row + ";" + column + ";" + killRow + ";" + killColumn + ";" );
                turn = false;
            } else {
                if (!isSelected(row, column)) firstTurn = false;
            }
        }
    }
    private boolean isSelected(int row, int column) {
        if (checkersField[row][column] == chip) {
            firstRow = row;
            firstColumn = column;
            return true;
        } else
            return false;
    }
    private boolean secondTurn(int row, int column) {
        if (chip == 1) {
            if ((row - firstRow == -1) && (column - firstColumn == -1) && (checkersField[row][column] == 0))
                return true;
            else if ((row - firstRow == -1) && (column - firstColumn == 1) && (checkersField[row][column] == 0))
                return true;
            else
                return false;
        } else {
            if ((row - firstRow == 1) && (column - firstColumn == 1) && (checkersField[row][column] == 0))
                return true;
            else if ((row - firstRow == 1) && (column - firstColumn == -1) && (checkersField[row][column] == 0))
                return true;
            else
                return false;
        }
    }
    private boolean killTurn(int row, int column) {
        if ((row - firstRow == -2) && (column - firstColumn == -2) && (checkersField[row][column] == 0)
                && (checkersField[firstRow - 1][firstColumn - 1] == enemyChip)) {
            killRow = -1;
            killColumn = -1;
            return true;
        } else if ((row - firstRow == -2) && (column - firstColumn == 2) && (checkersField[row][column] == 0)
                && (checkersField[firstRow - 1][firstColumn + 1] == enemyChip)) {
            killRow = -1;
            killColumn = 1;
            return true;
        } else if ((row - firstRow == 2) && (column - firstColumn == 2) && (checkersField[row][column] == 0)
                && (checkersField[firstRow + 1][firstColumn + 1] == enemyChip)) {
            killRow = 1;
            killColumn = 1;
            return true;
        } else if ((row - firstRow == 2) && (column - firstColumn == -2) && (checkersField[row][column] == 0)
                && (checkersField[firstRow + 1][firstColumn - 1] == enemyChip)) {
            killRow = 1;
            killColumn = -1;
            return true;
        } else
            return false;
    }
}
