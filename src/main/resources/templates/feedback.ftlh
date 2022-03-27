<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${feedback.id}</title>
</head>
<body>
<h3>Отзыв - ${feedback.feedback}</h3>
<br>
<form method="post" action="/feedbacks/${feedback.id}/update">
    <label>
        Отзыв: <input name="feedback" value="${feedback.feedback}">
    </label>
    <input type="submit" value="Сохранить.+.">
</form>
</body>
</html>