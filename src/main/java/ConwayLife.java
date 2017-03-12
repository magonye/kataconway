class ConwayLife {

    private static int[][] newGlider;

    static int[][] getGeneration(int[][] glider, int i) {
        copyGlider(glider);
        doConwayIterations(i);
        decreaseMatrix();
        return newGlider;
    }

    private static void copyGlider(int[][] glider) {
        newGlider = glider;
    }

    private static void doConwayIterations(int i) {
        while (i > 0) {
            increaseMatrix();
            doConway();
            i--;
        }
    }

    private static void doConway() {
        int x = newGlider.length;
        int y = newGlider[0].length;
        int[][] result = new int[x][y];

        for (int dimension = 0; dimension < x; dimension++) {
            for (int size = 0; size < y; size++) {
                if (newGlider[dimension][size] == 0) {
                    result[dimension][size] = findNewDeadCellStatus(newGlider, dimension, size);
                } else {
                    result[dimension][size] = findNewLivingCellStatus(newGlider, dimension, size);
                }
            }
        }
        copyGlider(result);
    }

    private static void increaseMatrix() {
        increaseFirstRows();
        increaseLastRows();
        increaseFirstCols();
        increaseLastCols();
    }

    private static void decreaseMatrix() {
        decreaseFirstRows();
        decreaseLastRows();
        decreaseFirstCols();
        decreaseLastCols();
    }

    private static void increaseLastCols() {
        if (isGliderNotEmpty()){
            for (int i =0; i<newGlider.length; i++){
                int[] row = newGlider[i];
                int[] newRow = new int[row.length+1];
                System.arraycopy(row, 0, newRow, 0, row.length);
                newRow[row.length] = 0;
                newGlider[i] = newRow;
            }
        }
    }

    private static boolean isGliderNotEmpty() {
        return newGlider.length>0;
    }

    private static void increaseFirstCols() {
        if (isGliderNotEmpty()){
            for (int i =0; i<newGlider.length; i++){
                int[] row = newGlider[i];
                int[] newRow = new int[row.length+1];
                newRow[0] = 0;
                System.arraycopy(row, 0, newRow, 1, row.length);
                newGlider[i] = newRow;
            }
        }
    }

    private static void increaseLastRows() {
        if (isGliderNotEmpty()){
            int x = newGlider[newGlider.length-1].length;
            int[] newRow = new int[x];
            for (int i =0; i<x; i++){
                newRow[i] = 0;
            }
            int[][] result = new int[newGlider.length+1][x];
            System.arraycopy(newGlider, 0, result, 0, newGlider.length);
            result[newGlider.length] = newRow;
            copyGlider(result);
        }
    }

    private static void increaseFirstRows() {
        if (isGliderNotEmpty()){
            int x = newGlider[0].length;
            int[] newRow = new int[x];
            for (int i =0; i<x; i++){
                newRow[i] = 0;
            }
            int[][] result = new int[newGlider.length+1][x];
            result[0] = newRow;
            System.arraycopy(newGlider, 0, result, 1, newGlider.length);
            copyGlider(result);
        }
    }

    private static void decreaseFirstCols() {
        boolean checking = true;
        while(checking){
            if (isGliderNotEmpty()) {
                for (int[] aNewGlider : newGlider) {
                    if (aNewGlider[0] == 1) {
                        checking = false;
                    }
                }
                if (checking) {
                    deleteFirstCol();
                }
            } else {
                checking = false;
            }
        }
    }

    private static void decreaseLastCols() {
        boolean checking = true;
        while(checking){
            if (isGliderNotEmpty()) {
                for (int[] aNewGlider : newGlider) {
                    if (aNewGlider[aNewGlider.length - 1] == 1) {
                        checking = false;
                    }
                }
                if (checking) {
                    deleteLastCol();
                }
            } else {
                checking = false;
            }
        }
    }

    private static void decreaseFirstRows() {
        boolean checking = true;

        while(checking){
            if (isGliderNotEmpty()) {
                int[] row = newGlider[0];
                for (int aRow : row) {
                    if (aRow == 1) {
                        checking = false;
                    }
                }
                if (checking) {
                    deleteFirstRow();
                }
            } else {

                checking = false;
            }
        }
    }

    private static void decreaseLastRows() {
        boolean checking = true;

        while(checking){
            if (isGliderNotEmpty()) {
                int[] row = newGlider[newGlider.length-1];
                for (int aRow : row) {
                    if (aRow == 1) {
                        checking = false;
                    }
                }
                if (checking) {
                    deleteLastRow();
                }
            } else {
                checking = false;
            }
        }
    }

    private static void deleteFirstCol() {
        for (int i = 0; i < newGlider.length;i++) {
            int x = newGlider[i].length-1;
            int[] result = new int[x];
            System.arraycopy(newGlider[i], 1, result, 0, newGlider[i].length - 1);
            newGlider[i] = result;
        }
    }
    private static void deleteLastCol() {
        for (int i = 0; i < newGlider.length;i++) {
            int x = newGlider[i].length-1;
            int[] result = new int[x];
            System.arraycopy(newGlider[i], 0, result, 0, newGlider[i].length - 1);
            newGlider[i] = result;
        }
    }

    private static void deleteFirstRow() {
        int x = newGlider.length-1;
        int y = newGlider[0].length;
        int[][] result = new int[x][y];
        System.arraycopy(newGlider, 1, result, 0, newGlider.length - 1);
        copyGlider(result);
    }

    private static void deleteLastRow() {
        int x = newGlider.length-1;
        int y = newGlider[0].length;
        int[][] result = new int[x][y];
        System.arraycopy(newGlider, 0, result, 0, newGlider.length - 1);
        copyGlider(result);
    }

    private static int findNewLivingCellStatus(int[][] glider, int x, int y){
        int newStatus = 0;
        newStatus = findNeighboursLivingCells(glider, x, y, newStatus);
        return ((newStatus==2 || newStatus==3)?1:0);
    }

    private static int findNewDeadCellStatus(int[][] glider, int x, int y){
        int newStatus = 0;
        newStatus = findNeighboursLivingCells(glider, x, y, newStatus);
        return ((newStatus==3)?1:0);
    }

    private static int findNeighboursLivingCells(int[][] glider, int x, int y, int newStatus) {
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (i>=0 && i<glider.length){
                    if (j>=0 && j<glider[0].length){
                        if (i!=x || j != y){
                            if (glider[i][j]==1){
                                newStatus++;
                            }
                        }
                    }
                }
            }
        }
        return newStatus;
    }
}
