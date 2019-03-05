<%@ page import="DTO.TopicDTO" %>
<%@ page import="utils.ErrorType" %>
<%@ page import="static utils.ErrorType.NO_CONNECTION_TO_DATABASE" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stack DB</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <% TopicDTO topicDTO = (TopicDTO) request.getAttribute("topicDTO"); %>
</head>
<body>
<div class="main">
    <div class="mid">
        <% switch (topicDTO.dbConnectionDTO.errorType){
            case  NO_CONNECTION_TO_DATABASE:%>
        <h1> OOOOps, it's seems that you have no connection to database. Please check it</h1>
        <%break;}%>

    </div>
</div>
</body>
</html>
