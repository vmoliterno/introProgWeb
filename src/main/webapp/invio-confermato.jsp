<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 06/05/23
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base>
    <script>
        fetch("visits", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: 'body='+ encodeURIComponent("invio-confermato")
        })
    </script>
    <link href="stylesheets/invio-confermato.css" rel="stylesheet" type="text/css">

<div class="text-image">
    <img src="./images/placeholder.jpeg" class="image">
    <div class="text">
        <h1>Grazie per il tuo messaggio, ti risponderemo
            a breve</h1>
    </div>
</div>

</t:base>