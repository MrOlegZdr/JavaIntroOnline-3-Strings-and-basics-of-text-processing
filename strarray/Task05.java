package by.jonline.pr03.strarray;

import java.util.Arrays;

/* Удалить в строке все лишние пробелы, т.е. серии подряд идущих пробелов заменить 
 * на одиночные пробелы. Крайние пробелы в строке удалить
 */

public class Task05 {

	public static void main(String[] args) {

		String text = "        Test     text  with      different   spaces   ";

		System.out.printf("Исходный текст:\n%s\n", text);
		System.out.println("Результирующий текст без лишних пробелов:");
		System.out.println(deleteRedundantSpace(text));
	}

	public static char[] deleteRedundantSpace(String text) {
		// Метод удаляет лишние пробелы в строке text

		char[] textChar = text.toCharArray();
		char[] result = new char[textChar.length];

		int position = 0;
		int textPosition = 0; // Позиция начала фрагмента текста
		int spacePosition = 0; // Позиция пробела
		int resultPosition = -1; // Счетчик позиций в результирующем массиве
		while (position < textChar.length) {
			textPosition = nextNonSpace(textChar, position); // Находим номер позиции начала текста
			if (textPosition != -1) {
				if (textPosition != 0 && resultPosition != -1) {
					// Вставляем пробел, если начинается текст, и результирующий массив уже частично
					// наполнен
					// Пробел не вставим в начале результирующего текста
					resultPosition++;
					result[resultPosition] = ' ';
				}
				spacePosition = nextSpace(textChar, textPosition);
				if (spacePosition != -1) {
					// Если нашли пробел, то существующее "слово" вставляем в результирующий массив
					for (int i = textPosition; i < spacePosition; i++) {
						resultPosition++;
						result[resultPosition] = textChar[i];
					}
					position = spacePosition;
				} else {
					// Не нашли пробел, но при этом было найдено начало "текста", то копируем все в
					// результирующий массив
					for (int i = textPosition; i < textChar.length; i++) {
						resultPosition++;
						result[resultPosition] = textChar[i];
					}
					position = textChar.length;
				}
			} else {
				// Если текст не найден, то уменьшаем длину массива до последнего элемента
				if (resultPosition < textChar.length) {
					result = Arrays.copyOf(result, resultPosition + 1);
				}
				position = textChar.length;
			}

		}
		return result;
	}

	public static int nextNonSpace(char[] text, int startPosition) {
		// Метод находит номер позиции элемента, отличного от пробела в массиве text,
		// начиная с позиции startPosition. Если такой позиции нет, возвращает -1

		int position = startPosition;
		while (position < text.length) {
			if (!Character.isSpaceChar(text[position])) {
				return position;
			} else {
				position++;
			}
		}
		return -1;
	}

	public static int nextSpace(char[] text, int startPosition) {
		// Метод находит номер позиции пробела в массиве text, начиная с
		// позиции startPosition. Если такой позиции нет, возвращает -1

		int position = startPosition;
		while (position < text.length) {
			if (Character.isSpaceChar(text[position])) {
				return position;
			} else {
				position++;
			}
		}
		return -1;
	}

}
