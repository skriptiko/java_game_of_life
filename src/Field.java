import java.util.Arrays;

public class Field {
    public int size;
    public int[][] fieldWithLife;
    public char[] borderLine;

    public Field() {
        size = 10;
        borderLine = createBorderLine();
        fieldWithLife = createField();
    }

    public int[][] createField() {
        int[][] newField = new int[size][size];

        for (int[] row : newField) {
            Arrays.fill(row, 0);
        }

        for(int i = 0; i < newField.length; i++) {
            for(int j = 0; j < newField[i].length; j++) {
                newField[i][j] = getRandomNumber(0, 2);
            }
        }

        return newField;
    }

    public char[] createBorderLine() {
        char[] newLine = new char[size];

        Arrays.fill(newLine, '-');

        return newLine;
    }

    public int countNeighboursCount(int i, int j) {
        int count = 0;

        if (i != 0) {
            if(fieldWithLife[i - 1][j] == 1) {
                count++;
            }
        }

        if (j != 0){
            if(fieldWithLife[i][j - 1] == 1) {
                count++;
            }
        }

        if (i != 0 && j != 0) {
            if(fieldWithLife[i - 1][j - 1] == 1) {
                count++;
            }
        }

        if (i != size - 1 && j != size - 1) {
            if (fieldWithLife[i + 1][j + 1] == 1) {
                count++;
            }
        }

        if (i != 0 && j != size - 1) {
            if(fieldWithLife[i - 1][j + 1] == 1) {
                count++;
            }
        }

        if (j != size - 1) {
            if(fieldWithLife[i][j + 1] == 1) {
                count++;
            }
        }

        if (i != size - 1 && j != 0) {
            if(fieldWithLife[i + 1][j - 1] == 1) {
                count++;
            }
        }

        if (i != size - 1) {
            if(fieldWithLife[i + 1][j] == 1) {
                count++;
            }
        }

        return count;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void checkFieldWithLife(int iterations) {

        int count = 0;

        while (count != iterations) {

            for(int i = 0; i < fieldWithLife.length; i++) {
                for(int j = 0; j < fieldWithLife[i].length; j++) {
                    int neighbours = countNeighboursCount(i, j);

                    if (neighbours < 2 || neighbours > 3) {
                        if (fieldWithLife[i][j] == 1) {
                            fieldWithLife[i][j] = 0;
                        }
                    } else if (neighbours == 3) {
                        fieldWithLife[i][j] = 1;
                    }
                }
            }

            for (int[] row : fieldWithLife) {
                System.out.println(Arrays.toString(row));
            }

            System.out.println(Arrays.toString(borderLine));

            count++;

        }
    }
}
