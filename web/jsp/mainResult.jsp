<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Result" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
</head>
<jsp:useBean id="result1" class="models.Result"
             scope="request"></jsp:useBean>

<body>
<h1>Results</h1>
<div class="middle">
    <% List<Result> results = (ArrayList) request.getAttribute("results");
        for (Result result : results) { %>
    <div class="article">
        <div>
            <a href="#" name="article_name"><h2><%=result.getTitle()%>
            </h2></a>
        </div>
    </div>
    <% } %>

</div>
</body>
</html>