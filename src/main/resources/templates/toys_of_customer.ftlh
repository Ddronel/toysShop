<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ваши заказы</title>
</head>
<body>
<h1>Товары текущего покупателя</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Характеристика игрушки</th>
        <th>Цена</th>
        <th>Размер</th>
        <th>Действие</th>
    </tr>
    <#list toys as toy>
        <tr>
            <td>${toy.id}</td>
            <td>${toy.description}</td>
            <td>${toy.cost}</td>
            <td>${toy.size}</td>
            <td>
                <form method="post" action="/customers/${customerId}/toys/delete">
                    <input name="toyId" type="hidden" value="${toy.id}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </#list>
</table>
<h2>Могут быть интересны..</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Характеристика игрушки</th>
        <th>Цена</th>
        <th>Размер</th>
        <th>Действие</th>
    </tr>
    <#list unusedToys as toy>
        <tr>
            <td>${toy.id}</td>
            <td>${toy.description}</td>
            <td>${toy.cost}</td>
            <td>${toy.size}</td>
            <td>
                <form method="post" action="/customers/${customerId}/toys">
                    <input name="toyId" type="hidden" value="${toy.id}">
                    <input type="submit" value="Добавить">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>