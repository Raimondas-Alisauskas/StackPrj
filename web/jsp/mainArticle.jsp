<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Result" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Article" %>
<html>
<head>
</head>
<jsp:useBean id="article" class="models.Article"
             scope="request"></jsp:useBean>

<body>
<h1>Article description</h1>
<div class="middle">
    <% Article article1 = (Article) request.getAttribute("article");%>
    <div class="article">
        <div>
            <p>Article title: <%=article1.getTitle()%></p>
            <p>View count: <%=article1.getCreationDate()%></p>
            <p></p>
        </div>
    </div>


</div>
</body>
</html>