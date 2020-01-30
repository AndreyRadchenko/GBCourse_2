/**
 * 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
 *   - Найти список слов, из которых состоит текст (дубликаты не считать);
 *   - Посчитать сколько раз встречается каждое слово (использовать HashMap);
 * 2. Написать простой класс PhoneBook(внутри использовать HashMap):
 *   - В качестве ключа использовать фамилию
 *   - В каждой записи всего два поля: phone, e-mail
 *   - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов), и отдельный
 *     метод для поиска e-mail по фамилии. Следует учесть, что под одной фамилией может быть несколько записей. Итого
 *     должно получиться 3 класса Main, PhoneBook, Person.
 */

package Chapter_3;

import java.util.*;

public class WordsCount {
    private static String text = "Ночь, улица, фонарь, аптека,\n" +
            "Бессмысленный и тусклый свет.\n" +
            "Живи еще хоть четверть века -\n" +
            "Все будет так. Исхода нет.\n" +
            "Умрешь - начнешь опять сначала\n" +
            "И повторится все, как встарь:\n" +
            "Ночь, ледяная рябь канала,\n" +
            "Аптека, улица, фонарь.";

    private static String[] arrWords = {"A", "A", "C", "B", "D", "D", "B", "A", "E", "F", "E", "E", "A", "L"};

    public static void main(String[] args) {
        System.out.println(uniqueWordsArray(text));
        System.out.println(getWordsQuantity(arrWords));
    }

    private static Collection uniqueWordsArray(String s) {
        //Никак не пойму, почему-то первый пробел в тексте интерпретируется как элемент списка
        String[] strings = s.toLowerCase().split("[\\-, .:\n]");
        return new LinkedHashSet<>(Arrays.asList(strings));
    }

    private static HashMap<String, Integer> getWordsQuantity(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
}
