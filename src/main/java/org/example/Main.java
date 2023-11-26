import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ваши данные в формате: Фамилия,Имя,Отчество ДатаРождения(через\".\") пол(m/f) телефон");
        System.out.println("Например: Иванов,Иван,Иванович 01.01.1970 m 89991199990");
        String personalData = in.nextLine();
        BoxPersonalData boxPersonalData1 = new BoxPersonalData(personalData);

        if (boxPersonalData1.lenDataOK() == 0) {
            PersonBuilder person1 = new PersonBuilder();
            try {
                for (String data : boxPersonalData1.getPersonalData()) {
                    if (data.contains(".")) {
                        person1.setdOb(data);
                    }
                    else if (data.contains(",")) {
                        String[] nameCREDS = data.split(",");
                        person1.setName(nameCREDS[1]);
                        person1.setLastname(nameCREDS[0]);
                        person1.setFatherName(nameCREDS[2]);
                    }
                    else if (data.trim().equals("m") || data.trim().equals("f")) {
                        person1.setGender(data.trim());
                    }
                    else if (!(data.contains("m") && data.contains("f"))){
                        Long phone = Long.parseLong(data.trim());
                        person1.setNumber(phone);
                    }
                }
                Person p1 = person1.build();
                try (FileWriter writer = new FileWriter(p1.getLastname() + ".txt",true)){
                    writer.append(String.format("ФИО: %s %s %s; Дата рождения: %s; Пол: %s; Номер телефона: %d \n",
                            p1.getName(), p1.getLastname(), p1.getFatherName(), p1.getdOb(), p1.getGender().equals("m")? "м": "ж", p1.getNumber()));
                    System.out.println("Sucessfull!");
                }
                catch (IOException ee){
                    System.out.println(ee.getClass().getSimpleName());
                    System.out.println(ee.getStackTrace());
                }
            }
            catch (NumberFormatException e){
                System.out.println("Неверный формат номера телефона");
            }
            catch (Exception e){
                System.out.println("Произошла ошибка");
            }
        }
    }
}