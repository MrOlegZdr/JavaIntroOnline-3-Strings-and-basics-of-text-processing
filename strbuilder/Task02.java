package by.jonline.pr03.strbuilder;

// В строке после каждого символа 'a' вставить символ 'b'

public class Task02 {

	public static void main(String[] args) {

		String text = "          Test     text  with      different   spaces   ";
		StringBuilder textBuilder = new StringBuilder(text);

		char key = 'a';
		char addition = 'b';
		addCharAfter(textBuilder, key, addition);

		System.out.printf("В исходном тексте:\n\"%s\"\n", text);
		System.out.printf("после символа \'%c\' добавлен символ \'%c\'\n", key, addition);
		System.out.printf("Итоговый текст:\n\"%s\"\n", textBuilder);

	}

	public static void addCharAfter(StringBuilder text, char key, char add) {
		// Метод добавляет в тексте text после символа key символ add

		int position = text.indexOf(Character.toString(key));
		if (position != -1) {
			while (position != -1 && position < text.length()) {
				text.insert(position + 1, add);
				position = text.indexOf(Character.toString(key), position + 1);

			}

		}
	}
}
