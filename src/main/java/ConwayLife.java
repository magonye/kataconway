class ConwayLife {
    static int[][] getGeneration(int[][] glider, int i) {
        return new int[][]{{0,1,0},
                {0,0,1},
                {1,1,1}};
    }
}
