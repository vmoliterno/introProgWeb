<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="activity1" scope="request"
             class="com.projects.intro_prog_web_29.Activity"></jsp:useBean>

<jsp:useBean id="activity2" scope="request"
             class="com.projects.intro_prog_web_29.Activity"></jsp:useBean>

<jsp:useBean id="activity3" scope="request"
             class="com.projects.intro_prog_web_29.Activity"></jsp:useBean>

<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Lexend' rel='stylesheet'>
    <link href='https://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
    <link href="stylesheets/activities.css" rel="stylesheet" type="text/css">
    <link href="stylesheets/global.css" rel="stylesheet" type="text/css">
    <title>Tum4World</title>
</head>

    <jsp:include page="header.jsp"></jsp:include>

<body>

<script>
    fetch("visits", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'body='+ encodeURIComponent("activities")
    })
</script>
    <h1 class="title">Attivita'</h1>
    <div class="content">
    <main>
        <p class="description"> La nostra associazione da molti anni porta avanti vari progetti di utilita' varia ecc ecc </p>
        <div class="activities-container">
        <section class="activity" id="1">
            <a href="getActivity?activityID=1">
                <img src="./images/placeholder.jpeg" alt="immagine progetto 1" height="150px" width="150px">
            </a>
            <h2><%=activity1.getTitle()%></h2>
            <p class="text"><%=activity1.getPreview()%></p>
        </section>

            <section class="activity" id="2">
                <a href="getActivity?activityID=2">
                    <img src="./images/placeholder.jpeg" alt="immagine progetto 1" height="150px" width="150px">
                </a>
                <h2><%=activity2.getTitle()%></h2>
                <p class="text"><%=activity2.getPreview()%></p>
            </section>

            <section class="activity" id="3">
                <a href="getActivity?activityID=3">
                    <img src="./images/placeholder.jpeg" alt="immagine progetto 3" height="150px" width="150px">
                </a>
                <h2><%=activity3.getTitle()%></h2>
                <p class="text"><%=activity3.getPreview()%></p>
            </section>
        </div>
    </main>
    </div>
</body>
<jsp:include page="footer.jsp"></jsp:include>

</html>
