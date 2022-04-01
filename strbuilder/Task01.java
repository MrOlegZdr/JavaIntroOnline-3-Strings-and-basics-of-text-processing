package by.jonline.pr03.strbuilder;

// Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем

public class Task01 {

	public static void main(String[] args) {

		String text = "          Test     text  with      different   spaces   ";

		System.out.println("Максимальное количество подряд идущих пробелов в тексте:");
		System.out.printf("\"%s\"\nравно %d", text, maxNumberOfKeyInARow(text, ' '));
	}

	public static int maxNumberOfKeyInARow(String text, char key) {
		// Метод выводит значение наибольшего количества подряд идущих key
		// в тексте text

		int maxKeyCount = 0; // Максимальное количество подряд идущих key
		int position = text.indexOf(key);

		if (position != -1) {
			while (position != -1 && position <= text.lastIndexOf(key)) {
				boolean isKey = true;
				int keyCount = 1; // Количество подряд идущих key
				while (isKey) {
					position++;
					if (position < text.length() && text.charAt(position) == key) {
						keyCount++;
					} else {
						isKey = false;
					}
				}
				maxKeyCount = (keyCount > maxKeyCount) ? keyCount : maxKeyCount;
				position = text.indexOf(key, position);
			}
		} else {
			return 0;
		}

		return maxKeyCount;
	}

}
