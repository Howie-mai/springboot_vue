<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table border="1">
        <#if users.users ??&& (users.users?size>0)>
            <#list users.users as user>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.address}</td>
                    <#list user.favorite as fvo>
                        <td>${fvo}</td>
                    </#list>
                </tr>
            </#list>
        </#if>
    </table>
</body>
</html>