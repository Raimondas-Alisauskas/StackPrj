<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beans.ArticleBean" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
</head>
<body>
<% ArrayList<ArticleBean> articles = (ArrayList) request.getAttribute("article");%>
<h1>Article description</h1>
<p>Article title: <%=articles.get(0).getTitle()%>
</p>
<button type="button" class="button button--ghost button--ghost--green" onclick="history.back()">Go back to articles
</button>
<div class="middle">
    <%for (ArticleBean articleBean2 : articles) { %>
    <div class="example">
        <div>
            <%=articleBean2.getExample()%>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>