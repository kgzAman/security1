<#import "common.ftlh" as c>
<@c.page>
<body>
<#if user?? && user.userRole="ROLE_ADMIN">
    <div class="move">
        <div class="action" style="margin:200px">
            <h1 style="text-align: center">Welcome ${user.surName} to Home Page </h1>
            <form action="/admin" method="get">
                <button type="submit" class="btn btn-primary btn-lg btn-block">Перейти к упровлению пользователями</button>
            </form>
        </div>
    </div>


    <#elseif user??>
        <h1 style="text-align: center">Welcome to Home Page </h1>
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