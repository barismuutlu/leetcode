class Solution {
    public boolean isValidSudoku(char[][] board) {
       boolean[][] row = new boolean[9][9];
       boolean[][] column = new boolean[9][9];
       boolean[][] subbox = new boolean[9][9];
       
       for(int x=0;x<9;x++)
       {
            for(int y=0;y<9;y++)
            {
                if(board[x][y] == '.')
                {
                    continue;
                }
                int number = Character.getNumericValue(board[x][y]) - 1;
                //Detecting the sub group, my favorite line in the whole code
                int sub = x / 3 * 3 + y /3;
                if(row[x][number] || column[y][number] || subbox[sub][number])
                {
                    return false;
                }
                row[x][number] = true;
                column[y][number] = true;
                subbox[sub][number] = true;
            }
       }
       return true;
    }
}


//Unnecessary stupid first Solution -almost couple of hours :(
/*import java.util.Map;
import java.util.HashMap;

class Solution {

    static int whichBox(int x, int y) {
        int k = 0, a = 0;
        if (x <= 2) {
            k = 1;
        } else if (x <= 5) {
            k = 2;
        } else if (x <= 8) {
            k = 3;
        }

        if (y <= 2) {
            a = 0;
        } else if (y <= 5) {
            a = 3;
        } else if (y <= 8) {
            a = 6;
        }
        return k + a;
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, String> newMap = new HashMap<>();
        for (int i = 0; i <= 8; i++) {
            for (int a = 0; a <= 8; a++) {
                if(board[i][a] != '.')
                {
                   int number = Character.getNumericValue(board[i][a]);

                if (newMap.containsKey(number)) {
                    if(newMap.get(number).length() > 5)
                    {
                       String[] beforelocations = newMap.get(number).split("&");
                       for(String str : beforelocations)
                       {
                            String[] xyz = str.split("\\*");
                            if (Integer.parseInt(xyz[0]) == i || Integer.parseInt(xyz[1]) == a || Integer.parseInt(xyz[2]) == whichBox(i, a))
                            {
                                return false;
                            }
                       } 
                    }
                    else
                    {
                            System.out.println(newMap.get(number));
                            String[] xyz = newMap.get(number).split("\\*");                  
                            if (Integer.parseInt(xyz[0]) == i || Integer.parseInt(xyz[1]) == a || Integer.parseInt(xyz[2]) == whichBox(i, a))
                            {
                                return false;
                            }
                    }
                    newMap.put(number, newMap.getOrDefault(number, "0") + "&" + i + "*" + a + "*" + whichBox(i, a)); 
                } else {
                    newMap.put(number, i + "*" + a + "*" + whichBox(i, a));
                }
                }
                
            }
        }
        return true;
    }
}
*/
