<#import "common.ftlh" as c>
<@c.page>
<body>
<#if user?? && user.userRole="ROLE_ADMIN">
    <div class="move">
        <div class="action" style="margin:200px">
            <h1 style="text-align: center">${user.surName } Welcome to Home Page </h1>
            <form action="/admin" method="get">
                <button type="submit" class="btn btn-primary btn-lg btn-block">Перейти к упровлению пользователями</button>
            </form>
        </div>
    </div>
    <#elseif user??>
        <h1 style="text-align: center">${user.surName} Welcome to Home Page </h1>
        <div class="action" style="margin:20px 200px">
                <form action="/toDo/creat" method="get">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Создать задачу</button>
                </form>
        </div>

        <#if todos??>
                <table class="table table-bordered">
                    <thead class="thead-light">
                    <tr>
                        <th>Заголовок</th>
                        <th>Описание</th>
                        <th>Дата создания</th>
                        <th>Статус</th>
                    </tr>
                    </thead>

                    <#list todos as todo>
                        <tbody class="tbody-dark">
                             <tr data-href onclick="window.location='/toDo/${todo.id}'">
                                <td>${todo.header}</td>
                                <td>${todo.description}</td>
                                <td>${todo.createdDate}</td>
                                <td>${todo.status}</td>
                            </tr>
                        </tbody>
                    </#list>
                </table>
        </#if>
    <#else>
    <h1 style="text-align: center">Welcome to Home Page </h1>
    <div class="move">
        <div class="action" style="margin:200px">
            <form action="/auth/login" method="post" style="margin-bottom:20px">
                <button type="submit" class="btn btn-primary btn-lg btn-block">Войти</button>
            </form>
            <form action="/auth/register" method="get">
                <button type="submit" class="btn btn-primary btn-lg btn-block">Регистрация</button>
            </form>
        </div>
    </div>
</#if>
</body>
</@c.page>