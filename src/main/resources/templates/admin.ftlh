<#import "common.ftlh" as c>
<@c.page>
<div class="action_of_admin">

<form action="/admin/getUser" method="post">
    <label>
        <input type="text" name="email" placeholder="enter user email">
    </label>
    <button class="btn btn-primary" type="submit">поск</button>
</form>

<form action="/admin/getAllUsers" method="GET">
    <button class="btn btn-primary" type="submit">показать всех</button>
</form>
</div>
</@c.page>