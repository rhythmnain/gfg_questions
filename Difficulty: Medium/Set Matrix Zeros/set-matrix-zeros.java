class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
        int row=mat.length;
    int col=mat[0].length;
    //col marker
    int col0=1;
    //checking for col0
    for(int i=0;i<row;i++){
        if(mat[i][0]==0){
            col0=0;
            break;
        }
    }
    //checking for row0
    for(int j=0;j<col;j++){
        if(mat[0][j]==0){
            mat[0][0]=0;
            break;
        }
    }
    
    //checking rest of the matrix
    for(int i=1;i<row;i++){
        for(int j=1;j<col;j++){
            if(mat[i][j]==0){
                mat[0][j]=0;
                mat[i][0]=0;
            }
        }
    }
    //making colums 0
    for(int j=1;j<col;j++){
        if(mat[0][j]==0){
            setColZero(mat,j);
        }
    }
    //making rows 0
    for(int i=1;i<row;i++){
        if(mat[i][0]==0){
            setRowZero(mat,i);
        }
    }
    //making first row 0
    if(mat[0][0]==0){
        setRowZero(mat,0);
    }
    //making first col 0
    if(col0==0){
        setColZero(mat,0);
    }
    
    
        
    }
    
    public void setRowZero(int[][]mat,int row){
        for(int j=0;j<mat[0].length;j++){
            mat[row][j]=0;
        }
    }
     public void setColZero(int[][]mat,int col){
        for(int i=0;i<mat.length;i++){
            mat[i][col]=0;
        }
    }
}