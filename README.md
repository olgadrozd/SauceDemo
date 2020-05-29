1. Команда для обновления версии всех библиотек в проекте
mvn versions:use-latest-versions

её вывод:
[INFO] --- versions-maven-plugin:2.7:use-latest-versions (default-cli) @ SauceDemo ---
[INFO] Major version changes allowed


2. Запустить тесты используя mvn clean test команду и ее вывод 
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 13.905 sec


3. Использовать параметры для запуска конкретных тестов и методов 

Запуск 1 конкретного метода класса:
mvn clean test -Dtest=CheckoutTests#checkoutWithoutLastName
вывод:
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 12.735 sec

Запуск всех методов конкретного класса:
mvn clean test -Dtest=CheckoutTests
вывод:
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 52.355 sec


4. Создать альтернативный pom.xml и запустить из него mvn билд
mvn -f TestNG_Homework_13\pom.xml -Dtest=SumTests test
вывод:
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.895 sec

5. Пробросить параметр из mvn command line внутрь теста
mvn clean test -Dtest=SauceDemoTest#loginTest -DuserName=standard_user
вывод:
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 16.174 sec


