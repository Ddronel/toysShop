<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Отзывы</title>
</head>
<body>
<h1>Добавление отзыва</h1>
<form method="post" action="/feedbacks">
    <label>Отзыв:
        <input name="feedback" placeholder="Ваш отзыв..">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Отзыв</th>
        <th>Удалить</th>
        <th>Действия</th>
    </tr>
    <#list feedbacks as feedback>
        <tr>
            <td>${feedback.id}</td>
            <td>${feedback.feedback}</td>
            <td>
                <form method="post" action="/feedbacks/${feedback.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>
                <a href="/feedbacks/${feedback.id}">Изменить..</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
