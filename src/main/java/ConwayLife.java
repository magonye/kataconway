class ConwayLife {
    static int[][] getGeneration(int[][] glider, int i) {
        int x = glider.length;
        int y = glider[0].length;
        int[][] result = new int[x][y];


        for (int dimension = 0; dimension < x; dimension++) {
            for (int size = 0; size < y; size++) {
                if (glider[dimension][size]==0){
                    result[dimension][size]=0;
                } else {
                    result[dimension][size]=findNewCellStatus(glider,dimension,size);
                }
            }
        }
        return result;
    }

    static int findNewCellStatus(int[][] glider,int x, int y){
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

}
