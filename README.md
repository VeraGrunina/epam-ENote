# epam-ENote
| **URL Path**  | Requests method | Result |
| ------------- | ------------- | ------------- |
| /user  | GET, PUT, DELETE  | получение, обновление, удаление своего пользователя | 
| /notebook  | POST  | создание блокнота |
| /notebooks  | GET  | получение всех своих блокнотов |
| /notebook/{notebookId}  | GET, PUT, DELETE  | получение, обновление, удаление своего блокнота по его id |
| /notebook/{notebookId}/note  | POST  | создание своей заметки в своём блокноте  |
| /notebook/{notebookId}/notes  | GET  | получение всех своих заметкок |
| /notebook/{notebookId}/note/{noteId}  | GET, PUT, DELETE  | получение, обновление, удаление своей заметки по её id |
| /tag  | POST  | создание тега |
| /tags  | GET  | получить все свои теги |
| /tag/{tagId}  | PUT, DELETE  | обновление (переименование), удаление тега по его id |
| /tag/{tagId}/notes  | GET, DELETE  | получение всех заметок с тегом, удаление тега из заметки по его id |
| /login  | GET, POST  | получить, отправить заполненную форму для входа |
| /reg  | GET, POST  | получить, отправить заполненную форму для регистрации |
|  |  | |
| **admin mode**  |  |  |
| /user/{userId}  | GET, PUT, DELETE  | получение, обновление, удаление пользователя |
| /user/{userId}/notebook  | POST  | создание блокнота |
| /user/{userId}/notebooks | Content Cell  | ------------- |
| /user/{userId}/notebooks  | GET  | получение всех своих блокнотов |
| /user/{userId}/notebook/{notebookId}  | GET, PUT, DELETE  | получение, обновление, удаление своего блокнота по его id |
| /user/{userId}/notebook/{notebookId}/note  | POST  | создание своей заметки в своём блокноте  |
| /user/{userId}/notebook/{notebookId}/notes  | GET  | получение всех своих заметкок |
| /user/{userId}/notebook/{notebookId}/note/{noteId}  | GET, PUT, DELETE  | получение, обновление, удаление своей заметки по её id |
| /user/{userId}/tag  | POST  | создание тега |
| /user/{userId}/tags  | GET  | получить все свои теги |
| /user/{userId}/tag/{tagId}  | PUT, DELETE  | обновление (переименование), удаление тега по его id |
| /user/{userId}/tag/{tagId}/notes  | GET, DELETE  | получение всех заметок с тегом, удаление тега из заметки по его id |
