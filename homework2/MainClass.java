package geekbrains.jmaxim1906.Java2.homework2;

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого
 * размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то
 * элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть
 * брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
 * и MyArrayDataException и вывести результат расчета.
 */

public class MainClass {
    public static void main (String[] args) {
    int result = 0;

    String[][] array = {{"1","1","1","1"},{"1","1","1","1"}};
    String[][] error_array = {{"1","2","3","4","5"},{"1","2","3","4"}};
    String[][] error_data = {{"1","2","3","4",},{"1","2","аа3","4"}};

        System.out.println("Program start");
        System.out.println("<--------------->");

        System.out.println("Correct Massive");
        try {
        result = 0;
        result = analyze(array);
    } catch(MyArraySizeException e){
        System.out.println(e.getMessage());
    } catch(MyArrayDataException e){
        System.out.println(e.getMessage());
    } finally {
        System.out.println("Result sum massive elements equals  "+String.valueOf(result));
        System.out.println("<------------------->");
    }

        System.out.println("Not rule massive");
        try {
        result = 0;
        result = analyze(error_array);
    } catch(MyArraySizeException e){
        System.out.println(e.getMessage());
    } catch(MyArrayDataException e){
        System.out.println(e.getMessage());
    } finally {
        System.out.println("Results sums massive elements equals "+String.valueOf(result));
        System.out.println("<---------------->");
    }
        System.out.println("Incorrect data ");
        try {
        result = 0;
        result = analyze(error_data);
    } catch(MyArraySizeException e){
        System.out.println(e.getMessage());
    } catch(MyArrayDataException e){
        System.out.println(e.getMessage());
    } finally {
        System.out.println("Result sums massive elements equals "+String.valueOf(result));
        System.out.println("<--------------------->");
    }
        System.out.println("Program Stop");
}

    public static int analyze(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int summ = 0;
        int value = 0;
        int row = 0;
        int cell = 0;

        if(array.length != 2 || array[0].length != 4 || array[1].length != 4) {
            throw new MyArraySizeException();
        }

        for(int i=1;i<3;i++){
            row = i;
            for(int c=1;c<5;c++){
                cell = c;
                try{
                    value = Integer.parseInt(array[i-1][c-1]);
                    summ += value;
                } catch (IllegalArgumentException e){
                    String message = "in "+String.valueOf(row)+" rows, "+String.valueOf(cell)+" cell";
                    throw new MyArrayDataException(message);
                }
            }
        }

        return summ;
    }
}
