<#import "common.ftlh" as c>
<@c.page>
        <table class="table table-bordered table-hover">
            <thead class="thead-light">
            <tr>
                <th>Имя</th>
                <th>фамилия</th>
                <th>логин</th>
                <th>статус</th>
                <th>роль</th>
                <th>действие</th>
            </tr>
            </thead>
            <tbody class="tbody-dark">
            <tr>
                <td>${user.userName}</td>
                <td>${user.surName}</td>
                <td>${user.email}</td>
                <td>${user.status}</td>
                <td>${user.userRole}</td>
                    <#if user.userRole!="ROLE_ADMIN">
                <td style="display: flex;justify-content: space-around">
                    <form action="/admin/delete/${user.id}" method="post">
                        <label>
                            <input type="text" name="id" value="${user.id}" hidden>
                        </label>
                        <button class="btn btn-primary" type="submit">Удалить</button>
                    </form>
                        <#if user.status!="BANNED">
                        <form action="/admin/ban/${user.id}" method="post">
                            <button class="btn btn-primary" type="submit">Забанить</button>
                        </form>
                        <#else>
                            <form action="/admin/active/${user.id}" method="post">
                                <button class="btn btn-primary" type="submit">Разбанить</button>
                            </form>
                        </#if>
                    </#if>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</@c.page>
