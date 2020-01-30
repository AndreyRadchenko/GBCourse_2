/**
 * 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 *     10 3 1 2
 *     2 3 2 2
 *     5 6 7 1
 *     300 3 1 0
 *     Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив
 *     типа String[][];
 * 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть
 *     результат;
 * 3. Ваши методы должны бросить исключения в случаях:
 *     Если размер матрицы, полученной из строки, не равен 4x4;
 *     Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 * 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
 * 5* Написать собственные классы исключений для каждого из случаев
 */

package Chapter_2;

public class Conversion {
    static String example = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

    public static void main(String[] args) {

        try {
            System.out.println(convertStringToArrayInt(example));
        } catch (WrongTypeDataException | OutOfSizeArrayException e) {
            System.out.println(e.getMessage());
        }

    }

    private static int convertStringToArrayInt(String string) throws WrongTypeDataException, OutOfSizeArrayException {
        final int SIZE = 4;
        int sum = 0;
        String[][] strArr = new String[SIZE][SIZE];
        String[] lineArr = string.split("\n");

        if (lineArr.length != SIZE) {
            throw new OutOfSizeArrayException("Размер матрицы должен быть 4Х4!");
        }

        for (int i = 0; i < SIZE; i++) {
            String s = lineArr[i];
            for (char n : s.toCharArray()) {
                if (n != '0' & n != '1' & n != '2' & n != '3' & n != '4' & n != '5'
                        & n != '6' & n != '7' & n != '8' & n != '9' & n != ' ') {
                    throw new WrongTypeDataException("В матрице должны быть только числа !");
                }
            }
            String[] arr = s.split(" ");
            if (arr.length != SIZE) {
                throw new OutOfSizeArrayException("Размер матрицы должен быть 4Х4!");
            }
            for (int j = 0; j < SIZE; j++) {
                strArr[i][j] = arr[j];
            }
        }



        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sum += Integer.parseInt(strArr[i][j]);
            }
        }

        return sum/2;
    }
}
