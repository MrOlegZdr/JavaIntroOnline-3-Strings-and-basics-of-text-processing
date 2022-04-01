package by.jonline.pr03.strbuilder;

/* Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
 * Например, если было введено "abc cde def", то должно быть выведено "abcdef".
 */

public class Task07 {

	public static void main(String[] args) {

		String text = "rabc cde defg fff sr aadbr";
		System.out.printf("Исходный текст:\n\"%s\"\n", text);
		System.out.printf("Результирующий текст, в котором удалены все пробелы и повторяющиеся символы:\n\"%s\"\n",
				deleteExtraSymbol(text));

	}

	public static String deleteExtraSymbol(String text) {
		// Метод удаляет из text все пробелы и повторяющиеся символы

		text = text.replaceAll(" ", ""); // Удаляем все пробелы
		StringBuilder textBuilder = new StringBuilder(text);

		int position = 0;

		while (position < textBuilder.length()) {
			char symbol = textBuilder.charAt(position);
			int temp = textBuilder.indexOf(Character.toString(symbol), position + 1);
			while (temp != -1) {
				textBuilder.deleteCharAt(temp);
				temp = textBuilder.indexOf(Character.toString(symbol), position + 1);
			}
			position++;
		}

		return textBuilder.toString();
	}
}
