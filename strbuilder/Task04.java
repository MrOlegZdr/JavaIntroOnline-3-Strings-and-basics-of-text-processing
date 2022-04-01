package by.jonline.pr03.strbuilder;

/* С помощью функции копирования и операции конкатенации составить из
 * частей слова "информатика" слово "торт"
 */

public class Task04 {

	public static void main(String[] args) {

		String word = "информатика";
	
		System.out.println(createWord(word));
	}

	public static String createWord(String word) {

		char[] wordArray = word.toCharArray();
		String result = "";

		result = result.concat(String.copyValueOf(wordArray, 7, 1)); // т
		result = result.concat(String.copyValueOf(wordArray, 3, 1)); // о
		result = result.concat(String.copyValueOf(wordArray, 4, 1)); // р
		result = result.concat(String.copyValueOf(wordArray, 7, 1)); // т
		
		return result;
	}
}
