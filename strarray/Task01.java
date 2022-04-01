package by.jonline.pr03.strarray;

/* Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class Task01 {

	public static void main(String[] args) {

		String[] arrayOfName = { "nameOne", "NameTwo", "nameThreeName", "TTTT", "namelow" };

		for (int i = 0; i < arrayOfName.length; i++) {
			System.out.print(convertName(arrayOfName[i]));
			System.out.printf(";\t");
		}

	}

	public static char[] convertName(String name) {

		char[] nameArray = name.toCharArray();

		int numberUpperCase = 0;

		for (int i = 0; i < nameArray.length; i++) {
			numberUpperCase += Character.isUpperCase(nameArray[i]) ? 1 : 0;
		}
		numberUpperCase = Character.isUpperCase(nameArray[0]) ? numberUpperCase - 1 : numberUpperCase;
		// Если слово начинается с большой буквы, то количество больших букв уменьшаем
		// на 1, т.к. перед первым символом не надо ставить знак "_"
		char[] resultArray = new char[nameArray.length + numberUpperCase];
		int j = 0;
		for (int i = 0; i < nameArray.length; i++) {
			if (Character.isLowerCase(nameArray[i])) {
				resultArray[i + j] = nameArray[i];
			} else if (i != 0 && Character.isUpperCase(nameArray[i])) {
				resultArray[i + j] = '_';
				j++;
				resultArray[i + j] = Character.toLowerCase(nameArray[i]);
			} else if (i == 0 && Character.isUpperCase(nameArray[i])) {
				resultArray[i + j] = Character.toLowerCase(nameArray[i]);
			}
		}
		return resultArray;
	}
}
