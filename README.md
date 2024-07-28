# Практическое задание - Spring data - проекции
Разработать приложение для учета сотрудников в компании с использованием Spring Data и провести практику работы с проекциями.

## Требования:

**Сущности:**

Создайте две сущности: Employee и Department. Employee должна содержать следующие поля: id (автоматически генерируемый идентификатор), firstName (имя сотрудника), lastName (фамилия сотрудника), position (должность), salary (заработная плата), department (ссылка на отдел, к которому принадлежит сотрудник).

Department должна содержать следующие поля: id (автоматически генерируемый идентификатор), name (название отдела).
***
**Репозитории:**

Создайте интерфейсы репозиториев для сущностей Employee и Department с использованием Spring Data.
***
**Проекции:***
Реализуйте проекции для сущности Employee: Создайте интерфейс EmployeeProjection с методами для получения следующей информации о сотруднике: getFullName() (полное имя сотрудника), getPosition() (должность сотрудника), getDepartmentName() (название отдела, к которому принадлежит сотрудник).
***
**REST-контроллер:**
Создайте REST-контроллер для обработки запросов, связанных с управлением сотрудниками и отделами.
***
**Сервис:**
Создайте сервисный класс для управления операциями CRUD (создание, чтение, обновление, удаление) сотрудников и отделов.