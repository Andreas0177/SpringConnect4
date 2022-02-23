package com.score4.score4.view;

public class HtmlViewer {

    static final String X="<img src=\"https://pngimg.com/uploads/circle/small/circle_PNG4.png\" alt=\"Lamp\" width=\"32\" height=\"32\">";
    static final String O="<img src=\"https://pngimg.com/uploads/circle/circle_PNG3.png\" alt=\"Lamp\" width=\"32\" height=\"32\">";
    static final String empty="<img src=\"https://pngimg.com/uploads/circle/circle_PNG2.png\" alt=\"Lamp\" width=\"32\" height=\"32\">";
    static final String line="<br>";
    /*
    Creates html code from a Connect4 matrix

    [0,5][1,5][2,5]
    [0,4][1,4][2,4]
    [0,3][1,3][2,3]
    [0,2][1,2][2,2]
    [0,1][1,1][2,1]
    [0,0][1,0][2,0]

     */
    public static String getMatrix(Integer[][] matrix){

        StringBuilder out= new StringBuilder("<html>");
        for(int j=matrix[0].length-1;j>=0;j--) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == null)
                    out.append(empty);
                else if (matrix[i][j].equals(1) )
                    out.append(O);
                else
                    out.append(X);
            }
            out.append(line);
        }
        out.append("</html>");
        return out.toString();
    }
}
