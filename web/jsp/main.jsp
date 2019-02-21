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
    <% ArrayList<TopicBin> topics = (ArrayList) request.getAttribute("Topics");
        for (TopicBin topic : topics) { %>
    <div class="article">
        <div>
            <a href="#" name="article_name"><h2><%=topic.getTitle()%>
            </h2></a>
        </div>
        <div>
            <p><%="Cia bus tekstas arba nebus :)"%>
            </p>
        </div>
    </div>
    <% } %>

</div>

</body>
</html>
