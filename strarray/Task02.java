package by.jonline.pr03.strarray;

/* Замените в строке все вхождения word на letter
 */

public class Task02 {

	public static void main(String[] args) {

		String text = "New World - is the word in hole Word, word, word, word. Smile";
		String key = "word";
		String replace = "letter";

		System.out.printf("Исходная строка:\n%s\n", text);
		System.out.printf("Полученная строка, в которой %s заменено на %s:\n", key, replace);
		System.out.print(replaceWord(text, key, replace));

	}

	public static char[] replaceWord(String inputText, String keyWord, String replacement) {
		// Метод заменяет в исходном тексте inputText искомое выражение keyWord на
		// выражение replacement
		char[] textChar = inputText.toCharArray();
		char[] key = keyWord.toCharArray();
		char[] replace = replacement.toCharArray();

		int numberOfReplace = numberOfEntry(inputText, keyWord); // Количество необходимых замен
		int difference; // Разница длин между искомым и заменяемым выражением
		difference = replace.length - key.length;

		int resultLength; // Длина итоговой строки (возвращаемого массива)
		resultLength = textChar.length + difference * numberOfReplace;
		char[] result = new char[resultLength]; // Итоговая строка (массив)

		if (numberOfReplace > 0) {
			int startPosition = 0; // Начальная позиция для замены
			int currentPosition = 0; // Текущая позиция элемента массива
			int countReplace = 0; // Количество произведенных замен

			while (currentPosition < textChar.length) {
				startPosition = findNext(textChar, key, currentPosition);
				if (startPosition != -1) {
					// Запись неизменяемого текста в результирующий текст
					for (int i = currentPosition; i < startPosition; i++) {
						result[i + countReplace * difference] = textChar[i];
					}
					// Запись замен в результирующий текст
					for (int i = startPosition; i < startPosition + replace.length; i++) {
						result[i + countReplace * difference] = replace[i - startPosition];
					}
					countReplace++; // Увеличение счетчика произведенных замен
					currentPosition = startPosition + key.length;
				} else { // Если произвели все замены
					if (currentPosition < textChar.length) {
						// Запись неизменяемого текста в конец результирующий текст
						for (int i = currentPosition; i < textChar.length; i++) {
							result[i + countReplace * difference] = textChar[i];
						}
						currentPosition = textChar.length; // Дошли до конца текста
					}
				}
			}
		} else { // В тексте не найдено нужных замен
			for (int i = 0; i < resultLength; i++) {
				result[i] = textChar[i];
			}
		}

		return result;
	}

	public static int numberOfEntry(String inputText, String keyWord) {
		// Метод находит количество вхождений keyWord в inputText
		char[] textChar = inputText.toCharArray();
		char[] key = keyWord.toCharArray();
		int number = 0;

		int i = 0;
		while (i < textChar.length) {
			int j = 0;
			while (j < key.length) {
				// Проверяем, равна ли последовательность букв исходному слову
				if (textChar[i + j] == key[j] && (i + key.length <= textChar.length)) {
					j++;
				} else {
					i += j;
					break;
				}
				// Если мы "досчитали" до последней буквы keyWord, то значит, есть вхождение
				if (j == key.length) {
					i += j - 1; // Смещаем счетчик символов на длину ключа, но отнимаем еще 1,
								// т.к. после окончания цикла мы снова увеличим счетчик на 1
					number++; // Найдено 1 вхождение
				}
			}
			i++;
		}

		return number;
	}

	public static int findNext(char[] text, char[] key, int startPosition) {
		// Метод находит позицию первого полного вхождения массива key в массиве text,
		// начиная с позиции startPosition
		// Если такого вхождения нет, то возвращает -1
		if (startPosition >= 0 && (startPosition + key.length <= text.length)) {
			int i = startPosition;
			while (i < text.length) {
				int j = 0;
				while (j < key.length) {
					if (text[i + j] == key[j]) {
						j++;
					} else {
						i += j;
						break;
					}
					if (j == key.length) {
						return i;
					}
				}
				i++;
			}
			return -1; // Возвращаем -1, т.к. перебрали весь массив, и до этого шага не вышли
		} else {
			return -1;
		}
	}
}
