class ConwayLife {
    static int[][] getGeneration(int[][] glider, int i) {
        int[][] newGlider = glider;

        while (i > 0) {
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
            newGlider = result;
            i--;
        }
        return newGlider;
    }

    static int findNewLivingCellStatus(int[][] glider,int x, int y){
        int newStatus = 0;
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
        return ((newStatus==2 || newStatus==3)?1:0);
    }

    static int findNewDeadCellStatus(int[][] glider,int x, int y){
        int newStatus = 0;
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
        return ((newStatus==3)?1:0);
    }
}
