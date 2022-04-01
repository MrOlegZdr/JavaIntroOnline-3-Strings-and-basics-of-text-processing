package by.jonline.pr03.strbuilder;

/* Строка X состоит из нескольких предложений, каждое из которых заканчивается точкой,
 * восклицательным или вопросительным знаком. Определить количество предложений в
 * строке X
 */

public class Task10 {

	public static void main(String[] args) {

		String text = " ! First sentence!? Second... Third?!   ";

		System.out.printf("Исходный текст:\n\"%s\"\n", text);
		System.out.printf("Количество предложений: %d\n", numberOfSentence(text));

	}

	public static int numberOfSentence(String text) {
		// Метод возвращает количество предложений, которые заканчиваются знаками:
		// точка, восклицательный знак, вопросительный знак

		int count = 0;

		text = text.replace('.', '!');
		text = text.replace('?', '!');

		StringBuilder textBuilder = new StringBuilder(text);

		int position = textBuilder.indexOf("!");

		// Удаляем дублированные "!"
		while (position != -1) {
			while (textBuilder.indexOf("!", position + 1) == position + 1) {
				textBuilder.deleteCharAt(position + 1);
			}
			position = textBuilder.indexOf("!", position + 1);
		}

		// Удаляем первый существующий знак, если он есть
		if (textBuilder.indexOf("!") == 0) {
			textBuilder.deleteCharAt(0);
		}

		// Все, что не заканчивается на "!" удаляем (т.к. по условиям, предложение
		// должно заканчиваться знаком препинания)
		if (textBuilder.lastIndexOf("!") != textBuilder.length() - 1) {
			textBuilder.delete(textBuilder.lastIndexOf("!"), textBuilder.length());
		}

		count = textBuilder.toString().split("!").length;

		return count;
	}
}
