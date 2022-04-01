package by.jonline.pr03.strarray;

/* Найти количество цифр в строке
 */

public class Task03 {

	public static void main(String[] args) {

		String text = "Строка 123 с произвольным текстом u21, наличием цифр1 в 2345 ней";
		System.out.printf("В исходной строке:\n%s\n%d цифр", text, amountOfDigit(text));
	}

	public static int amountOfDigit(String text) {
		// Метод вычисляет количество цифр в текстовой строке

		char[] textChar = text.toCharArray();
		int result = 0;

		for (int i = 0; i < textChar.length; i++) {
			result += (Character.isDigit(textChar[i])) ? 1 : 0;
		}
		return result;
	}
}
