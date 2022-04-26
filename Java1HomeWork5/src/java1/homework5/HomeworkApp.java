package java1.homework5;

public class HomeworkApp {

    public static void main(String[] args) {
        Employees[] employees = {new Employees("Dzyuin Mikhail Veniaminovich", "engineer", "dmv@gmail.com", "+7(999)123-45-67", 3000, 32),
                                 new Employees("Ivanov Ivan Ivanovich", "developer", "ivanka@bk.ru", "+7(123)000-11-22", 1000,45),
                                 new Employees("Sidorov Petr Vladimirovich", "actor", "sidrpetr@example.com", "+7(000)777-33-44", 2000, 41),
                                 new Employees("Pushkin Aleksandr Sergeevich", "poet", "a_pushka@inbox.ru", "+7(321)781-76-00", 4000, 39),
                                 new Employees("Mendeleev Dmitryy Ivanovich", "chemist", "periodic_table@chemist.ru", "+7(555)555-77-12", 2500, 60)};

        for (int i = 0; i < employees.length ; i++) {
            if (employees[i].getAge() > 40){
                employees[i].printInfo();
            }
        }
    }
}
