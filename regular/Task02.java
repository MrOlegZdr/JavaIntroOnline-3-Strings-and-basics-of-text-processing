package by.jonline.pr03.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Дана строка, содержащая следующий текст (xml-документ):
 	<notes>
		<note id = "1">
			<to>Вася</to>
			<from>Света</from>
			<heading>Напоминание</heading>
			<body>Позвони мне завтра!</body>
		</note>
		<note id = "2">
			<to>Петя</to>
			<from>Маша</from>
			<heading>Важное напоминание</heading>
			<body/>
		</note>
	</notes>
	Напишите анализатор, позволяющий последовательно возвращать содержимое узлов
	xml-документа и его тип (открывающий тег, закрывающий тег, содержимое тега,
	тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
	нельзя.
 */

public class Task02 {

	public static void main(String[] args) {

		String xmlDoc = "<notes>\n"
				+ "<note id = \"1\">\n"
				+ "<to>Вася</to>\n"
				+ "<from>Света</from>\n"
				+ "<heading>Напоминание</heading>\n"
				+ "<body>Позвони мне завтра!</body>\n"
				+ "</note>\n"
				+ "<note id = \"2\">\n"
				+ "<to>Петя</to>\n"
				+ "<from>Маша</from>\n"
				+ "<heading>Важное напоминание</heading>\n"
				+ "<body/>\n"
				+ "</note>\n"
				+ "</notes>";

		xmlAnalizer(xmlDoc);
	}

	public static void xmlAnalizer(String text) {
		// Анализатор, позволяющий последовательно возвращать содержимое узлов
		// xml-документа и его тип (открывающий тег, закрывающий тег,
		// содержимое тега, тег без тела).

		String[] textArray = text.split("\\n");

		Pattern openTag = Pattern.compile("<[a-zA-Z]+>"); // любой символ в названии тега, кроме >: <[^>]*>
		Pattern openTagWAttr = Pattern.compile("<([a-zA-Z]+) ([\\w\\p{Punct} ]+)>");
		Pattern body = Pattern.compile(">[\\wа-яА-Я \\p{Punct}]+<");		
		Pattern closeTag = Pattern.compile("</[a-zA-Z]+>");
		Pattern emptyTag = Pattern.compile("<[a-zA-Z]+/>");
		Matcher sMatcher;

		for (String sT : textArray) {
			sMatcher = openTag.matcher(sT);
			if (sMatcher.find()) {
				System.out.printf("Открывающий тег: %s\n", sMatcher.group());
			}
			sMatcher = openTagWAttr.matcher(sT);
			if (sMatcher.find()) {
				System.out.printf("Открывающий тег с аттрибутами: %s\n", sMatcher.group());
			}
			sMatcher = body.matcher(sT);
			if (sMatcher.find()) {
				System.out.printf("Содержимое тега: %s\n", sMatcher.group().replaceAll(">|<", ""));
			}
			sMatcher = closeTag.matcher(sT);
			if (sMatcher.find()) {
				System.out.printf("Закрывающий тег: %s\n", sMatcher.group());
			}
			sMatcher = emptyTag.matcher(sT);
			if (sMatcher.find()) {
				System.out.printf("Тег без тела: %s\n", sMatcher.group());
			}

		}

	}
}
