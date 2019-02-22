<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.TopicBin" %>
<html>
<head>
</head>
<jsp:useBean id="search" class="models.Search"
             scope="request"></jsp:useBean>

<body>

<div class="middle">
    <form method="get" id="article" action="article.jsp">
        <% ArrayList<TopicBin> topics = (ArrayList) request.getAttribute("Topics");
            for (TopicBin topic : topics) { %>
        <div class="article">
            <div>
                <Input type="Hidden" name="id"  id="id" value="<%=topic.getId()%>">
                <Input type="Hidden" name="title"  id="title" value="<%=topic.getTitle()%>">
                <a href="article.jsp" name="article_name"><h2><%=topic.getTitle()%>
                </h2></a>
            </div>
        </div>
    </form>
    <% } %>

</div>
</body>
</html>
