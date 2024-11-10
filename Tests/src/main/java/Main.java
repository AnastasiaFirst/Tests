import java.util.Scanner;

public class Main {
    static final int TAX_6 = 6;
    static final int TAX_15 = 15;
    static final int PERCENT_100 = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        boolean isContinue = true;

        while (isContinue) {
            showMenu();

            String answer = scanner.nextLine();
            switch (answer) {
                case "end":
                    isContinue = false;
                    break;
                case "1":
                    System.out.println("Введите сумму дохода:");
                    earnings += Integer.parseInt(scanner.nextLine());
                    break;
                case "2":
                    System.out.println("Введите сумму расхода:");
                    spendings += Integer.parseInt(scanner.nextLine());
                    break;
                case "3":
                    calcAndShowTaxes(earnings, spendings);
                    break;
                default:
                    System.out.println("Я не понимаю такой команды!");
            }
        }
        System.out.println("Программа завершена!");
    }

    public static String calcAndShowTaxes(int earnings, int spendings) {
        int tax6 = calcTax6(earnings);
        int tax15 = calcTax15(earnings, spendings);
        String taxType = tax6 < tax15 ? "УСН доходы" : "УСН доходы минус расходы";
        int minTax = Math.min(tax6, tax15);
        int maxTax = Math.max(tax6, tax15);

        if (maxTax != minTax) {
            System.out.printf("Мы советуем Вам %s\n", taxType);
            System.out.printf("Ваш налог составит: %d рублей\n", minTax);
            System.out.printf("Налог на другой системе: %d рублей\n", maxTax);
            System.out.printf("Экономия: %d рублей\n", maxTax - minTax);
        } else {
            System.out.println("Выбирайте любую систему");
            System.out.printf("Ваш налог составит: %d рублей\n", minTax);
        }
        return taxType;
    }

    public static int calcTax15(int earnings, int spendings) {
        int tax = (earnings - spendings) * TAX_15 / PERCENT_100;
        return Math.max(tax, 0);
    }

    public static int calcTax6(int earnings) {
        return earnings * TAX_6 / PERCENT_100;
    }

    public static void showMenu() {
        System.out.println("Выберите операцию и введите её номер:\n" +
                "1. Добавить новый доход\n" +
                "2. Добавить новый расход\n" +
                "3. Выбрать систему налогообложения");
    }
}