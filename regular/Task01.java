package by.jonline.pr03.regular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять
 * с текстом три различных операции: отсортировать абзацы по количеству предложений;
 * в каждом предложении отсортировать слова по длине; отсортировать лексемы в
 * предложении по убыванию количества вхождений заданного символа, а в случае
 * равенства - по алфавиту
 */

public class Task01 {

	public static void main(String[] args) {

		String text = "\tThis book is about a powerful tool called regular expressions. It teaches you how to use "
				+ "regular expressions to solve problems and get the most out of tools and languages that provide them.\n"
				+ "\tRegular expressions are available in many types of tools. But their power is most fully exposed "
				+ "when available as part of a programming language. Examples include Java and JScript, Visual Basic "
				+ "and VBScript, JavaScript and ECMAScript, C++, C# and Python. In fact, regular expressions are the "
				+ "very heart of many programs written in some of these languages.\n"
				+ "\tThere's a good reason that regular expressions are found in so many diverse languages and applications: "
				+ "they are extremely powerful. At a low level, a regular expression describes a chunk of text.\n"
				+ "\tYou might use it to verify a user's input, or perhaps to sift through large amounts of data.\n"
				+ "\tOn a higher level, regular expressions allow you to master your data. Control it. "
				+ "Put it to work for you. To master regular expressions is to master your data.";

		char key = 'a'; // Искомый символ в лексемах
		System.out.println("Отсортированные абзацы по количеству предложений:");
		textSortByParagraphSentenceNumber(text);
		System.out.println("Отсортированные слова в предложениях по их длине:");
		textSortWordsInSentenceByLength(text);
		System.out.printf("Отсортированные лексемы в предложениях по убыванию количества вхождений символа \'%c\':\n",
				key);
		textSortWordsInSentenceByDecreaseSymbolCount(text, key);
	}

	public static void textSortByParagraphSentenceNumber(String text) {
		// Метод сортирует абзацы текста text по количеству предложений

		String[] paragraph = text.split("\\n"); // Массив абзацев
		Pattern sentence = Pattern.compile("[.!?]"); // Разделители предложений
		Matcher sMatcher;

		// Коллекция абзацев и количества предложений в них
		TreeMap<String, Integer> textParagraph = new TreeMap<String, Integer>();

		// Наполнение коллекции
		for (int i = 0; i < paragraph.length; i++) {
			sMatcher = sentence.matcher(paragraph[i]);
			int count = 0;
			while (sMatcher.find()) {
				count++;
			}
			textParagraph.put(paragraph[i], count);
		}

		// Список, который будет сортироваться по значению (количество предложений)
		List<Map.Entry<String, Integer>> paragraphList = new ArrayList<Map.Entry<String, Integer>>(
				textParagraph.entrySet());
		Collections.sort(paragraphList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> val1, Map.Entry<String, Integer> val2) {
				return val1.getValue() - val2.getValue();
			}
		});

		for (Map.Entry<String, Integer> pL : paragraphList) {
			System.out.println(pL.getValue() + ": " + pL.getKey());
		}
	}

	public static void textSortWordsInSentenceByLength(String text) {
		// Метод сортирует слова в предложениях по их длине

		String[] sentence = text.replaceAll("[\\n\\t\\r]", "").split("[.!?]");

		// Массив слов в предложении
		List<String> words = new ArrayList<String>();
		for (String tS : sentence) {
			Collections.addAll(words, tS.trim().split("\\s*([ ,:;-])\\s*"));
			words.sort(new Comparator<String>() {
				@Override
				public int compare(String wordA, String wordB) {
					return wordA.length() - wordB.length();
				}
			});
			System.out.println(words);
			words.clear();
		}

	}

	public static void textSortWordsInSentenceByDecreaseSymbolCount(String text, char symbol) {
		// Метод сортирует лексемы в предложениях текста text по убыванию количества
		// вхождений
		// заданного символа symbol, а в случае равенства - по алфавиту

		String[] sentence = text.replaceAll("[\\n\\t\\r]", "").split("[.!?]");

		// Массив слов в предложении
		List<String> words = new ArrayList<String>();
		for (String tS : sentence) {
			Collections.addAll(words, tS.trim().split("\\s*([ ,:;-])\\s*"));
			words.sort(new Comparator<String>() {
				@Override
				public int compare(String wordA, String wordB) {

					return (wordA.split(Character.toString(symbol), -1).length - 1)
							// количество символов symbol в строке wordA
							- (wordB.split(Character.toString(symbol), -1).length - 1);
					// количество символов symbol в строке wordB
				}
			}.reversed().thenComparing(Comparator.naturalOrder()));

			System.out.println(words);
			words.clear();

		}
	}
}
