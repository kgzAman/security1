<#import "common.ftlh" as c>
<@c.page>
    <form action="/toDo/creat" method="post"  modelAttribute ="todo">
        <div class="form-group">
            <label for="formGroupExampleInput">Заголовок</label>
            <input type="text" class="form-control" id="formGroupExampleInput" name="header" placeholder="Введите заголовок">
        </div>
        <div class="form-group">
            <label for="formGroupExampleInput2">Описание</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" name="description" placeholder="Введите описание">
        </div>
        <button type="submit" class="btn btn-primary">создать</button>
    </form>
</@c.page>