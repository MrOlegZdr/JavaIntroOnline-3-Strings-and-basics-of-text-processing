package by.jonline.pr03.strbuilder;

//Проверить, является ли заданная строка палиндромом

public class Task03 {

	public static void main(String[] args) {

//		String text = "          Test     text  with      different   spaces   ";
		String text = "wertrewwertrew";
		StringBuilder textBuilder = new StringBuilder(text);

		System.out.printf("Исходная строка:\n\"%s\"\n", textBuilder);
		if (!isPalindrome(textBuilder)) {
			System.out.print("не ");
		}
		System.out.println("является палиндромом");
	}

	public static boolean isPalindrome(StringBuilder text) {

		if (text.toString().contentEquals(text.reverse())) {
			return true;
		} else {
			return false;
		}
	}

}
