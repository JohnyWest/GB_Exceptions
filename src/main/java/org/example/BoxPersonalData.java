public class BoxPersonalData {
    String[] personalData;
    public String[] getPersonalData() {
        return personalData;
    }
    public BoxPersonalData(String personalData) {
        this.personalData = personalData.split(" ");
    }
    public int lenDataOK() {
        if (personalData.length != 4) {
            System.out.println("Введено меньше строк, чем необходимо");
            return -1;
        }
        return 0;
    }
}
