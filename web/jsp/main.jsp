<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.beans.TopicBean" %>
<%@ page import="model.DTO.TopicDTO" %>
<html>
<head>
</head>

<body>
<div class="card-body">
    <div class="list-group">
        <%
            ArrayList<TopicBean> topics = (ArrayList<TopicBean>) ((TopicDTO) request.getAttribute("topicDTO")).getTopicsList();
            for (TopicBean topic : topics) {
        %>

        <a class="list-group-item list-group-item-action" href="article?id=<%=topic.getId()%>"
           name="article_name"><%=topic.getTitle()%>
        </a>

        <% } %>
    </div>
</div>
</body>
</html>