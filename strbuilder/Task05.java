package by.jonline.pr03.strbuilder;

// Посчитать, сколько раз среди символов заданной строки встречается буква "a"

public class Task05 {

	public static void main(String[] args) {

		String text = "Temporary text with some different words";
		char symbol = 'o';
		
		System.out.printf("В исходном тексте:\n\"%s\"\n", text);
		System.out.printf("символ \'%c\' встречается %d раз", symbol, numberOfEntry(text, symbol));

	}

	public static int numberOfEntry(String text, char symbol) {
		// Метод возвращает количество вхождений символа symbol в строке text

		int count = 0;
		StringBuilder textBuilder = new StringBuilder(text);
		int position = textBuilder.indexOf(Character.toString(symbol));

		while (position != -1) {
			count++;
			textBuilder.deleteCharAt(position);
			position = textBuilder.indexOf(Character.toString(symbol));
		}

		return count;
	}
}
