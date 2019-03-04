<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.beans.TopicBean" %>
<%@ page import="controllers.ArticleController" %>
<%@ page import="models.DTO.TopicDTO" %>
<html>
<head>
</head>

<body>
<div class="middle">
    <%
                    ArrayList<TopicBean> topics = (ArrayList<TopicBean>) ((TopicDTO) request.getAttribute("topicDTO")).getTopicsList();
                    for (TopicBean topic : topics) {
                %>
                <div class="article">
                    <div>
                        <a href="article?id=<%=topic.getId()%>" name="article_name"><h2><%=topic.getTitle()%>
                        </h2></a>
                    </div>
                </div>
            <% } %>
        </div>
    </body>
</html>