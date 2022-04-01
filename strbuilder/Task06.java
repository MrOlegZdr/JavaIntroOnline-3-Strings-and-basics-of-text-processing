package by.jonline.pr03.strbuilder;

// Из данной строки получить новую, повторив каждый символ дважды

public class Task06 {

	public static void main(String[] args) {

		String text = "abcdefg";
		System.out.printf("Исходный текст:\n\"%s\"\n", text);
		System.out.printf("Результирующий текст, в котором удвоен каждый символ:\n\"%s\"\n", doubleText(text));

	}

	public static String doubleText(String text) {
		// Из строки text формирует новую, в которой каждый символ повторяется дважды

		StringBuilder textBuilder = new StringBuilder(text);

		for (int i = 0; i < textBuilder.length(); i += 2) {
			textBuilder.insert(i + 1, textBuilder.charAt(i));
		}

		return textBuilder.toString();
	}
}
