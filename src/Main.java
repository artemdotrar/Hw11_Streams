import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            arrayList.add(r.nextInt(100));
            //System.out.print(arrayList.get(i) + "; ");
        }
        System.out.println(arrayList);

        long countOfEven = arrayList.stream()
                .filter(x -> x % 2 == 0)
                .count();

        System.out.println("Четных: " + countOfEven);

        System.out.println("\nСортировка по убыванию: ");
        arrayList.stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .forEach(value -> System.out.print(value + ", "));

        System.out.println("\nСортировка по возрастанию: ");
        arrayList.stream()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .forEach(value -> System.out.print(value + ", "));

        int minValue = arrayList.stream()
                .min(Integer::compareTo).get();
        int maxValue = arrayList.stream()
                .max(Integer::compareTo).get();
        System.out.println("\n\nМинимальный элемент: " + minValue + ", Максимальный: " + maxValue);

        System.out.println("\nЗначения больше 20, умноженные на 100, отсортированные по возрастанию: ");
        arrayList.stream()
                .filter(x -> x > 20)
                .sorted(((o1, o2) -> o1.compareTo(o2)))
                .forEach(x -> System.out.print((x *= 100) + ", "));


        int max2 = arrayList.stream()
                .skip(5)
                .limit(10)
                .distinct()
                .max((o1, o2) -> o1.compareTo(o2)).get();
        System.out.println("\n\nПропустить 5 значений листа, задать лимит в 10 значений. Найти уникальные значения и определить среди них максимальное: " + max2);


        System.out.println("\nПропустить 5 значений листа, задать лимит в 10 значений. Каждое число умножить на 10, отсортировать по убыванию, вывести значения, прибавив 5");
        arrayList.stream()
                .skip(5)
                .limit(10)
                .sorted((o1, o2) -> o2.compareTo(o1))
                .forEach(x -> System.out.print((x *= 10) + ", ")) ;





    }
}
