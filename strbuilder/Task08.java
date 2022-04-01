package by.jonline.pr03.strbuilder;

/* Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его
 * на экран. Случай, когда самых длинных слов может быть несколько, не обрабатывать.
 */

public class Task08 {

	public static void main(String[] args) {

		String text = "  ssabc qwerty  cde defg fff sr aasddsr";

		System.out.printf("Исходный текст:\n\"%s\"\n", text);
		System.out.printf("Самое длинное слово:\n\"%s\"\n", longestWord(text));

	}

	public static String longestWord(String text) {
		// Метод возвращает слово, отделенное пробелом в тексте text, следующее за
		// позицией position

		String[] wordArray = text.split(" ");
		String word = wordArray[0];
		int maxLength = wordArray[0].length();

		for (int i = 1; i < wordArray.length; i++) {
			if (wordArray[i].length() > maxLength) {
				maxLength = wordArray[i].length();
				word = wordArray[i];
			}
		}

		return word;
	}
}
