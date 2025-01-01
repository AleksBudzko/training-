package JustAlgosy;
import java.util.*;

public class greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Читаем входные данные
        int n = sc.nextInt(); // Количество чисел
        int k = sc.nextInt(); // Число операций
        sc.nextLine(); // Пропуск новой строки

        String[] numbers = sc.nextLine().split(" "); // Числа на бумажке

        // Изначальная сумма всех чисел
        long initialSum = 0;
        for (String number : numbers) {
            initialSum += Long.parseLong(number);
        }

        // Храним все возможные увеличения
        List<Integer> increases = new ArrayList<>();

        // Для каждого числа вычисляем возможные приросты
        for (String number : numbers) {
            for (int i = 0; i < number.length(); i++) {
                char currentDigit = number.charAt(i);
                if (currentDigit != '9') {
                    // Вычисляем прирост при замене этой цифры на 9
                    int increase = (9 - (currentDigit - '0')) * (int) Math.pow(10, number.length() - 1 - i);
                    increases.add(increase);
                }
            }
        }

        // Сортируем приросты по убыванию
        Collections.sort(increases, Collections.reverseOrder());

        // Применяем до k операций
        long maxIncrease = 0;
        for (int i = 0; i < Math.min(k, increases.size()); i++) {
            maxIncrease += increases.get(i);
        }

        // Выводим результат: разница между конечной и начальной суммой
        System.out.println(maxIncrease);
    }
}
