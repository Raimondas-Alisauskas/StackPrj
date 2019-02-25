<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Article" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
</head>
<%--<jsp:useBean id="article" class="models.Article"--%>
<%--scope="request"></jsp:useBean>--%>

<body>
<%--<% Article article1 = (Article) request.getAttribute("article");%>--%>
<% ArrayList<Article> articles = (ArrayList) request.getAttribute("article");%>
<h1>Article description</h1>
<p>Article title: <%=articles.get(0).getTitle()%>
</p>
<div class="middle">
    <%for (Article article2 : articles) { %>

    <div class="example">
        <div>
            <%=article2.getExample()%>
        </div>
    </div>

    <% } %>
</div>
</body>
</html>