Описание языка.

ASN.1 — это аббревиатура от Abstract Syntax Notation One, языка описания структурированной информации;
как правило, информация, предназначенная для передачи через какой-либо интерфейс или средство связи.
ASN.1 был стандартизирован на международном уровне. 
Он широко используется в спецификации протоколов связи.

---
Языковые токены.

1. Ключевые слова:

- BEGIN
- IMPLICIT
- TAGGED
- TAGS
- CLASS
- EXPORTS
- IMPORTS
- ENUMERATED
- SEQUENCE
- SEQUENCE OF
- CHOICE
- UNIQUE
- WITH SYNTAX
- OID
- DATA
- SIZE
- FROM
- END

2. Размерности:

- UTCTime
- UTF8String
- INTEGER
- NULL
- OPTIONAL
- BOOLEAN
- OCTET STRING

3. Служебные символы:

- ::=
- {
- '---'
- }
- '--'
- [
- ]
- ;
- ,
- .
- |
- &
- (
- )

---
Принципы построения языковых конструкций в файле.

- Пример:

```
DataReadyTaskRecord ::=	SEQUENCE {
    task-id	TaskID,						--- идентификатор задачи
    result	TaskResult					--- результат выполнения задачи
}

TaskResult ::= SEQUENCE {
    result ENUMERATED {
    data-not-ready (0),				--- данные не готовы, задача еще выполняется
    data-ready (1),				--- данные есть, задача выполнена
    data-not-found (2),				--- данных нет, задача выполнена
    error (3)					--- в процессе выполнения задачи произошла ошибка
    },
    report-records-number [0]	INTEGER (0 .. 999999999999) OPTIONAL,	--- для выполненной задачи - количество записей в отчете
    report-limit-exeeded  [1]	BOOLEAN OPTIONAL,	--- количество записей превысило лимит,заданный при создании задачи
    error-description [2] 	UTF8String (SIZE (1 .. 256)) OPTIONAL	--- краткое описание произошедшей ошибки, если обнаружена
}
```
- разбор конструкции:

  `DataReadyTaskRecord` - наименование объекта (класса) управляющей последовательности;
  `::=` - управляющий символ ("является");
  `SEQUENCE` - ключевое слово, означающее последовательность, представленную этим объектом (его поля);
  `{ }` - управляющие символы (открывают и закрывают последовательность);
  `task-id` - наименование поля (начинается со строчной буквы);
  `TaskID` - значение поля (начинается с прописной буквы, может быть ссылкой на значение или на другой объект управляющей последовательности);
---
Правила:

1. После объявления имени класса идет символ `::=` (является), затем следующие варианты ключевых слов:
 - SEQUENCE (последовательность)
 - CHOICE (выбор)
 - ENUMERATED (перечисление)

2. После одного из ключевых слов из п.1 идет блок кода, ограниченный `{...}`
   1. Внутри блока кода могут быть следующие конструкции:
       3.1 Объявление одной или нескольких переменных: `имя-переменной Класс` отделяемых друг от друга `,`
       3.2 Объявление перечислений: `имя-переменной (порядковый номер)` отделяемых друг от друга `,`
       3.3 Объявление примитивов:



