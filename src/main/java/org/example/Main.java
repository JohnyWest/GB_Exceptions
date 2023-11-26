import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ваши данные в формате: Фамилия,Имя,Отчество ДатаРождения(через\".\") пол(m/f) телефон");
        System.out.println("Например: Иванов,Иван,Иванович 01.01.1970 m 89991199990");
        String personalData = in.nextLine();

    }
}