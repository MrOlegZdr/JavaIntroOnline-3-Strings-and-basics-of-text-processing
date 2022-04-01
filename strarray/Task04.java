package by.jonline.pr03.strarray;

/* Найти количество чисел в строке
 */

public class Task04 {

	public static void main(String[] args) {

		String text = "Строка 123 с произвольным текстом ц21, наличием цифр1 и чисел в 2345 ней";
		System.out.printf("В исходной строке:\n\"%s\"\n%d чисел\"", text, amountOfNumber(text));

	}

	public static int amountOfNumber(String text) {
		// Метод вычисляет количество чисел в текстовой строке

		char[] textChar = text.toCharArray();
		int result = 0;

		int currentPosition = 0;
		while (currentPosition < textChar.length) {
			if (Character.isDigit(textChar[currentPosition])) {
				result++;
				int i = currentPosition + 1;
				while (Character.isDigit(textChar[i])) {
					i++;
				}
				currentPosition = i;
			} else {
				currentPosition++;
			}
		}
		return result;
	}
}
