# Warriors
<h1>Very epic battles
<h3>Task 1
  1. Был создан класс Warrior и его наследник Knight. Добавил интерфейс Fighter который описует поведение и добавляет метод hit().
  2. Был создан финализированный класс Battle со статическим методом fight(), который проводит бой между двумя воинами. Возвращает true если нападавший вышел из битвы победителем.
  3 Добавлены юнит тесты для класса Warrior и Battle

<h3>Task 2
  1. Был добавлен абстрактный класс Unit который имеет состояние health, attack и isAlive и публичные геттеры и протектед сеттеры. Поля все приватные для избежания случая где Юнит жив при отрицательном кол-во здоровья. Класс юнит сам изменяет состояние isAlive, поэтому доступ к ХП осуществляется через сеттер. Создан класс Army который содержит юнитов в очереди, реализован метод добавления определённого кол-ва юнитов через рефлексию. В будущем планирую сделать так чтобы этот класс сам отвечал за отсутствие мертвых юнитов в очереди. Не знаю точно правильно ли это...
  2 Добавлен метод fight между двумя армиями и добавлены тесты для этого метода.
  
<h3>Task 3
  1. Добавлен в метод doDamage в класс Unit который реализует логику получения урона для "этого" юнита.
  2. Добавлен класс Defender который получил новое полу defense. Этот класс расширят Warrior и переопределяет метод doDamage()
  3. Добавлены теста для класс Defender.
