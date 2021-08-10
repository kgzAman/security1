<#--<#import "/spring.ftl" as spring>-->
<#--<#import "main.ftlh" as main>-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div>
    <form action="/auth/register" method="post">
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Имя:</p>
                <input id="nam" type="text" name="userName" placeholder="ваше имя">
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Имя:</p>
                <input id="nam" type="text" name="surName" placeholder="ваше Фамиллию">
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Адрес почты:</p>
                <input type="text" name="email" placeholder="ваш адрес почты">
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Пароль:</p>
                <input type="text" name="password" placeholder="пароль" value="">
            </label>
        </div>
        <div>
            <button type="submit" class="btn btn-outline-success my-2 my-sm-0"
                    style="background: #343a40;color: #f8fafb">Регистрация
            </button>
        </div>
    </form>
</div>
</body>
<script>
</script>
</html>