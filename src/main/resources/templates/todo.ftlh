<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Title</title>
    <style>
        [data-href] { cursor: pointer; }
    </style>
</head>
<body>
    <div class="toDo" style="width: 900px; margin-left: 20px">
        <table class="table table-bordered">
            <thead>
            <tr style="text-align: center">
                <th scope="col">Название</th>
                <th scope="col">Значение</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">Заголовок:</th>
                <td style="width: 600px;">${toDo.header}</td>
            </tr>
            <tr>
                <th scope="row">Описание:</th>
                <td>${toDo.description}</td>
            </tr>
            <tr>
                <th scope="row">Дата создания:</th>
                <td>${toDo.createdDate}</td>
            </tr>
            <tr>
                <th scope="row">Статус</th>
                <td>${toDo.status}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="move" style=" display:flex;margin-left: 20px; width: 900px">

        <#if toDo.status="NEW">
            <form action="/toDo/start/${toDo.id}" method="post">
                <div class="start">
                    <button class="btn btn-success">начать работу над задачей</button>
                </div>
            </form>
            <#elseif toDo.status="ON_POSSES">
                <form action="/toDo/done/${toDo.id}" method="post">
                    <div class="done">
                        <button class="btn btn-success">Завершить</button>
                    </div>
                </form>
            <#else>

        </#if>
        <div id="update" style="margin-left: auto">
            <div class="update">
                <button class="btn btn-success">редактировать</button>
            </div>
        </div>
        <div  style="margin-left: auto">
            <form action="/toDo/delete/${toDo.id}" method="post">
                <div class="delete">
                    <button class="btn btn-success">удалить</button>
                </div>
            </form>
        </div>
    </div>

    <div id="change" hidden>
        <form action="/toDo/update/${toDo.id}" method="post"  modelAttribute ="todo">
            <div class="form-group">
                <label id="head" for="formGroupExampleInput">Заголовок</label>
                <input type="text" class="form-control" id="formGroupExampleInput" name="header" placeholder="Введите заголовок">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Описание</label>
                <input type="text" class="form-control" id="formGroupExampleInput2" name="description" placeholder="Введите описание">
            </div>
            <form action="/toDo/update/${toDo.id}" method="post" modelAttribute ="todo">
                <button type="submit" class="btn btn-primary">изменить</button>
            </form>
            <button id="x" type="button" class="btn btn-primary">закрыть</button>
        </form>

    </div>

</body>
<script>
    let btn = document.getElementById("update");
    btn.addEventListener("click",function (e) {
        e.preventDefault();
        document.getElementById("change").hidden=false
        document.getElementById("head").focus();
        document.getElementById("x").addEventListener("click",function (e) {
            e.preventDefault()
            document.getElementById("change").hidden=true
        })
    })
</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>