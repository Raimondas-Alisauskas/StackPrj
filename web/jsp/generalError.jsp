<%@ page language="java" %>

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stack DB</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/style.css">
</head>

<body>
<div class="main">
    <div class="mid">

        <h1> OOOOps, it's seems that an error have been occurred... See some information, and go back to our webpage!</h1>
        <h2>Your error code is - <%= request.getAttribute("javax.servlet.error.status_code")%></h2><br>
        <div>
            <button type="button" class="button button--ghost button--ghost--green" onclick="history.back()">Go back where there is no errors! :)
            </button>
        </div>

    </div>
</div>

</p>

</body>

</html>
