package by.jonline.pr03.strbuilder;

/* Посчитать количество строчных (маленьких) и прописных (больших) букв в
 * веденной строке. Учитывать только английские буквы
 */

public class Task09 {

	public static void main(String[] args) {

		String text = " й Ssabc qwerty  Cde defg ffF sr Aasddsr";

		System.out.printf("Исходный текст:\n\"%s\"\n", text);
		System.out.printf("Количество строчных букв: %d\n", numberLetterCase(text, "lowerCase"));
		System.out.printf("Количество прописных букв: %d\n", numberLetterCase(text, "upperCase"));

	}

	public static int numberLetterCase(String text, String letterCase) {
		// Метод возвращает количество английских строчных букв в тексте text
		// Согласно ASCII английские буквы кодируются:
		// Прописные буквы: [65...90]
		// Строчные буквы: [97...122]

		int count = 0;

		switch (letterCase) {
		case "upperCase":
			for (int i = 0; i < text.length(); i++) {
				int codeChar = text.codePointAt(i);
				count += (codeChar >= 65 && codeChar <= 90) ? 1 : 0;
			}
			break;
		case "lowerCase":
			for (int i = 0; i < text.length(); i++) {
				int codeChar = text.codePointAt(i);
				count += (codeChar >= 97 && codeChar <= 122) ? 1 : 0;
			}
			break;
		}

		return count;
	}
}
