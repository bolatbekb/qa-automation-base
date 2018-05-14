# HOW TO

**Properties:**

`HOST_UI` - URL for your tests

`SUITE` - Group of tests

**You can run tests via IDEA or Maven, but we will consider Maven:**

`$ mvn clean test -D HOST_UI=http://vk.com -D SUITE=regress-front`

**After finish, You can generate Allure report:**  

`$ allure serve target/allure-results`