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
        if (chip == 1) {
            if ((i * 8 + j) < 24) checkersField [i][j] = 2;
            else if ((i * 8 + j) > 39) checkersField [i][j] = 1;
            else checkersField [i][j] = 0;
        } else if (chip == 2){
            if ((i * 8 + j) < 24) checkersField [i][j] = 1;
            else if ((i * 8 + j) > 39) checkersField [i][j] = 2;
            else checkersField [i][j] = 0;
        }
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
            if ((!checkToKill()) && (secondTurn(row, column))) {
                if (row == 7) checkersField[row][column] = chip*10 + 1;
                else checkersField[row][column] = chip;
                checkersField[firstRow][firstColumn] = 0;
                firstTurn = false;
                model.getClient().sendMessage("@turn;" + firstRow + ";" + firstColumn + ";"
                        + row + ";" + column + ";");

                turn = false;
            } else if (killTurn(row, column)) {
                if (row == 7) checkersField[row][column] = chip*10 + 1;
                else checkersField[row][column] = chip;
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
        if ((checkersField[row][column] == chip) || (checkersField[row][column] == chip*10 + 1)) {
            firstRow = row;
            firstColumn = column;
            return true;
        } else
            return false;
    }
    private boolean secondTurn(int row, int column) {
        if ((checkersField[firstRow][firstColumn] == 1) || (checkersField[firstRow][firstColumn] == 2)) {
            if ((row - firstRow == -1) && (column - firstColumn == -1) && (checkersField[row][column] == 0))
                return true;
            else if ((row - firstRow == -1) && (column - firstColumn == 1) && (checkersField[row][column] == 0))
                return true;
            else
                return false;
        } else if ((checkersField[firstRow][firstColumn] == 11) || (checkersField[firstRow][firstColumn] == 21)){
            if ((Math.abs(row - firstRow ) == Math.abs(column - firstColumn)) && (checkersField[row][column] == 0))
                return true;
            else
                return false;
        } else
            return false;
    }
    
    private boolean killTurn(int row, int column) {
        boolean kill = false;
        if (Math.abs(row - firstRow) == Math.abs(column - firstColumn)) {
            int clientLoc = Math.abs(row - firstRow);
            if ((firstRow - clientLoc >= 0) && (firstColumn - clientLoc >= 0) &&
                    isLeftUpKill(firstRow, firstColumn, 1, clientLoc)) {
                killRow = -1;
                killColumn = -1;
                kill = true;
            } else if ((firstRow + clientLoc <= 7) && (firstColumn - clientLoc >= 0) &&
                    isLeftDownKill(firstRow, firstColumn, 1, clientLoc)) {
                killRow = 1;
                killColumn = -1;
                kill = true;
            } else if ((firstRow - clientLoc >= 0) && (firstColumn + clientLoc <= 7) &&
                    isRightUpKill(firstRow, firstColumn, 1, clientLoc)) {
                killRow = -1;
                killColumn = 1;
                kill = true;
            } else if ((firstRow + clientLoc <= 7) && (firstColumn + clientLoc <= 7) &&
                    isRightDownKill(firstRow, firstColumn, 1, clientLoc)) {
                killRow = 1;
                killColumn = 1;
                kill = true;
            }
        }
        return kill;
    }
    private boolean checkToKill() {
        boolean kill = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (checkersField[i][j] == chip) {
                      if (isHaveToKill(i, j, 1, 2)) {
                          kill = true;
                          break;
                      }
                }
            }
        }
        return kill;
    }
    private boolean isHaveToKill(int row, int column, int enemyLoc, int clientLoc) {
        if ((row - clientLoc >= 0) && (column - clientLoc >= 0) &&
                isLeftUpKill(row, column, enemyLoc, clientLoc)) {
            return true;
        } else if ((row + clientLoc <= 7) && (column - clientLoc >= 0) &&
                isLeftDownKill(row, column, enemyLoc, clientLoc)) {
            return true;
        } else if ((row - clientLoc >= 0) && (column + clientLoc <= 7) &&
                isRightUpKill(row, column, enemyLoc, clientLoc)) {
            return true;
        } else if ((row + clientLoc <= 7) && (column + clientLoc <= 7) &&
                isRightDownKill(row, column, enemyLoc, clientLoc)) {
            return true;
        } else
            return false;
    }
    private boolean isLeftUpKill(int row, int column, int enemyLoc, int clientLoc) {
        if ((checkersField[row - enemyLoc][column - enemyLoc] == enemyChip) &&
                (checkersField[row - clientLoc][column - clientLoc] == 0)) return true;
        else return false;
    }
    private boolean isLeftDownKill(int row, int column, int enemyLoc, int clientLoc) {
        if ((checkersField[row + enemyLoc][column - enemyLoc] == enemyChip) &&
                (checkersField[row + clientLoc][column - clientLoc] == 0)) return true;
        else return false;
    }
    private boolean isRightUpKill(int row, int column, int enemyLoc, int clientLoc) {
        if ((checkersField[row - enemyLoc][column + enemyLoc] == enemyChip) &&
                (checkersField[row - clientLoc][column + clientLoc] == 0)) return true;
        else return false;
    }
    private boolean isRightDownKill(int row, int column, int enemyLoc, int clientLoc) {
        if ((checkersField[row + enemyLoc][column + enemyLoc] == enemyChip) &&
                (checkersField[row + clientLoc][column + clientLoc] == 0)) return true;
        else return false;
    }
}
